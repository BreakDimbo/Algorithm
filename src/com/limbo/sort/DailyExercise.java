package com.limbo.sort;

/**
 * Created by Break.D on 7/21/16.
 */
public class DailyExercise {

    public static void main(String[] args) {
        Integer[] x = new Integer[20];
        for (int i = 0; i < 20; i++) {
            int j = (int) (Math.random() * 20);
            x[i] = j;
            System.out.print(x[i] + " ");
        }

        QuickSortT.sort(x);
        System.out.println();

        for (int i = 0; i < 20; i++) {
            System.out.print(x[i] + " ");
        }
    }

}

class SelectSortT {
    // O(n^2) .. .. O(1)
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

class BubbleSortT {
    //O(n) O(n^2) .. O(1)
    public static void sort(Comparable[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Util.less(a[j + 1], a[j])) Util.exch(a, j, j + 1);
            }
        }
    }
}

class InserSortT {
    // O(n) O(n^2) .. O(1)
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && Util.less(a[j], a[j - 1]); j--) {
                Util.exch(a, j, j - 1);
            }
        }
    }
}


class ShellSortT {
    public static void sort(Comparable[] a) {
        // O(nlogn) O((nlogn)^2) O((nlogn)^2) O(1)
        int n = a.length;
        int h = 1;

        //找到最大步长
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        //收敛步长迭代
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && Util.less(a[j], a[j - h]); j -= h) {
                    Util.exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}

class MergeSortT {
    private static Comparable[] aux;

    //O(nlogn) O(nlogn) O(nlogn) O(n)
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

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        //需要两个指针左右取值
        int i = lo;
        int j = mid + 1;

        //copy a
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (Util.less(a[i], a[j])) a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }
}

class QuickSortT {
    //O(nlogn) O(nlogn) O(n^2) O(logn)
    //partition-sort

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        Comparable v = a[lo];

        while (true) {
            while (Util.less(a[++i], v)) if (i == hi) break;
            while (Util.less(v, a[--j])) if (j == 0) break;
            if (i >= j) break;
            Util.exch(a, i, j);
        }
        Util.exch(a, lo, j);
        return j;
    }
}