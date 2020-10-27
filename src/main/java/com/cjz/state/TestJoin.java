package com.cjz.state;

//线程插队（线程强制执行）
public class TestJoin implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 500; i++) {
            if (i==200){
                thread.join();//插队，会阻塞其他线程（霸道），等它执行完，其他线程才继续执行。
            }
            System.out.println("main..."+i);
        }

    }
}

