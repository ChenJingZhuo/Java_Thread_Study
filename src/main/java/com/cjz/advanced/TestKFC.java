package com.cjz.advanced;

//测试：生产者消费者模型 =》 利用缓冲区解决：管程法

//生产者，消费者，产品，缓冲区
public class TestKFC {

    public static void main(String[] args) {
        SyncContainer syncContainer = new SyncContainer();
        new Producer(syncContainer).start();
        new Consumer(syncContainer).start();
    }

}

//生产者
class Producer extends Thread {

    SyncContainer container = new SyncContainer();

    public Producer(SyncContainer container) {
        this.container = container;
    }

    //生产
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了第"+i+"只鸡");
            container.push(new Chicken(i));
        }
    }
}

//消费者
class Consumer extends Thread {

    SyncContainer container = new SyncContainer();

    public Consumer(SyncContainer container) {
        this.container = container;
    }

    //消费
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第"+container.pop().id+"只鸡");
        }
    }
}

//产品
class Chicken{
    int id; //产品编号

    public Chicken(int id) {
        this.id = id;
    }
}

//缓冲区
class SyncContainer{
    //需要一个容器大小
    Chicken[] chickens = new Chicken[10];
    //容器计数器
    int count = 0;

    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //如果容器满了，就需要等待消费者消费
        while(count==chickens.length){
            //通知消费者消费。生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        chickens[count] = chicken;
        count++;
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken pop(){
        //判断能否消费
        while(count==0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果可以消费
        count--;
        Chicken chicken = chickens[count];
        this.notifyAll();
        //吃完了，通知生产者生产
        return chicken;
    }

}
