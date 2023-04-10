package com.elijah.javalearning.io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * 创建OutputStream实例out,并将其赋值为System.out标准输出流。通过write()方法向流写入数据。
 * @author zch
 *
 */
public class OutputData {
    public static void main(String[] args) {
        OutputStream output = System.out;           //实例化OutputStream对象

        byte[] bytes = "使用OutputStream输出流在控制台输出字符串\n".getBytes();       //创建bytes数组

        try {
            output.write(bytes);

            bytes = "输出内容：\n".getBytes();
            output.write(bytes);        //向流中写入数据

            bytes = "Java数据交互管道——IO流 \n".getBytes();
            output.write(bytes);

            output.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

