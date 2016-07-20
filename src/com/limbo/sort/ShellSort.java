package com.limbo.sort;

/**
 * Created by Break.D on 7/20/16.
 */
public class ShellSort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;

        //找出最大步长
        while (h < n / 3) {
            h = 3*h + 1;
        }

        //缩减步长进行搜索
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && Util.less(a[j], a[j-h]); j -= h) {
                    Util.exch(a, j, j-h);
                }
            }
            h = h / 3;
        }
    }
}
