package com.elijah.javalearning.thread;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Product {
    private ReentrantLock lock;
    private Condition condition;

    public Product(ReentrantLock lock, Condition condition) {
        super();
        this.lock = lock;
        this.condition = condition;
    }

    public void setValue() {
        try {
            lock.lock();

            while (!StringUtil.getString().equals("")) {
                //有值，不生产
                condition.await();
            }
            String time = System.currentTimeMillis() + "" + System.nanoTime();
            System.out.println("set 的值是：" + time);
            StringUtil.setString(time);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
