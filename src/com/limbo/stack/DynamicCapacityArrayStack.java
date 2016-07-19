package com.limbo.stack;

import java.util.Iterator;

/**
 * Created by Break.D on 7/14/16.
 */
public class DynamicCapacityArrayStack<Item> implements Iterable<Item>{
    private Item[] items = (Item[]) new Object[1];
    private int N = 0;

    /*
    public DynamicCapacityArrayStack(int cap) {
        items = (Item[]) new Object[cap];
    }
    */

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

   /*
   for fixed test

   public void push(Item item) {
        items[N++] = item;
    }

   public Item pop() {
        Item item = items[--N];
        //防止元素游离
        items[N] = null;
        return item;
    }
   */

    public void resize(int max) {
        Item[] temp = (Item[]) new Object[max];

        for(int i=0; i<N; i++) {
            temp[i] = items[i];
        }

        items = temp;
    }

    public void push(Item item) {
        if (N == items.length) {
            resize(2*items.length);
        }
        items[N++] = item;
    }

    public Item pop() {
        Item item = items[--N];
        items[N] = null;
        if (N <= items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DynamicCapacityStackIterator();
    }

    private class DynamicCapacityStackIterator implements Iterator<Item> {
        private int x = N;

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
