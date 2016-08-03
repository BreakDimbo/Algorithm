package com.limbo.exam.removeDuplicate;

import java.util.Arrays;

/**
 * Created by Break.D on 8/3/16.
 */
public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 3, 1, 2, 5 };
        a = removeDuplicate(a);
        System.out.println(Arrays.toString(a));
    }

    private static int[] removeDuplicate(int[] a) {
        int index = 0;
        Arrays.sort(a);
        for (int i = 1; i < a.length; i++) {
            if (a[index] != a[i]) {
                a[++index] = a[i];
            }
        }

        int[] b = new int[index + 1];
        b = Arrays.copyOf(a, b.length);
        return b;
    }
}
