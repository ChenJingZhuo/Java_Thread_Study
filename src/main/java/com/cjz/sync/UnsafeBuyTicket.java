package com.cjz.sync;

//不安全的买票
//线程不安全，有同样的票，有零和负数。
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "苦逼的我").start();
        new Thread(buyTicket, "牛逼的你们").start();
        new Thread(buyTicket, "可恶的黄牛党").start();

    }
}

class BuyTicket implements Runnable{

    //票
    private int ticketNums = 10;

    private boolean flag = true;

    @Override
    public void run() {
        //买票
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void buy() throws InterruptedException {
        if (ticketNums <= 0){
            flag = false;
            return;
        }
        //模拟延时（放大问题的发生性）
        Thread.sleep(100);
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}
