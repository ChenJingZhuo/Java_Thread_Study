package com.cjz.state;

import com.cjz.TestThread3;

//模拟网络延时
public class TestSleep implements Runnable{

    //票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true){
            if (ticketNums <= 0){
                break;
            }

            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"-->抢到了第"+ticketNums--+"张票。");
        }
    }

    public static void main(String[] args) {
        TestThread3 testThread3 = new TestThread3();
        new Thread(testThread3, "小明").start();
        new Thread(testThread3, "老师").start();
        new Thread(testThread3, "黄牛党").start();
    }
}
