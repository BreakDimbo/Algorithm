package com.limbo.sort;

/**
 * Created by Break.D on 7/22/16.
 */
public class DailyExercise2 {
    public static void main(String[] args) {

        Integer[] x = new Integer[20000];
        for (int i = 1; i < 20000; i++) {
            int j = (int) (Math.random() * 20000);
            x[i] = j;
            System.out.print(x[i] + " ");
        }
        long t1 = System.currentTimeMillis();
        HeapSort.sort(x);
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

class SelectSort2 {
    // 20000 个数排序,平均时间:1.9s
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

class BubbleSort2 {
    // 平均时间:3s
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (Util.less(a[j + 1], a[j])) Util.exch(a, j, j + 1);
            }
        }
    }
}

class InsertSort2 {
    // 平均时间 1.6s
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && Util.less(a[j], a[j - 1]); j--) {
                Util.exch(a, j, j - 1);
            }
        }
    }
}

class ShellSort2 {
    // 平均用时: 0.08s——80 millis
    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;

        //找到最大步长
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        //缩减步长,迭代
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

class MergerSort2 {
    // 平均用时: 0.04s——40 millis
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

        for (int k = lo; k < hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k < hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (Util.less(a[i], a[j])) a[k] = aux[i++];
            else a[k] = a[j++];
        }
    }
}

class QuickSort2 {
    //平均用时: 0.04s——40 millis
    public static void sort(Comparable[] a) {
        Util.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
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
        Util.exch(a, j, lo);
        return j;
    }
}

class HeapSort<Key extends Comparable<Key>> {
    //平均用时:0.08s
    //使用数组实现二叉树结构的最大优先队列
    private Key[] keys;
    private int N = 0;

    public HeapSort(int max) {
        keys = (Key[]) new Comparable[max + 1];
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
        //构造堆
        int n = a.length - 1;
        for (int i = n / 2; i > 0; i--) {
            sink(a, i, n);
        }

        //堆有序
        while (n >= 1) {
            Util.exch(a, 1, n--);
            sink(a, 1, n);
        }
    }

}