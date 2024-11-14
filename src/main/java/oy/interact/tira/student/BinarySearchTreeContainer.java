package oy.interact.tira.student;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.function.Predicate;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedOrderedContainer;
import oy.interact.tira.util.Visitor;


public class BinarySearchTreeContainer<K extends Comparable<K>, V> implements TIRAKeyedOrderedContainer<K, V> {

    private TreeNode<K, V> root;
    private int count;
    private Comparator<K> comparator;
    BinarySearchTreeContainer() {
        root = null;
        count = 0;
    }

    

    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        if(root == null) {
            root = new TreeNode<K, V>(key, value);
            count++;
        } else {
            root.insert(key, value, comparator);
            count++;
        }
    }

    @Override
    public V get(K key) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V find(Predicate<V> searcher) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public int size() {
       return count;
    }

    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void ensureCapacity(int capacity) throws OutOfMemoryError, IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ensureCapacity'");
    }

    @Override
    public void clear() {
        root = null;
        count = 0;
    }

    @Override
    public Pair<K, V>[] toArray() throws Exception {
        if(root == null) {
            return (Pair<K, V>[]) Array.newInstance(Pair.class, 0);
        }
        Pair<K, V>[] array = (Pair<K, V>[]) Array.newInstance(Pair.class, count);
        return array;
    }

    @Override
    public int indexOf(K itemKey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }

    @Override
    public Pair<K, V> getIndex(int index) throws IndexOutOfBoundsException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIndex'");
    }

    @Override
    public int findIndex(Predicate<V> searcher) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findIndex'");
    }

    @Override
    public void accept(Visitor<K, V> visitor) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }

   

}
