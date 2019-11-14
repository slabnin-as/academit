package arraylist;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private E[] items;
    private int size;
    private int modCount = 0;

    public MyArrayList(int size) {
        //noinspection unchecked
        items = (E[]) new Object[size];
    }

    private class MyListIterator implements Iterator<E> {
        private int currentIndex = -1;
        private int currentModCount = modCount;

        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        public E next() {
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
    public Iterator<E> iterator() {
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
    public boolean add(E e) {
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
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.size() == 0) {
            return false;
        }

        int newSize = size + collection.size();
        if (newSize >= items.length) {
            ensureCapacity();
        }

        for (E e : collection) {
            add(e);
        }

        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends E> collection) {
        if (collection.size() == 0) {
            return false;
        }

        int newSize = size + collection.size();
        if (newSize >= items.length) {
            ensureCapacity();
        }

        for (E e : collection) {
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
        items = (E[]) new Object[0];
        size = 0;
    }

    @Override
    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("неверный индекс");
        }

        return items[i];
    }

    @Override
    public E set(int i, E e) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("неверный индекс");
        }
        E prev = items[i];
        items[i] = e;

        return prev;
    }

    @Override
    public void add(int i, E e) {
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
    public E remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("неверный индекс");
        }

        E removedElement = items[i];

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
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        return null;
    }

    @Override
    public List<E> subList(int i, int i1) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(items[i]);
            builder.append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append("]");

        return builder.toString();
    }
}
