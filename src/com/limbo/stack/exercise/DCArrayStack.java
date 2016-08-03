package com.limbo.stack.exercise;

import java.util.Iterator;

/**
 * Created by Break.D on 8/3/16.
 */
public class DCArrayStack<Item> implements Iterable<Item> {

    private Item[] items;
    private int N;

    public DCArrayStack() {
        items = (Item[]) new Object[1];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void resize(int max) {
        Item[] tmp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            tmp[i] = items[i];
        }
        items = tmp;
    }

    public void push(Item item) {
        if (N == items.length) resize(2 * items.length);
        items[N++] = item;
    }

    public Item pop() {
        if (isEmpty()) {
            System.out.println("error!");
            return null;
        }
        Item item = items[--N];
        items[N] = null;
        if (N <= items.length / 4) resize(items.length / 2);
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DCArrayStackIterator();
    }

    private class DCArrayStackIterator implements Iterator<Item> {
        int x = N;
        @Override
        public boolean hasNext() {
            return x > 0;
        }

        @Override
        public Item next() {
            return items[--x];
        }
    }
}
