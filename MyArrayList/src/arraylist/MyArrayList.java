package arraylist;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] items;
    private int size;
    private int modCount;

    public MyArrayList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Размер не может быть отрицательным!");
        }
        //noinspection unchecked
        items = (T[]) new Object[size];
    }

    private class MyListIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int currentModCount = modCount;

        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("следующего элемента нет");
            }

            if (currentModCount != modCount) {
                throw new ConcurrentModificationException("размер коллекции был изменен");
            }

            currentIndex++;
            return items[currentIndex];
        }
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2 + 1);
    }

    public void ensureCapacity(int capacity) {
        if (capacity > items.length) {
            items = Arrays.copyOf(items, capacity);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] ts) {
        if (ts == null) {
            throw new IllegalArgumentException("Переданный массив не может быть null");
        }

        if (ts.length < size) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(items, size, ts.getClass());
        }

        System.arraycopy(items, 0, ts, 0, size);

        if (ts.length > size) {
            ts[size] = null;
        }


        return ts;
    }

    @Override
    public boolean add(T e) {
        if (size == items.length) {
            increaseCapacity();
        }

        items[size] = e;
        size++;
        modCount++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, items[i])) {
                remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object e : collection) {
            if (!contains(e)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return addAll(size, collection);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс задан неверно!");
        }

        if (collection.size() == 0) {
            return false;
        }

        int newSize = size + collection.size();
        if (newSize > items.length) {
            ensureCapacity(newSize);
        }

        if (index != size) {
            System.arraycopy(items, index, items, index + collection.size(), size - index);
        }

        int i = index;
        for (T e : collection) {
            items[i] = e;
            i++;
        }

        modCount++;
        size = newSize;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection.size() == 0) {
            return false;
        }

        boolean isRemoved = false;
        for (int i = 0; i < size; i++) {
            if (collection.contains(items[i])) {
                remove(i);
                i--;
                isRemoved = true;
            }
        }

        return isRemoved;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        boolean isRemoved = false;

        for (int i = 0; i < size; i++) {
            if (!collection.contains(items[i])) {
                remove(i);
                i--;
                isRemoved = true;
            }
        }

        return isRemoved;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;

        modCount++;
    }

    @Override
    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("неверный индекс");
        }

        return items[i];
    }

    @Override
    public T set(int i, T e) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("неверный индекс");
        }

        T prev = items[i];
        items[i] = e;

        return prev;
    }

    @Override
    public void add(int i, T e) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("неверный индекс");
        }

        if (size == items.length) {
            increaseCapacity();
        }
        System.arraycopy(items, i, items, i + 1, size - i);

        items[i] = e;
        size++;
        modCount++;
    }

    @Override
    public T remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("неверный индекс");
        }

        T removedElement = items[i];

        System.arraycopy(items, i + 1, items, i, size - i - 1);
        size--;
        modCount++;

        return removedElement;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, items[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(o, items[i])) {
                return i;
            }
        }

        return -1;
    }

    public void trimToSize() {
        if (size != items.length) {
            items = Arrays.copyOf(items, size);
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");

        if (isEmpty()) {
            builder.append("]");
            return builder.toString();
        }

        for (int i = 0; i < size; i++) {
            builder.append(items[i]);
            builder.append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append("]");

        return builder.toString();
    }
}
