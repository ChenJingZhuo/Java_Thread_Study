package com.cjz.state;

import java.text.SimpleDateFormat;
import java.util.Date;

//模拟倒计时
public class TestSleep2{

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    public static void showTime() throws InterruptedException {
        while (true){
            System.out.println(simpleDateFormat.format(new Date(System.currentTimeMillis())));
            Thread.sleep(1000);
        }
    }

    //10s倒计时
    public static void tenNum() throws InterruptedException {
        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if(num<=0){
                break;
            }
        }
    }

    public static void main(String[] args) {
        /*try {
            TestSleep2.tenNum();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        try {
            TestSleep2.showTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
