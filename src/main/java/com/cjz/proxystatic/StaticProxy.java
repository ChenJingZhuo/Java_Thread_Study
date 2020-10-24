package com.cjz.proxystatic;

//静态代理模式总结：
//真实对象和代理对象都要实现同一个接口
//代理对象要代理真实角色

//好处：
    //代理对象可以做真实对象做不了的事情
    //真实对象专注自己的事情
public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();//你要结婚
        WeddingCompany weddingCompany = new WeddingCompany(you);
        weddingCompany.happyMarry();

        //new Thread(()-> System.out.println("我爱你")).start();
        //new WeddingCompany(new You()).happyMarry();
    }
}

interface Marry{
    //人间四大喜事
        //久旱逢甘露
        //他乡遇故知
        //洞房花烛夜
        //金榜题名时
    void happyMarry();
}

//真实角色，你去结婚
class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("秦老师要结婚了，超开心");
    }
}

//代理角色，帮助你结婚
class WeddingCompany implements Marry{

    //代理谁？=》 真实角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        this.target.happyMarry();//这就是真实对象。
        after();
    }

    private void before(){
        System.out.println("结婚前，布置现场");
    }

    private void after(){
        System.out.println("结婚后，收尾款");
    }
}


