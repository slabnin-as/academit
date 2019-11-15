package hashtable;

import java.util.*;

public class MyHashTable<T> implements Collection<T> {
    private ArrayList<T>[] hashTable;
    private int size;

    public MyHashTable() {
        hashTable = new ArrayList[11];
        size = 0;
    }

    public MyHashTable(int length) {
        hashTable = new ArrayList[length];
        size = 0;
    }


    private int getIndex(Object o) {
        return o.hashCode() % hashTable.length;
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
        int index = getIndex(o);

        return hashTable[index].contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(hashTable, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        if (t1s.length < size) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(hashTable, size, t1s.getClass());
        }

        System.arraycopy(hashTable, 0, t1s, 0, size);

        return t1s;
    }

    @Override
    public boolean add(T t) {
        int index = getIndex(t);

        if (hashTable[index] == null) {
            hashTable[index] = new ArrayList<>();
        }

        hashTable[index].add(t);
        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = getIndex(o);

        if(hashTable[index] == null){
            return false;
        }

        hashTable[index].remove(o);
        size--;

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for(Object o : collection){
            if(!contains(o)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        if(collection.size() == 0){
            return false;
        }

        for(T e : collection){
            add(e);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }
}
