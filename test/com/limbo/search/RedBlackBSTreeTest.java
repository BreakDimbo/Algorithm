package com.limbo.search;

import org.junit.Test;

/**
 * Created by Break.D on 7/18/16.
 */
public class RedBlackBSTreeTest {

    @Test
    public void RBTreeTest() {
        long t1 = System.currentTimeMillis();
        RedBlackBSTree<String, Integer> rbtree = new RedBlackBSTree<>();

        for (int i = 0; i < 10000; i++) {
            int j = (int)(Math.random()*10000);
            rbtree.put("" + j, i);
        }

        for (int i = 0; i < 1000; i++) {
            int j = (int)(Math.random()*1000);
            rbtree.get("" + j);
        }

        long t2 = System.currentTimeMillis();

        System.out.println("红黑树用时: " + (t2 - t1) + " millis");
    }

    @Test
    public void BST() {
        long t1 = System.currentTimeMillis();

        BST<String, Integer> bst = new BST<>();

        for (int i = 0; i < 10000; i++) {
            int j = (int)(Math.random()*10000);
            bst.put("" + j, i);
        }

        for (int i = 0; i < 1000; i++) {
            int j = (int)(Math.random()*1000);
            bst.get("" + j);
        }

        long t2 = System.currentTimeMillis();

        System.out.println("二叉树用时: " + (t2 - t1) + " millis");
    }

    @Test
    public void binarySearch() {
        long t1 = System.currentTimeMillis();

        BinarySearchST<String, Integer> bs = new BinarySearchST<>(10000);

        for (int i = 0; i < 10000; i++) {
            int j = (int)(Math.random()*10000);
            bs.put("" + j, i);
        }

        for (int i = 0; i < 1000; i++) {
            int j = (int)(Math.random()*1000);
            bs.get("" + j);
        }

        long t2 = System.currentTimeMillis();

        System.out.println("二分法用时: " + (t2 - t1) + " millis");
    }

}