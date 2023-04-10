package com.elijah.javalearning.innerclass;

public class DataOuterClass {

    private String data = "外部类数据";

    /*
    **  1. 内部类可访问外围类的私有变量
     */
    private class InnerClass {
        public InnerClass() {
            System.out.println("内部类获得了" + data);
        }
    }

    public void getInner() {
        new InnerClass();
    }

    /*
    **  2. 隐藏内部类的实现细节
     */
    private class InnerInterfaceClass implements com.elijah.javalearning.innerclass.InnerInterface {

        @Override
        public void innerMethod() {
            System.out.println("实现内部类隐藏");
        }
    }

    public com.elijah.javalearning.innerclass.InnerInterface getInnerInterfaceClass() {
        return new InnerInterfaceClass();
    }


}

////饿汉模式
//public class SingleTon {
//    private static SingleTon INSTANCE = new SingleTon();
//
//    private SingleTon() {}
//    public static SingleTon getINSTANCE() {
//        return INSTANCE;
//    }
//}
//
////懒汉模式
//public class Singleton {
//    private static SingleTon INSTANCE = null;
//
//    private SingleTon() {}
//    public static SingleTon getINSTANCE() {
//        if (INSTANCE == null) {
//            INSTANCE = new SingleTon();
//        }
//
//        return INSTANCE;
//    }
//}
//
////静态内部类
//public class SingleTon {
//    private SingleTon() {}
//
//    private static class SingleTonHolder {
//        private static SingleTon INSTANCE = new SingleTon();
//    }
//
//    public static SingleTon getInstance() {
//        return SingleTonHolder.INSTANCE;
//    }
//}
