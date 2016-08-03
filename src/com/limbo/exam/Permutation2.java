package com.limbo.exam;

import java.util.Scanner;

/**
 * Created by Break.D on 8/2/16.
 */
public class Permutation2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符或者数字: ");
        char[] chars = scanner.nextLine().toCharArray();
        perm(chars);
    }

    private static void perm(char[] chars) {
        int n = chars.length - 1;
        perm(chars, 0, n);
    }

    private static void perm(char[] chars, int start, int end) {
        if (start == end) {
            System.out.println(String.valueOf(chars));
        } else {
            for (int i = start; i <= end; i++) {
                if (isSwap(chars, start, i)) {
                    swap(chars, start, i);
                    perm(chars, start + 1, end);
                    swap(chars, i, start);
                }
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private static boolean isSwap(char[] chars, int start, int end) {
        for (int i = start; i < end; i++) {
            if (chars[i] == chars[end]) return false;
        }
        return true;
    }
}
