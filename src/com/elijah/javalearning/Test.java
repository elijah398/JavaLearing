package com.elijah.javalearning;

import com.elijah.javalearning.thread.ConcurrentTest;

public class Test {
    public static void main(String[] args){
        testVolatile();
    }

    private static void testVolatile() {
        ConcurrentTest vt = new ConcurrentTest();
        vt.testAtomic();
    }
}
