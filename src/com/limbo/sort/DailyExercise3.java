package com.limbo.sort;

/**
 * Created by Break.D on 7/24/16.
 */
public class DailyExercise3 {
    public static void main(String[] args) {
        test();
    }


    public static void test() {
        Integer[] x = new Integer[20000];
        for (int i = 0; i < 20000; i++) {
            int j = (int) (Math.random() * 20000);
            x[i] = j;
            System.out.print(x[i] + " ");
        }
        long t1 = System.currentTimeMillis();
        HeapSort3.sort(x);
        long t2 = System.currentTimeMillis();
        long time = t2 - t1;
        System.out.println();


        for (int i = 0; i < 20; i++) {
            System.out.print(x[i] + " ");
        }

        System.out.println();
        System.out.println("排序所用时间: " + time + " millis");

    }
}


class SelectSort3 {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (Util.less(a[j], a[min])) min = j;
            }
            Util.exch(a, i, min);
        }
    }
}


class BubbleSort3 {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length - i; j++) {
                if (Util.less(a[j], a[j - 1])) {
                    Util.exch(a, j, j - 1);
                }
            }
        }
    }
}

class InserSort3 {
    public static void sort(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && Util.less(a[j], a[j - 1]); j--) {
                Util.exch(a, j, j - 1);
            }
        }
    }
}


class ShellSort3 {
    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;

        while (h < n / 3) {
            h = 3 * h + 1;
        }

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

class MergeSort3 {
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

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (Util.less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

}

class QuickSort3 {

    public static void sort(Comparable[] a) {
        int n = a.length;
        sort(a, 0, n - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(a, lo, hi);
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        Comparable v = a[lo];

        while (true) {
            while (Util.less(a[++i], v)) if (i == hi) break;
            while (Util.less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            Util.exch(a, i, j);
        }

        Util.exch(a, lo, j);
        return j;
    }
}

class HeapSort3<Key extends Comparable<Key>> {
    private Key[] keys;
    private int N = 0;

    public HeapSort3(int max) {
        keys = (Key[]) new Comparable[max + 1];
        N = max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void swim(int k) {
        while (k / 2 >= 1 && Util.less(keys[k / 2], keys[k])) {
            Util.exch(keys, k, k / 2);
            k = k / 2;
        }
    }

    public void insert(Key key) {
        keys[++N] = key;
        swim(N);
    }

    public static void sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && Util.less(a[j], a[j + 1])) j++;
            if (Util.less(a[j],a[k])) break;
            Util.exch(a, j, k);
            k = j;
        }
    }

    public void sink(int k) {
        sink(keys, k, N);
    }

    public Key delMax() {
        Key key = keys[1];
        Util.exch(keys, 1, N--);
        keys[N + 1] = null;
        sink(1);
        return key;
    }

    public static void sort(Comparable[] a) {
        int n = a.length - 1;
        //构造堆
        for (int i = n / 2; i > 0; i--) {
            sink(a, i, n);
        }

        //堆有序
        while (n >= 1) {
            Util.exch(a, 1, n--);
            sink(a, 1, n);
        }

        // 如果 k = 0 会在sink()陷入死循环
        /*while (n > 0) {
            Util.exch(a, 0, n--);
            sink(a, 0, n);
        }*/
    }
}