package com.limbo.search;

/**
 * Created by Break.D on 7/15/16.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    //数据结构:两个平行数组,一个记录 key,另一个记录 val
    private Key[] keys;
    private Value[] vals;
    private int N = 0;

    public BinarySearchST(int capacity) {
        //可以添加 resize(),但是对于大数组,效率太低
        this.keys = (Key[]) new Comparable[capacity];
        this.vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) return vals[i];
        else return null;
    }

    public boolean put(Key key, Value value) {
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) {
            vals[i] = value;
            return true;
        }

        //将所有大于i 的键和值向后移动一格,将新值插入
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }

        keys[i] = key;
        vals[i] = value;
        N++;
        return false;
    }

    //rank 的递归实现
    public int rank(Key key, int lo, int hi) {
        if (lo > hi) return lo;
        int mid = lo + (hi - lo) / 2;
        if (key.compareTo(keys[mid]) > 0)
            return rank(key, mid + 1, hi);
        else if (key.compareTo(keys[mid]) < 0)
            return rank(key, lo, mid - 1);
        else return mid;
    }

    //rank 的迭代实现
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
}
