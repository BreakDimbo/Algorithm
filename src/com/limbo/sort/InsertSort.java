package com.limbo.sort;

/**
 * Created by Break.D on 7/15/16.
 */
public class InsertSort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && Util.less(a[j], a[j-1]); j--) {
                Util.exch(a, j, j-1);
            }
        }
    }
}
