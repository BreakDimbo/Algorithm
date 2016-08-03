package com.limbo.search.dailyExercise;

/**
 * Created by Break.D on 8/3/16.
 */
public class DailyExercise6 {

    public static void main(String[] args) {

        BinarySearchTree6<Integer, String> ss = new BinarySearchTree6<>();
        ss.put(1, "1");
        ss.put(2, "二");
        ss.put(3, "ss");

        System.out.println(ss.get(1));

    }
}

/**
 * 无序链表遍历搜索
 * @param <Key>
 * @param <Value>
 */

class SequencialSearch6<Key extends Comparable<Key>, Value> {
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

    public int size() {
        return N;
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    public boolean put(Key key, Value val) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return true;
            }
        }
        first = new Node(key, val, first);
        N++;
        return false;
    }
}

/**
 * 有序数组二分法搜索
 * @param <Key>
 * @param <Value>
 */
class BinarySearchMap6<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N = 0;

    public BinarySearchMap6(int max) {
        keys = (Key[]) new Comparable[max];
        values = (Value[]) new Object[max];
    }


    public Value get(Key key) {
        int i = rank(key);
        if (i < N && key.equals(keys[i])) {
            return values[i];
        }
        return null;
    }

    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < N && key.equals(keys[i])) {
            values[i] = value;
        } else {
            //将所有i之后的元素向后移动一格
            for (int k = N; k > i; k--) {
                keys[k] = keys[k - 1];
            }

            keys[i] = key;
            values[i] = value;
            N++;
        }
    }

    private int rank(Key key) {
        int n = N - 1;
        return rank(key, 0, n);
    }

    private int rank(Key key, int lo, int hi) {
        if (lo >= hi) return lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) return rank(key, lo, mid);
        else if (cmp > 0) return rank(key, mid + 1, hi);
        else return mid;
    }

   /* 递归实现
   private int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }*/
}

class BinarySearchTree6<Key extends Comparable<Key>, Value> {

    //根节点
    private Node root;

    private class Node {
        Key key;
        Value val;
        Node left, right;
        int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
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

    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node x) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(key, x.left);
        else if (cmp > 0) return get(key, x.right);
        else return x.val;
    }

    public void put(Key key, Value val) {
        root = put(key, val, root);
    }

    private Node put(Key key, Value val, Node x) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(key, val, x.left);
        else if(cmp > 0) x.right = put(key, val, x.right);
        else x.val = val;

        x.N = size(x.right) + size(x.left) + 1;
        return x;
    }

    public Value min() {
        return min(root).val;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    public void delMin() {
        root = delMin(root);
    }

    private Node delMin(Node x) {
        if (x.left == null) return x.right;
        x.left = delMin(x.left);
        x.N = size(x.right) + size(x.left) + 1;
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
            x.right = delMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.right) + size(x.left) + 1;
        return x;
    }


}