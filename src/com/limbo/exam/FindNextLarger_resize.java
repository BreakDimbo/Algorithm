package com.limbo.exam;


import java.util.Scanner;

/**
 * Created by Break.D on 8/2/16.
 */
public class FindNextLarger_resize {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个自然数");
        char[] input = scanner.nextLine().toCharArray();

        findNextLarger(input);
    }


    //findMethod
    private static void findNextLarger(char[] input) {
        int[] nums = new int[1];

        nums = Permutation_resize.permutation(input, true, nums);


        quickSort(nums);


        int index = rank(nums, Integer.parseInt(String.valueOf(input)));

        if (index >= nums.length) {
            System.out.println("不存在");
        } else {
            System.out.println(nums[index + 1]);
        }

    }


    //quick quickSort
    private static void quickSort(int[] nums) {

        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(nums, lo, hi);
        quickSort(nums, lo, p - 1);
        quickSort(nums, p + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int value = nums[lo];

        while (true) {
            while (nums[++i] < value) if (i == hi) break;
            while (nums[--j] > value) if (j == lo) break;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }

    //binary search
    private static int rank(int[] nums, int key) {
        return rank(nums, 0, nums.length, key);
    }

    /**
     * @param nums 待查找 List
     * @param lo   起始索引
     * @param hi   终止索引
     * @param key  待比较值
     * @return
     */
    private static int rank(int[] nums, int lo, int hi, int key) {
        if (lo >= hi) return lo;
        int mid = lo + (hi - lo) / 2;
        if (key > nums[mid]) return rank(nums, mid + 1, hi, key);
        else if (key < nums[mid]) return rank(nums, lo, mid - 1, key);
        else return mid;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    //计算全排列的个数,用于生成数组
    private static int computeFactorial(int length) {
        int result = 1;
        for (int i = 0; i < length; i++) {
            result *= length;
        }
        return result;
    }

}
