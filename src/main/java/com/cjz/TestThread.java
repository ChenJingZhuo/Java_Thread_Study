package com.cjz;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread extends Thread{

    private String url;
    private String name;

    public TestThread(String url, String name){
        this.url = url;     //网络图片的地址
        this.name = name;   //保存的文件名
    }

    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.download(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        TestThread t1 = new TestThread("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603217447589&di=71902e58bcbb88b285d071d99cfe39be&imgtype=0&src=http%3A%2F%2Fa0.att.hudong.com%2F56%2F12%2F01300000164151121576126282411.jpg", "1.jpg");
        TestThread t2 = new TestThread("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603217447588&di=981c1c89ec6b69f1726d3243acd3bddc&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F14%2F75%2F01300000164186121366756803686.jpg", "2.jpg");
        TestThread t3 = new TestThread("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1603217447588&di=5b4b6e2f6d3a22da9c8c158ec3048505&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F64%2F52%2F01300000407527124482522224765.jpg", "3.jpg");

        //每次下载顺序不一定一样
        t1.start();
        t2.start();
        t3.start();
    }
}

class WebDownLoader{
    //下载方法
    public void download(String url, String name){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，download方法出现问题");
        }
    }
}