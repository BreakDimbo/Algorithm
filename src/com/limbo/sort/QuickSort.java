package com.limbo.sort;

/**
 * Created by Break.D on 7/20/16.
 */
public class QuickSort {
    //先切分,再递归分解

    public static void sort(Comparable[] a) {
        int n = a.length;
        Util.shuffle(a);
        sort(a, 0, n-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partision(a, lo, hi);
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);
    }

    private static int partision(Comparable[] a, int lo, int hi) {
        //取出a[lo],建立两个指针左右互搏
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];

        while (true) {
            while (Util.less(a[++i], v)) if(i == hi) break;
            while (Util.less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            Util.exch(a, i, j);
        }

        Util.exch(a, lo, j);
        return j;
    }
}
