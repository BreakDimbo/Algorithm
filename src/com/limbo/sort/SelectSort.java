package com.limbo.sort;

/**
 * Created by Break.D on 7/15/16.
 */
public class SelectSort {

    public static void sort(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (Util.less(a[j], a[min])) min = j;
            }
            Util.exch(a, min, i);
        }
    }
}
