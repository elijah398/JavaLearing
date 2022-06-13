package com.elijah.javalearning.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentTest {

    //测试可见性
    public void testVisibility() {
        Shop shop = new Shop();

        new Thread(()->{
            System.out.println("线程A初始化");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shop.saleOne();
            System.out.println("线程A购买商品完成，剩余商品量："+shop.goodNumber);
        },"线程A").start();


        while (shop.goodNumber == 1){

        }

        System.out.println("主线程，剩余商品量："+shop.goodNumber);
    }

    //测试原子性
    public void testAtomic() {
        Shop shop = new Shop();

        for(int i = 0; i < 20; i++){
            new Thread(()->{
                try {
                    Thread.sleep(100);
                    shop.reentrantLockAdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        while (Thread.activeCount() >2){
            Thread.yield();
        }

        System.out.println("如果保证了原子性，应该的结果是本来的1+20 = 21，但实际的值："+shop.goodNumber);
    }

    static class Shop{

        /*
        ** 可见性
        */

        //被volatile修饰后，一个线程修改，其他线程马上可见
        volatile int goodNumber = 1;

        //卖出一个商品
        public void saleOne(){
            this.goodNumber = goodNumber--;
        }

        /*
         ** 原子性
         */
        //增加一个商品，不具备原子性
        public void unAtomicAdd() {
            this.goodNumber++;
        }

        //synchronized保证原子性
        public synchronized void synchronizedAdd() {
            this.goodNumber++;
        }

        //AtomicInteger，具备原子性
        AtomicInteger ai = new AtomicInteger(1);
        public void addGoodsByAtomic() {
            ai.getAndIncrement();
        }

        public void reentrantLockAdd() {
            ReentrantLock rl = new ReentrantLock();
            rl.lock();
            System.out.println(Thread.currentThread().getName() + "reentrantLock->lock");
            try {
                this.goodNumber++;
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                rl.unlock();
                System.out.println(Thread.currentThread().getName() + "reentrantLock->unlock");
            }
        }

    }

}
