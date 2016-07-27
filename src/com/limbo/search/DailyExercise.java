package com.limbo.search;

/**
 * Created by Break.D on 7/21/16.
 */
public class DailyExercise {
    public static void main(String[] args) {

        SequentialSearch<Integer, String> ss = new SequentialSearch<>();

        for (int i = 0; i < 30; i++) {
            int j = (int) (Math.random() * 30);
            ss.put(1, "str" + j);
        }
        System.out.println(ss.get(1));
        System.out.println(ss.get(2));
    }
}


class SequentialSearch<Key extends Comparable<Key>, Value> {
    private Node first;
    private int N;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key == key) {
                return x.val;
            }
        }

        return null;
    }

    public boolean put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key == key) {
                x.val = value;
                return true;
            }
        }
        first = new Node(key, value, first);
        N++;
        return false;
    }

}

class BinarySearchMap<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;

    public BinarySearchMap(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }


    public Value get(Key key) {
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) {
            return values[i];
        }
        return null;
    }

    private int rank(Key key) {
        int n = keys.length - 1;
        return rank(key, 0, n);
    }

    private int rank(Key key, int lo, int hi) {
        if (lo > hi) return lo;
        int mid = lo + (hi - lo) / 2;
        if (key.compareTo(keys[mid]) > 0) {
            return rank(key, mid + 1, hi);
        }
        else if (key.compareTo(keys[mid]) < 0) {
            return rank(key, lo, mid - 1);
        }
        else return mid;
    }


    public boolean put(Key key, Value value) {
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) {
            values[i] = value;
            return true;
        }

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }

        keys[i] = key;
        values[i] = value;
        N++;

        return false;
    }

   /*
    递归实现
   public int rank(Key key) {
        int lo = 0;
        int hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp > 0) lo = mid + 1;
            else if (cmp < 0) hi = mid - 1;
            else return mid;
        }

        return lo;
    }
    */

}