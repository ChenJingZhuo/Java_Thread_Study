package com.cjz.lambda_show;

public class TestLambda1 {

    //静态内部类
    static class ILike implements Like{
        @Override
        public void like() {
            System.out.println("I like you 2");
        }
    }

    public static void main(String[] args) {

        //局部内部类
        class ILike implements Like{
            @Override
            public void like() {
                System.out.println("I like you 3");
            }
        }

        //匿名内部类
        Like like = new Like() {
            @Override
            public void like() {
                System.out.println("I like you 4");
            }
        };
        like.like();

        Like like5 = ()-> {
            System.out.println("I like you 5");
        };
        like5.like();

        Like like6 = ()-> System.out.println("I like you 6");
        like6.like();

        //同理
        Runnable runnable = () -> {
            System.out.println("6666");
        };
        runnable.run();
    }

}

//函数式接口：当一个接口只有一个抽象方法时，这个接口就是函数式接口。
interface Like{
    void like();
}

//外部类
class ILike implements Like{
    @Override
    public void like() {
        System.out.println("I like you 1");
    }
}
