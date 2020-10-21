package com.cjz;

//创建线程方式二：实现runnable接口，重写run方法，执行线程需要丢入runnable接口实现对象
public class TestThread2 implements Runnable{

    public void run() {
        //run方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码---"+i);
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        TestThread2 testThread2 = new TestThread2();

        //创建线程对象，通过线程对象来开启我们的线程，代理
        Thread thread = new Thread(testThread2);
        thread.start();

        //new Thread(testThread2).start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("我在学习多线程--"+i);
        }
    }
}
