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
        while (k > 1 && Util.less(qp[k / 2], qp[k])) {
            Util.exch(qp, k / 2, k);
            k = k / 2;
        }
    }

    public Key delMax() {
        Key key = qp[1];
        Util.exch(qp, 1, N--);
        qp[N + 1] = null;
        sink(qp, 1, N);
        return key;
    }

    private static void sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && Util.less(a[j], a[j + 1])) j++;
            if (!Util.less(a[k], a[j])) break;
            Util.exch(a, j, k);
            k = j;
        }
    }

    //堆有序-两个阶段:构造堆——下沉排序(有小到大排列)
    public static void sort(Comparable[] a) {
        int n = a.length - 1;
        //构造堆
        for (int i = n / 2; i >= 1; i--) {
            sink(a, i, n);
        }

        //堆排序——将最上层(最大值)与最底层元素交换->下沉最上层元素至<=N-1
        while (n > 1) {
            Util.exch(a, 1, n--);
            sink(a, 1, n);
        }
    }


}
