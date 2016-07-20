package com.limbo.sort;

/**
 * Created by Break.D on 7/20/16.
 */
public class BubbleSort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Util.less(a[j + 1], a[j])) {
                    Util.exch(a, j, j+1);
                }
            }
        }
    }
}
