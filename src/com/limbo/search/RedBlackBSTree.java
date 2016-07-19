package com.limbo.search;

/**
 * Created by Break.D on 7/17/16.
 */
public class RedBlackBSTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        boolean color;
        int N;

        public Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.N = N;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    public Node leftRotate(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.right) + size(h.left) + 1;
        return x;
    }

    public Node rightRotate(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    public void flipColor(Node h) {
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return size(x.left) + size(x.right) + 1;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left, key, val);
        else if (cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        //for 3-2 tree's rotate
        if (isRed(h.right) && !isRed(h.left)) h = leftRotate(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rightRotate(h);
        if (isRed(h.right) && isRed(h.left)) flipColor(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

}
