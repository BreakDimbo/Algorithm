package com.limbo.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Break.D on 8/2/16.
 */
public class Permutation {

    //用于控制数组的索引,加入找到的元素
    private static int index = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入需要排列的字符串和数字:");

        char[] chars = scanner.nextLine().toCharArray();

        Permutation.permutation(chars, false, null);

    }

    /**
     * @param a    待进行全排列的数组
     * @param find 在 FinderNextLarger 中使用,是否将排列后的组合装进一个 list 里
     * @param nums 用来装排列后的数
     */
    public static void permutation(char[] a, boolean find, int[] nums) {
        permutation(a, 0, a.length - 1, find, nums);
    }


    private static void permutation(char[] a, int begin, int end, boolean add, int[] nums) {
        //当 begin==end 时,表明已经无序再进行交换,退出递归
        if (begin == end) {
            if (add) {
                //如果需要在 FindernextLarger 中使用该方法, 将找到的数组添加进nums 里
                int k = Integer.parseInt((String.valueOf(a)));
                nums[index++] = k;

            } else {
                System.out.println(Arrays.toString(a));
            }
        } else {
            for (int i = begin; i <= end; i++) {

                if (isSwap(a, begin, i)) {
                    //依次令每一个元素到 「begin」的位置
                    swap(a, begin, i);
                    //将begin+1 到 end 当做新的数组
                    permutation(a, begin + 1, end, add, nums);
                    //恢复现场
                    swap(a, i, begin);
                }

            }
        }


    }

    //交换i,j 对应元素的位置
    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 检查[start, end]数组中,是否有与[end]对应的值相等的元素
    private static boolean isSwap(char[] a, int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (a[i] == a[end]) return false;
        }

        return true;
    }
}


