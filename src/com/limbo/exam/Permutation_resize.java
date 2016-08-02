package com.limbo.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Break.D on 8/2/16.
 */
public class Permutation_resize {

    //用于控制数组的索引,加入找到的元素
    private static int index = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入需要排列的字符串和数字:");

        char[] chars = scanner.nextLine().toCharArray();

        Permutation_resize.permutation(chars, false, null);

    }

    /**
     * @param a    待进行全排列的数组
     * @param find 在 FinderNextLarger 中使用,是否将排列后的组合装进一个 list 里
     * @param nums 用来装排列后的数
     */
    public static int[] permutation(char[] a, boolean find, int[] nums) {
        return permutation(a, 0, a.length - 1, find, nums);
    }


    private static int[] permutation(char[] a, int begin, int end, boolean add, int[] nums) {
        //当 begin==end 时,表明已经无序再进行交换,退出递归
        if (begin == end) {
            if (add) {
                //如果需要在 FindernextLarger 中使用该方法, 将找到的数组添加进nums 里
                int k = charToInt(a);

                //扩大数组容量
                if (index == nums.length) {
                    nums = resize(nums);
                }
                nums[index++] = k;
                return nums;

            } else {
                System.out.println(Arrays.toString(a));
            }
        } else {
            for (int i = begin; i <= end; i++) {

                if (isSwap(a, begin, i)) {
                    //依次令每一个元素到 「begin」的位置
                    swap(a, begin, i);
                    //将begin+1 到 end 当做新的数组
                    nums = permutation(a, begin + 1, end, add, nums);
                    //恢复现场
                    swap(a, i, begin);
                }
            }
        }

        return nums;


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



    //重新扩大数组大小
    private static int[] resize(int[] nums) {
        int[] tmp = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = nums[i];
        }
        return tmp;
    }

    //将char[]转换为int
    private static int charToInt(char[] chars) {
        int result = 0;
        for (int i = 0; i<chars.length; i++) {
            int digit = (int) chars[i];
            result *= 10;
            result += digit;
        }

        return result;
    }
}


