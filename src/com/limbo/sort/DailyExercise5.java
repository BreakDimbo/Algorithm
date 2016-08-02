package com.limbo.sort;

/**
 * Created by Break.D on 8/2/16.
 */
public class DailyExercise5 {
    public static void main(String[] args) {
        Integer[] a = new Integer[10000];
        for (int i = 0; i < a.length; i ++) {
            int j = (int) (Math.random() * 500000);
            a[i] = j;
        }
        long t1 = System.currentTimeMillis();
        HeapSort5.sort(a);
        long t2 = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println(t2 - t1 + " millis");
    }
}

class SelectSort5 {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (Util.less(a[j], a[min])) {
                    min = j;
                }
            }
            Util.exch(a, i, min);
        }
    }
}


class BubbleSort5 {
    public static void sort(Comparable[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Util.less(a[j + 1], a[j])) {
                    Util.exch(a, j, j + 1);
                }
            }
        }
    }
}

class InserSort5 {
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && Util.less(a[j], a[j-1]); j--) {
                Util.exch(a, j, j - 1);
            }
        }
    }
}

class ShellSort5 {
    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;

        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {

            for (int i = h; i < n; i++) {
                for (int j = i; j >=h && Util.less(a[j], a[j-h]); j -= h) {
                    Util.exch(a, j, j - h);
                }
            }

            h = h / 3;
        }
    }
}

class MergeSort5 {
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

class QuickSort5 {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
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


class HeapSort5<Key extends Comparable<Key>> {
    private Key[] keys;
    private int N;

    public HeapSort5(int max) {
        keys = (Key[]) new Comparable[max + 1];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /*public void insert(Key key) {
        keys[++N] = key;
        swim(N);
    }

    private void swim(int k) {
        while (k / 2 >= 1 && Util.less(keys[k / 2], keys[k])) {
            Util.exch(keys, k, k / 2);
            k = k / 2;
        }
    }*/

    public static void sink(Comparable[] a) {
        int n = a.length - 1;
        sink(a, 1, n);
    }

    private static void sink(Comparable[] a, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && Util.less(a[j], a[j + 1])) j++;
            if (Util.less(a[j], a[k])) break;
            Util.exch(a, j, k);
            k = j;
        }
    }

    public Key delMax() {
        Key key = keys[1];
        Util.exch(keys, 1, N--);
        keys[N + 1] = null;
        sink(keys, 1, N);
        return key;
    }

    public static void sort(Comparable[] a) {
        int n = a.length - 1;
        //构造堆
        for (int i = n / 2; i >= 1; i--) {
            sink(a, i, n);
        }

        //堆排序
        while (n >= 1) {
            Util.exch(a, 1, n--);
            sink(a, 1, n);
        }
    }

}