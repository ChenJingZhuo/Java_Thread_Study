package com.cjz.state;

//测试礼让线程
//礼让不一定成功，看CPU心情
public class TestYield{
    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield,"a").start();
        new Thread(myYield,"b").start();
    }
}

class MyYield implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();//礼让（会记录线程执行的进度，礼让成功后又回来接着执行剩下流程）
        System.out.println(Thread.currentThread().getName()+"线程停止执行");
    }
}

/**
 * 情况1：
 * a线程开始执行  //a线程礼让成功
 * b线程开始执行  //b线程礼让失败
 * b线程停止执行  //b线程执行结束
 * a线程停止执行  //a线程接着执行
 *
 * 情况2：
 * a线程开始执行  //a线程礼让失败
 * a线程停止执行  //a线程执行结束
 * b线程开始执行  //b线程礼让自己
 * b线程停止执行  //b线程执行结束
 *
 * 情况3：
 * a线程开始执行  //a线程礼让成功
 * b线程开始执行  //b线程礼让成功
 * a线程停止执行  //a线程执行结束
 * b线程停止执行  //b线程执行结束
 *
 * 同理：
 * 情况4：
 * b线程开始执行  //b线程礼让成功
 * a线程开始执行  //a线程礼让失败
 * a线程停止执行  //a线程执行结束
 * b线程停止执行  //b线程接着执行
 *
 * 情况5：
 * b线程开始执行  //b线程礼让失败
 * b线程停止执行  //b线程执行结束
 * a线程开始执行  //a线程礼让自己
 * a线程停止执行  //a线程执行结束
 *
 * 情况6：
 * b线程开始执行  //b线程礼让成功
 * a线程开始执行  //a线程礼让成功
 * b线程停止执行  //b线程执行结束
 * a线程停止执行  //a线程执行结束
 */