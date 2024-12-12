package oy.interact.tira.student;


import java.util.Comparator;
import java.util.function.Predicate;

import oy.interact.tira.util.Pair;
import oy.interact.tira.util.TIRAKeyedOrderedContainer;
import oy.interact.tira.util.Visitor;


public class BinarySearchTreeContainer<K extends Comparable<K>, V> implements TIRAKeyedOrderedContainer<K, V> {

    private TreeNode<K, V> root;
    private int count;
    private int maxCount = Integer.MAX_VALUE;
    private Comparator<K> comparator;
    public BinarySearchTreeContainer(Comparator<K> comparator) {
        root = null;
        count = 0;
        this.comparator = comparator;
    }

    

    @Override
    public void add(K key, V value) throws OutOfMemoryError, IllegalArgumentException {
        if (root == null) {
            root = new TreeNode<>(key, value);
            count++;  
        } else {
            boolean result = root.insert(key, value, comparator);
            if (result) {
                count++;  
            }
        }
    }
    




    @Override
    public V get(K key) throws IllegalArgumentException {
        if(root == null) {
            return null; 
        } return root.get(key, comparator);
    }

    @Override
    public V remove(K key) throws IllegalArgumentException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public V find(Predicate<V> searcher) {
        return findRecursive(root, searcher);
    }

    private V findRecursive(TreeNode<K, V> node, Predicate<V> searcher) {
        if (node == null) {
            return null; 
        }

        V value = node.getValue();

        
        if (value != null && searcher.test(value)) {
            return value;
        }

        // Search in left and right subtrees.
        V found = findRecursive(node.getLeftChild(), searcher);
        if (found != null) {
            return found; // Return if found in left subtree.
        }

        return findRecursive(node.getRightChild(), searcher); // Check right subtree.
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
        if(capacity > Integer.MAX_VALUE) {
            throw new OutOfMemoryError();
        } else if(capacity <= 0 && capacity < count) {
            throw new IllegalArgumentException();
        }
        maxCount = capacity;
    }

    @Override
    public void clear() {
        root = null;
        count = 0;
    }

    @Override
    public Pair<K, V>[] toArray() throws Exception {
        if (root == null) {
            return (Pair<K, V>[]) new Pair[0];
        }

        @SuppressWarnings("unchecked")
        Pair<K, V>[] array = (Pair<K, V>[]) new Pair[count];

        inOrderTraversal(root, array, new int[]{0});

        return array;
    }

    
    
    private void inOrderTraversal(TreeNode<K, V> node, Pair<K, V>[] array, int[] index) {
        if (node != null) {
            inOrderTraversal(node.getLeftChild(), array, index);
            array[index[0]] = new Pair<>(node.getKey(), node.getValue());
            index[0]++; 
            inOrderTraversal(node.getRightChild(), array, index);
        }
    }
    

    @Override
    public int indexOf(K itemKey) {
        if(root == null) {
            return -1;
        }
        int index = 0;
        TreeNode<K, V> current = root;
        TreeNode<K, V> parent = null;
        StackImplementation<TreeNode<K, V>> nodeStack = new StackImplementation<TreeNode<K, V>>();

        while(!nodeStack.isEmpty() || current != null) {
            if(current != null) {
                nodeStack.push(current);
                parent = current;
                current = current.getLeftChild();
            } else {
                parent = nodeStack.pop();
                current = parent.getRightChild();
                if(parent.getKey().equals(itemKey)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    @Override
public Pair<K, V> getIndex(int index) throws IndexOutOfBoundsException {
    if (index < 0 || index >= count) {
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
    }

    return getIndexHelper(root, new int[]{0}, index);
}

private Pair<K, V> getIndexHelper(TreeNode<K, V> node, int[] currentIndex, int targetIndex) {
    if (node == null) {
        return null;
    }

    
    Pair<K, V> leftResult = getIndexHelper(node.getLeftChild(), currentIndex, targetIndex);
    if (leftResult != null) {
        return leftResult;
    }

    
    if (currentIndex[0] == targetIndex) {
        return new Pair<>(node.getKey(), node.getValue());
    }
    currentIndex[0]++;

    
    return getIndexHelper(node.getRightChild(), currentIndex, targetIndex);
}

@Override
public int findIndex(Predicate<V> searcher) {
    return findIndexHelper(root, searcher, new int[]{0});
}

private int findIndexHelper(TreeNode<K, V> node, Predicate<V> searcher, int[] currentIndex) {
    if (node == null) {
        return -1;
    }

    
    int leftResult = findIndexHelper(node.getLeftChild(), searcher, currentIndex);
    if (leftResult != -1) {
        return leftResult;
    }

    
    if (searcher.test(node.getValue())) {
        return currentIndex[0];
    }
    currentIndex[0]++;

    return findIndexHelper(node.getRightChild(), searcher, currentIndex);
}


    @Override
    public void accept(Visitor<K, V> visitor) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'accept'");
    }

   

}
