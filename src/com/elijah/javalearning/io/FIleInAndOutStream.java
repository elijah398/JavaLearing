package com.elijah.javalearning.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @FileName null.java
 * @Description TODO
 * @Author 80254912
 * @Date 2023/3/28
 */
public class FIleInAndOutStream {
    public static void main(String[] args) {
        File file = new File("src/com/elijah/javalearning/io/", "word.txt");  //创建文件对象

        try {
            if (!file.exists()) {  //如果文件不存在则新建文件
                System.out.println("file 不存在，新建文件");
                file.createNewFile();
            }

            FileOutputStream output = new FileOutputStream(file);
            byte[] bytes = "Java数据交流管道——IO流".getBytes();
            output.write(bytes);  //将数组的信息写入文件中
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream input = new FileInputStream(file);
            byte[] bytes2 = new byte[1024];
            int len = input.read(bytes2);
            System.out.println("文件中的信息是：" + new String(bytes2, 0, len));
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
