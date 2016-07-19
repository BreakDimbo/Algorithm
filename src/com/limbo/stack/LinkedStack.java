package com.limbo.stack;

/**
 * Created by Break.D on 7/14/16.
 */
public class LinkedStack<Item> {
    private Node first;
    private int N;

    class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(Item item) {
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
        N++;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

}
