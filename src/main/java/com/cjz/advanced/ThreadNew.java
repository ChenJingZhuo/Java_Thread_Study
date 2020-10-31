package com.cjz.advanced;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//多线程创建方式回顾
public class ThreadNew {

    public static void main(String[] args) {
        new MyThread1().start();
        new Thread(new MyThread2()).start();
        FutureTask<String> stringFutureTask = new FutureTask<>(new MyThread3());
        new Thread(stringFutureTask).start();
        try {
            String s = stringFutureTask.get();
            System.out.println("stringFutureTask: "+s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

//1.继承Thread类
class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread1");
    }
}
//2.实现Runnable接口
class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThread2");
    }
}
//3.实现Callable接口
class MyThread3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyThread3");
        return "MyThread3";
    }
}

