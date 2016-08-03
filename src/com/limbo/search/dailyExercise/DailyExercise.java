package com.limbo.search.dailyExercise;

/**
 * Created by Break.D on 7/21/16.
 */
public class DailyExercise {
    public static void main(String[] args) {

        BinarySearchTree<Integer, String> ss = new BinarySearchTree<>();

        for (int i = 0; i < 30; i++) {
            int j = (int) (Math.random() * 30);
            ss.put(j, "str" + j);
        }

        for (int j = 0; j < 30; j++) {
            System.out.print(ss.get(j) + " ");
        }

        System.out.println();
        System.out.println(ss.min());
        System.out.println(ss.floor(6));


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
        } else if (key.compareTo(keys[mid]) < 0) {
            return rank(key, lo, mid - 1);
        } else return mid;
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


class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return get(x.right, key);
        else if (cmp < 0) return get(x.left, key);
        else return x.val;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.val = value;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Value min() {
        return min(root).val;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else return min(x.left);
    }

    public Value max() {
        return max(root).val;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        else return max(x.right);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);

        Node t = floor(x.right, key);
        if (t != null) return t;
        return x;

    }

    public Key rank() {
        return null;
    }

    public int select(Key key) {
        return 0;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        root = delete(key, root);
    }

    private Node delete(Key key, Node x) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(key, x.left);
        else if (cmp > 0) x.right = delete(key, x.right);
        else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    //范围查找

}

class RedBlackTree<Key extends Comparable<Key>, Value> {
    private final static boolean RED = true;
    private final static boolean BLACK = false;

    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left, right;
        int N;
        boolean color;

        public Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.value =val;
            this.color =color;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isRed(Node x) {
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
        h.N = size(h.right) + size(h.left) + 1;
        return x;
    }

    public void flipColor(Node x) {
        x.left.color = BLACK;
        x.right.color = BLACK;
        x.color = RED;
    }

    public void put(Key key, Value value) {
        root = put(key, value, root);
        root.color = BLACK;
    }

    private Node put(Key key, Value value, Node x) {
        if (x == null) return new Node(key, value, 1, RED);

        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(key, value, x.left);
        else if (cmp > 0) x.right = put(key, value, x.right);
        else x.value = value;

        if (!isRed(x.left) && isRed(x.right)) x = leftRotate(x);
        if (isRed(x.left) && isRed(x.left.left)) x = rightRotate(x);
        if (isRed(x.left) && isRed(x.left)) flipColor(x);

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node x) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(key, x.left);
        else if (cmp > 0) return get(key, x.right);
        else return x.value;
    }




    // 实现 delete 方法
    public void delete(Key key) {

    }


}