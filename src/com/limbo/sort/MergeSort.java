package com.limbo.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Break.D on 7/20/16.
 */
public class MergeSort {
    //先递归分解-再进行归并(需要一个临时变量存储归并时的数据)
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);

    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    //注意归并的是哪个数组段(lo-hi) 注意边界
    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        //将待归并数组保存到临时变量里
        //aux = Arrays.copyOfRange(a, lo, hi);

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (Util.less(aux[i], aux[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }

    }
}
