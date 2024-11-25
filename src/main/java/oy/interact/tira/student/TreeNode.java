package oy.interact.tira.student;

import java.util.Comparator;

import oy.interact.tira.util.Pair;

class TreeNode<K, V> {
    private Pair<K, V> keyValue;
    private TreeNode<K, V> leftChild;
    private TreeNode<K, V> rightChild;
    private TreeNode<K, V> parent;


    public TreeNode(K key, V value) {
        this.keyValue = new Pair<K, V>(key, value);
        leftChild = null;
        rightChild = null;
        parent = null;
    }

    boolean insert(K key, V value, Comparator<K> comparator) {
        boolean result = false;
        if (value.equals(this.keyValue.getValue())) {
            this.keyValue.setValue(value);
            return result; 
        }
    
        
        if (comparator.compare(key, this.keyValue.getKey()) < 0) {
            if (leftChild == null) {
                leftChild = new TreeNode<>(key, value);
                leftChild.parent = this;
                result =  true; 
            } else {
                result =  getLeftChild().insert(key, value, comparator);
            }
        } else {
            if (rightChild == null) {
                rightChild = new TreeNode<>(key, value);
                rightChild.parent = this;
                result =  true; 
            } else {
                result =  getRightChild().insert(key, value, comparator);
            }
        }
        return result;
    }
    
    
    public void setValue(V value) {
        keyValue.setValue(value);
    }
    public void setKey(K key) {
        keyValue.setKey(key);
    }
    public K getKey() {
        return keyValue.getKey();
    }
    public V getValue() {
        return keyValue.getValue();
    }
    public TreeNode<K, V> getParent() {
        return parent;
    }
    public TreeNode<K, V> getLeftChild() {
        return leftChild;
    }

    public TreeNode<K, V> getRightChild() {
        return rightChild;
    }

    public V get(K key, Comparator<K> comparator) {
        if (comparator.compare(key, keyValue.getKey()) == 0) {
            return this.keyValue.getValue(); // Found the value, return it.
        }
    
        if (comparator.compare(key, this.keyValue.getKey()) < 0) {
            // Key is smaller, search in the left child.
            if (leftChild != null) {
                return leftChild.get(key, comparator);
            }
        } else {
            // Key is greater, search in the right child.
            if (rightChild != null) {
                return rightChild.get(key, comparator);
            }
        }
    
        return null; // Key not found in the tree.
    }
    
    
}
 