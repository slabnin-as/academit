package arraylist;

import java.util.*;

public class MyArrayList<T> implements List<T> {
    private T[] items;
    private int size;
    private int modCount = 0;

    public MyArrayList(int size) {
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

    private void ensureCapacity() {
        items = Arrays.copyOf(items, size * 2 + 1);
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
    public <T> T[] toArray(T[] ts) {
        if (ts.length < size) {
            //noinspection unchecked
            return (T[]) Arrays.copyOf(items, size, ts.getClass());
        }

        System.arraycopy(items, 0, ts, 0, size);

        return ts;
    }

    @Override
    public boolean add(T e) {
        if (size == items.length) {
            ensureCapacity();
        }

        items[size] = e;
        size++;
        modCount++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(items[i])) {
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
        if (collection.size() == 0) {
            return false;
        }

        int newSize = size + collection.size();
        if (newSize >= items.length) {
            ensureCapacity();
        }

        for (T e : collection) {
            add(e);
        }

        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        if (collection.size() == 0) {
            return false;
        }

        int newSize = size + collection.size();
        if (newSize >= items.length) {
            ensureCapacity();
        }

        for (T e : collection) {
            add(i, e);
            i++;
        }

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
        if (collection.size() == 0) {
            clear();
            return true;
        }

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
        //noinspection unchecked
        items = (T[]) new Object[0];
        size = 0;
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
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("неверный индекс");
        }

        if (size == items.length) {
            ensureCapacity();
        }
        System.arraycopy(items, i, items, i + 1, size + 1 - i);

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
            if (o.equals(items[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (o.equals(items[i])) {
                return i;
            }
        }

        return -1;
    }

    public void trimToSize() {
        items = Arrays.copyOf(items, size);
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
