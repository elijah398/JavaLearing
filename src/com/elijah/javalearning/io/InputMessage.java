package com.elijah.javalearning.io;

import java.io.IOException;
import java.io.InputStream;

public class InputMessage {
    public static void main(String[] args) {
        InputStream inp = System.in;

        byte[] bytes = new byte[1024];

        try {
            while(inp.read() != -1){
                //根据用户输入的信息创建字符串
                bytes = inp.readAllBytes();
                String str = new String(bytes).trim();
                System.out.println("Input String is " + str);
            }
            inp.close();    //关闭流

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
