package com.elijah.javalearning.io;

import java.io.File;
import java.io.FileReader;

/**
 * @FileName null.java
 * @Description TODO
 * @Author 80254912
 * @Date 2023/3/28
 */
public class FileInAndOutReader {
    public static void main(String[] args) {
        //定义指定磁盘的文件的File对象
        File file = new File("src/com/elijah/javalearning/io/", "word.txt");  //创建文件对象

        if (!file.exists()) {
            System.out.println("对不起，不包含指定路径的文件");
        } else {
            //根据指定路径的File对象创建FileReader对象
            try {
                FileReader fr = new FileReader(file);
                char[] data = new char[23];  //定义char数组
                int length = 0;
                while ((length = fr.read(data))>0) {  //循环读取文件中的数据
                    String str = new String(data,0,length);  //根据读取文件的内容创建String 对象
                    System.out.println(str);  //输出读取内容
                }
                fr.close();  //关闭流
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
