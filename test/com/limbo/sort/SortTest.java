package com.limbo.sort;

import com.limbo.stack.MaxPQ;
import org.junit.Test;

import java.util.Collections;

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

    @Test
    public void heapSort() {
        Integer[] x = new Integer[20];
        for (int i = 1; i < 20; i++) {
            int j = (int) (Math.random()*20);
            x[i] = j;
            System.out.print(x[i] + " ");
        }

        MaxPQ.sort(x);
        System.out.println();

        for (int i = 1; i < 20; i++) {
            System.out.print(x[i] + " ");
        }
    }

    @Test
    public void reverse() {
        String str = "asjensbd";
        char[] c = str.toCharArray();
        char[] b = new char[c.length];
        int x = 0;
        for (int i = c.length-1; i >=0; i--) {
            b[x++] = c[i];
        }
        str = new String(b);

        System.out.println(str);
    }

}