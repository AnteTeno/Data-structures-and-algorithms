package oy.interact.tira.student;

import oy.interact.tira.util.QueueInterface;

public class LinkedListQueue<E> implements QueueInterface<E> {


    

    private class Node<T> {
       T data;
       Node<T> next;
       Node<T> previous;
 
       public Node(T data) {
          this.data = data;
       }
    }
 
    private Node<E> head;
    private Node<E> tail;
    private int size;


    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void enqueue(E element) throws OutOfMemoryError, NullPointerException {
        if(element == null) {
            throw new NullPointerException("Element cant be null.");
        }

        Node<E> newNode = new Node<>(element);

        if(tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public E dequeue() throws IllegalStateException {
        /*First checks if LinkedList is empty, if so throws an error.
         * Takes the data from the head of queue and sets head at the next element in the queue.        
         * Checks if head is null if so then queue is empty so we set the tail as null also, else we set the previous value at head to null.
         * Lastly deduct one from size.
         */

        if(isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }

        E dequeuedData = head.data;
        head = head.next;

        if(head != null) {
            head.previous = null;
        } else {
            tail = null;
        }
 
        size--;
        return dequeuedData;
    }

    @Override
    public E element() throws IllegalStateException {
        if(isEmpty()) {
            throw new IllegalStateException("The queue is empty");
        }
        
        return head.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");

        Node<E> current = head;

        while(current != null) {
            str.append(current.data);
            current = current.next;
            if(current != null) {
                str.append(", ");
            }
        }

        str.append("]");
        return str.toString();

    }
    
}
