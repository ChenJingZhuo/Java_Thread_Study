package com.cjz.thread;

//多线程：死锁
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "灰姑娘");
        Makeup g2 = new Makeup(1, "白雪公主");

        g1.start();
        g2.start();
    }
}

//口红
class Lipstick{

}

//镜子
class Mirror{

}

//化妆
class Makeup extends Thread {

    //需要的资源只有一份，用static来保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice;//选择
    String girlName;//使用化妆品的人

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {
        if (choice==0){
            synchronized (lipstick){    //拿到了口红的锁
                System.out.println(this.girlName+"拿到了口红");
                sleep(1000);
                synchronized (mirror){ //不能锁中锁，会死锁
                    System.out.println(this.girlName+"拿到了镜子");
                }
            }

            /*synchronized (mirror){ //口红锁释放，再拿镜子锁
                System.out.println(this.girlName+"拿到了镜子");
            }*/

        } else {
            synchronized (mirror){  //拿到了镜子的锁
                System.out.println(this.girlName+"拿到了镜子口红");
                sleep(1000);
                synchronized (lipstick){ //不能锁中锁，会死锁
                    System.out.println(this.girlName+"拿到了镜子");
                }
            }

            /*synchronized (lipstick){ //镜子锁释放，再拿口红锁
                System.out.println(this.girlName+"拿到了口红");
            }*/
        }
    }
}
