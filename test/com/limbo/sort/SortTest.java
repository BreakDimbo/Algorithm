package com.limbo.sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Break.D on 7/15/16.
 */
public class SortTest {

    @Test
    public void selectSort() {

        Integer[] x = new Integer[20];
        for (int i = 0; i < 20; i++) {
            int j = (int) (Math.random()*20);
            x[i] = j;
            System.out.print(x[i] + " ");
        }

        SelectSort.sort(x);
        System.out.println();

        for (int i = 0; i < 20; i++) {
            System.out.print(x[i] + " ");
        }
    }

    @Test
    public void insertSort() {
        Integer[] x = new Integer[20];
        for (int i = 0; i < 20; i++) {
            int j = (int) (Math.random()*20);
            x[i] = j;
            System.out.print(x[i] + " ");
        }

        InsertSort.sort(x);
        System.out.println();

        for (int i = 0; i < 20; i++) {
            System.out.print(x[i] + " ");
        }
    }

    @Test
    public void bubbleSort() {
        Integer[] x = new Integer[20];
        for (int i = 0; i < 20; i++) {
            int j = (int) (Math.random()*20);
            x[i] = j;
            System.out.print(x[i] + " ");
        }

        BubbleSort.sort(x);
        System.out.println();

        for (int i = 0; i < 20; i++) {
            System.out.print(x[i] + " ");
        }
    }

    @Test
    public void shellSort() {
        Integer[] x = new Integer[20];
        for (int i = 0; i < 20; i++) {
            int j = (int) (Math.random()*20);
            x[i] = j;
            System.out.print(x[i] + " ");
        }

        ShellSort.sort(x);
        System.out.println();

        for (int i = 0; i < 20; i++) {
            System.out.print(x[i] + " ");
        }
    }

    @Test
    public void mergeSort() {
        Integer[] x = new Integer[20];
        for (int i = 0; i < 20; i++) {
            int j = (int) (Math.random()*20);
            x[i] = j;
            System.out.print(x[i] + " ");
        }

        MergeSort.sort(x);
        System.out.println();

        for (int i = 0; i < 20; i++) {
            System.out.print(x[i] + " ");
        }
    }

    @Test
    public void quickSort() {
        Integer[] x = new Integer[20];
        for (int i = 0; i < 20; i++) {
            int j = (int) (Math.random()*20);
            x[i] = j;
            System.out.print(x[i] + " ");
        }

        QuickSort.sort(x);
        System.out.println();

        for (int i = 0; i < 20; i++) {
            System.out.print(x[i] + " ");
        }
    }

}