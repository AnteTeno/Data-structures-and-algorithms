package oy.interact.tira.student;



import oy.interact.tira.util.QueueInterface;



public class QueueImplementation<E> implements QueueInterface<E> {

    private Object [] arrayQueue;
    private int defaultArraySize = 10;
    private int tail;
    private int head;
    private int elements;


    //Konstruktorit
    public QueueImplementation() {
        arrayQueue = new Object[defaultArraySize];
        tail = 0;
        head = 0;
        elements = 0;
    }

    public QueueImplementation(int size) {
        arrayQueue = new Object[size];
        tail = 0;
        head = 0;
        elements = 0;
    }

    private void reallocate() throws OutOfMemoryError{
        Object [] newQueueArray = new Object[arrayQueue.length * 2];
        int newTail = 0;
        for(int i = head; i < arrayQueue.length; i++) {
            newQueueArray[newTail] = arrayQueue[i];
            newTail++;
        }

        for(int i = 0; i < head; i++) {
            newQueueArray[newTail] = arrayQueue[i];
            newTail++;
        }

        arrayQueue = newQueueArray;
        head = 0;
        tail = newTail;
    }

    @Override
    public int capacity() {
        return arrayQueue.length;
    }

    @Override
    public void enqueue(E element) throws OutOfMemoryError, NullPointerException {
        if(element == null) {
            throw new NullPointerException("Cannot add element that is null.");
        }

        if(size() == arrayQueue.length) {
            reallocate();
        }

        arrayQueue[tail] = element;
        tail = (tail + 1) % arrayQueue.length;
        elements++;
    }

    @Override
    public E dequeue() throws IllegalStateException {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        } 

        E queueValue = (E) arrayQueue[head];
        arrayQueue[head] = null;
        head = (head + 1) % arrayQueue.length;
        elements--;

        return queueValue;
    }

    
    @Override
    public E element() throws IllegalStateException {
        if(isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        return (E) arrayQueue[head];
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public boolean isEmpty() {
        if(elements == 0) {
            return true;
        } return false;
    }

    @Override
    public void clear() {
        arrayQueue = new Object[defaultArraySize];
        elements = 0;
        head = 0;
        tail = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        if(!isEmpty()) {
            if(head < tail) {
                for(int i = head; i < tail; i++) {
                    str.append(arrayQueue[i]);
                    if(i < tail - 1) {
                        str.append(", ");
                    }
                }
            } else {
                for(int i = head; i < arrayQueue.length; i++) {
                    str.append(arrayQueue[i]);
                    if(tail == 0 && i == arrayQueue.length - 1) {
                        continue;
                    } str.append(", ");
                }
                for(int j = 0; j < tail; j++) {
                    str.append(arrayQueue[j]);
                    if(j == tail - 1) {
                        continue;
                    } str.append(", ");
                }
            }
        }
        
        
        
        str.append("]");
        return str.toString();
    }
    
}
