package com.cjz.advanced;

import java.util.concurrent.locks.ReentrantLock;

//测试Lock锁
public class TestLock {

    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }

}

class TestLock2 implements Runnable{

    private int ticketNums = 10;

    //定义Lock锁 ReentrantLock 可重入锁 只有代码块锁 显式锁 手动开启和关闭锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            if (ticketNums <= 0){
                break;
            }
            try {
                Thread.sleep(1000);
                System.out.println(ticketNums--);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }
}
