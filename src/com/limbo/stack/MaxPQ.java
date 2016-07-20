package com.limbo.stack;

import com.limbo.sort.Util;

/**
 * Created by Break.D on 7/20/16.
 */
public class MaxPQ<Key extends Comparable<Key>> {


    private Key[] qp;   //基于堆的完全二叉树
    private int N = 0;

    public MaxPQ(int max) {
        qp = (Key[]) new Comparable[max + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key key) {
        qp[++N] = key;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1 && Util.less(qp[k/2], qp[k])) {
            Util.exch(qp, k / 2, k);
            k = k / 2;
        }
    }

    public void delMax() {

    }




}
