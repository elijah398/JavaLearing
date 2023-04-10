package com.elijah.javalearning.serialize;

import java.io.*;

public class Student implements Serializable {

    private String name;
    private Integer age;
    private Integer score;
    private transient String password;

    @Override
    public String toString() {
        return "Student:" + '\n' +
                "name = " + this.name + '\n' +
                "age = " + this.age + '\n' +
                "score = " + this.score + '\n' +
                "password =" + this.password + '\n'
                ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void serialize() throws IOException {

        Student student = new Student();
        student.setName("Yijun");
        student.setAge(18);
        student.setScore(100);
        student.setPassword("pas");

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("student.txt")));
        objectOutputStream.writeObject(student);
        objectOutputStream.close();

        System.out.println("序列化成功！已经生成student.txt文件");
        System.out.println("==============================================");
    }

    public static void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream("student.txt") );
        Student student = (Student) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println("反序列化结果为：");
        System.out.println( student );
    }
}
