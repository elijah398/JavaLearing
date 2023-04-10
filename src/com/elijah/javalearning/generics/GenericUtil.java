package com.elijah.javalearning.generics;

public class GenericUtil {

    public static <T> void reverse(T[] t) {
        int startIndex = 0;
        int endIndex = t.length - 1;

        while (startIndex < endIndex) {
            T temp = t[startIndex];
            t[startIndex] = t[endIndex];
            t[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }
}
