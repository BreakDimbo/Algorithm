package com.limbo.stack;

import java.util.Iterator;

/**
 * Created by Break.D on 7/14/16.
 */
public class LinkedQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N = 0;

    @Override
    public Iterator<Item> iterator() {
        return new LinkedQueueIterator();
    }

    class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return  N;
    }

    //FIFO
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    private class LinkedQueueIterator implements Iterator<Item> {
        Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
