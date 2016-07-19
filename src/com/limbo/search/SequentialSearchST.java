package com.limbo.search;

/**
 * Created by Break.D on 7/15/16.
 */
public class SequentialSearchST<Key, Value> {
    private Node first;
    private int N = 0;

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

    public int size() {
        return N;
    }

    public void delete(Key key) {
        put(key , null);
    }

    //根据给定的键,查找相应的键,找到后返回对应的值,否则返回 null
    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key == key)
                return x.val;
        }

        return null;
    }

    //根据给定的键,如果找到对应的键,更新值,返回 true。没找到,添加这个值,返回 false
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
