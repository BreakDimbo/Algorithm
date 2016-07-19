package com.limbo.search;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Break.D on 7/15/16.
 */
public class SequentialSearchSTTest {

    @Test
    public void sequentialSearchTest() {
        SequentialSearchST<Integer, String> ss = new SequentialSearchST<>();

        for (int i=0; i<20; i++) {
            ss.put(i, "I am the " + i);
        }

        System.out.println(ss.get(7));
    }

}