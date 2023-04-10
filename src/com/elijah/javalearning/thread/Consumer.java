package com.elijah.javalearning.thread;



import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer {
    private ReentrantLock lock;
    private Condition condition;

    public Consumer(ReentrantLock lock,Condition condition) {
        super();
        this.lock = lock;
        this.condition = condition;
    }

    public void getValue(){
        try {
            lock.lock();
            while(StringUtil.getString().equals("")){
                //没值，不进行消费
                condition.await();
            }
            System.out.println("get的值是："+ StringUtil.getString());
            StringUtil.setString("");
            condition.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
