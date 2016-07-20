package com.limbo.sort;

/**
 * Created by Break.D on 7/15/16.
 */
public class Util {

    public static boolean less(Comparable i, Comparable j) {
        return i.compareTo(j) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void shuffle(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + (int) Math.random()*(n - i);
            Comparable temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
