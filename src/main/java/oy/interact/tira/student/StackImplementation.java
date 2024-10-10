package oy.interact.tira.student;


import oy.interact.tira.util.StackInterface;

public class StackImplementation<E> implements StackInterface<E> {
    
    private Object [] itemArray;
    private static final int DEFAULT_STACK_SIZE = 20;
    private int count = 0;
    
    public StackImplementation() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
    }

    public StackImplementation(int size) {
        itemArray = new Object[size];
    }


    @Override
    public int capacity() {
        return itemArray.length;
    }

    private void reallocate() throws OutOfMemoryError {
		Object [] newItemArray = new Object[itemArray.length * 2];
		for (int index = 0; index < count; index++) {
			newItemArray[index] = itemArray[index];
		}
		itemArray = newItemArray;
	}

    @Override
    public void push(E element) throws OutOfMemoryError, NullPointerException {
        if(element == null) {
            throw new NullPointerException("Key cannot be null");
        }
        if (count >= itemArray.length) {
            reallocate();
        }
        itemArray[count] = element;
        count++;

        
    }

    @SuppressWarnings("unchecked")
    @Override
    public E pop() throws IllegalStateException {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } 
        count--;
        Object temp = itemArray[count];
        itemArray[count] = null;
        return (E)temp;

    }

    @SuppressWarnings("unchecked")
    @Override
    public E peek() throws IllegalStateException {
        if(isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (E)itemArray[count - 1];
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return (itemArray[0] == null);
    }
    



    @Override
    public void clear() {
        itemArray = new Object[DEFAULT_STACK_SIZE];
        count = 0;
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for(int i = 0; i < count; i++) {
            str.append(itemArray[i].toString());
            if(i < count - 1) {
                str.append(", ");
            }
        } 
        str.append("]");
        return str.toString();
    }
}