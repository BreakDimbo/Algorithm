package com.limbo.stack;

import org.junit.Test;

/**
 * Created by Break.D on 7/14/16.
 */
public class DynamicCapacityArrayStackTest {

    @Test
    public void fixedTest() {
        DynamicCapacityArrayStack<String> dc = new DynamicCapacityArrayStack<>();

        System.out.println(dc.isEmpty() + " " + dc.size());

        dc.push("I am a children");
        dc.push("I am a dog");
        dc.push("I am a cat");
        dc.push("I am a monkey");
        dc.push("I am a elephant");

        dc.pop();
        dc.pop();
        dc.pop();
        dc.pop();
        dc.pop();
        dc.pop();
        dc.pop();
        dc.pop();

        System.out.println(dc.pop());

    }

    @Test
    public void dynamicTest() {
        DynamicCapacityArrayStack<Integer> dc = new DynamicCapacityArrayStack<>();

        for(int i=0; i<50; i++) {
            dc.push(i);
        }

        for (int i=0; i<50; i++) {
            System.out.println(dc.pop().toString());
        }
    }

    @Test
    public void iteratorTest() {
        DynamicCapacityArrayStack<Integer> dc = new DynamicCapacityArrayStack<>();

        for(int i=0; i<50; i++) {
            dc.push(i);
        }

        for (Integer i : dc) {
            System.out.println(i);
        }
    }

}