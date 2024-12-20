package oy.interact.tira.student;

import java.util.function.Predicate;



import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedContainer;

public class HashTableContainer<K extends Comparable<K>,V> implements TIRAKeyedContainer<K,V>  {

    private Pair<K, V> [] array;
    private int count;
    private int DEFAULT_HASHTABLE_SIZE = 16;
    private double factor = 0.65;

    @SuppressWarnings("unchecked")
    public HashTableContainer() {
        this.array = new Pair[DEFAULT_HASHTABLE_SIZE];
        count = 0;
    }

    public HashTableContainer(int capacity) {
        this.array = new Pair[DEFAULT_HASHTABLE_SIZE];
        count = 0;
    }


    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        int collisionCounter = 0;
        

        if(count >= array.length * factor) {
            reallocate();
        }

        int hash = key.hashCode();

        boolean added = false;

        while(!added) {
            int index = indexFor(hash, collisionCounter);
            if(array[index] == null) {
                array[index] = new Pair<K, V>(key, value);
                count++;
                added = true;
            } else if(array[index].getKey().equals(key)) {
                array[index].setValue(value);
                added = true;
            } else {
                collisionCounter++;
            }
        }
    }

    int indexFor(int hash, int collisionCounter) {
        return ((hash + collisionCounter) & 0x7FFFFFFF) % array.length;
    }
    
    private void reallocate() {
        Pair<K,V>[] oldArray = this.array;
        int oldArrayLength = this.array.length;
        
        Pair<K,V>[] newArray = (Pair<K, V>[]) new Pair[oldArrayLength * 2];
        array = newArray;
        DEFAULT_HASHTABLE_SIZE *= 2;
        count = 0;
        for(int index = 0; index < oldArrayLength; index++) {
            if(oldArray[index] != null) {
                add(oldArray[index].getKey(), oldArray[index].getValue());
            }
        }
    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        V valueFound = null;
        int collisionCounter = 0;
        int hash = key.hashCode();
        boolean looping = true;

        while(looping) {
            int index = indexFor(hash, collisionCounter);
            Pair<K, V> keyValue = array[index];
            if(keyValue == null) {
                looping = false;
            } else if(key.equals(keyValue.getKey())) {
                valueFound = keyValue.getValue();
                looping = false;
            } else {
                collisionCounter++;
            }
        } return valueFound;
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public V find(Predicate<V> searcher) {
        for (Pair<K, V> pair : array) {
            if (pair != null && searcher.test(pair.getValue())) {
                return pair.getValue();
            }
        }
        return null;
    }
    @Override
    public int size() {
        return count;
    }

    @Override
    public int capacity() {
        return DEFAULT_HASHTABLE_SIZE;
    }

    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        if (capacity < array.length) {
            throw new IllegalArgumentException("Capacity must be greater than the current size.");
        }

        Pair<K, V>[] oldArray = array;
        DEFAULT_HASHTABLE_SIZE = capacity;
        array = (Pair<K, V>[]) new Pair[DEFAULT_HASHTABLE_SIZE];
        count = 0;

        for (Pair<K, V> pair : oldArray) {
            if (pair != null) {
                add(pair.getKey(), pair.getValue());
            }
        }
    }
    @Override
    public void clear() {
        array = (Pair<K, V>[]) new Pair[DEFAULT_HASHTABLE_SIZE];
        count = 0;
    }

    @Override
    public Pair<K, V>[] toArray() throws Exception {
        Pair<K, V>[] result = (Pair<K, V>[]) new Pair[count];
        int index = 0;

        for (Pair<K, V> pair : array) {
            if (pair != null) {
                if (index >= count) {
                    throw new Exception("Unexpected index overflow in toArray");
                }
                result[index++] = pair;
            }
        }

        if (index != count) {
            throw new Exception("Mismatch between expected and actual count in toArray");
        }

        return result;
    }

    
}
