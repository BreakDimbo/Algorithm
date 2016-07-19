package com.limbo.search;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Break.D on 7/15/16.
 */
public class BinarySearchSTTest {

    @Test
    public void binaryTest() {
        BinarySearchST<String, Integer> bs = new BinarySearchST<>(20);
        for (int i = 0; i < 20; i++) {
            bs.put("I am the " + i, i);
        }

        System.out.println(bs.get("I am the 2"));
    }

}