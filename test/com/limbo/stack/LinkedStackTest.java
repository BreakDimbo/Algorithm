package com.limbo.stack;

import org.junit.Test;

/**
 * Created by Break.D on 7/14/16.
 */
public class LinkedStackTest {

    @Test
    public void linkedStackTest() {
        LinkedStack<String> dc = new LinkedStack<>();

        dc.push("小李");
        dc.push("阿黄");
        dc.push("阿黄");
        dc.push("阿黄");
        dc.push("阿黄");
        dc.push("阿黄");

        dc.pop();
        dc.pop();
        dc.pop();
        dc.pop();
        dc.pop();

    }

    @Test
    public void arrayStackTest() {
        DynamicCapacityArrayStack<String> dc = new DynamicCapacityArrayStack<>();


        dc.push("小李");
        dc.push("阿黄");
        dc.push("阿黄");
        dc.push("阿黄");
        dc.push("阿黄");
        dc.push("阿黄");


        dc.pop();
        dc.pop();
        dc.pop();
        dc.pop();
        dc.pop();
    }

}