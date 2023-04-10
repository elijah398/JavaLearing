package com.elijah.javalearning;

import com.elijah.javalearning.thread.ConcurrentTest;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentTest ct = new ConcurrentTest();
        ct.testVisibility();
    }
}
