package com.cjz.lambda_show;

public class TestLambda2 {
    public static void main(String[] args) {
        /*Love love = new Love() {
            @Override
            public void love(int a, int b) {
                System.out.println("a="+a+", b="+b);
            }
        };*/

        /*Love love = (int a, int b) -> {
            System.out.println("a="+a+", b="+b);
        };*/

        //Love love = () -> System.out.println("xxx");
        //Love love = a -> System.out.println("a="+a+");

        Love love = (int a, int b) -> System.out.println("a="+a+", b="+b);

        love.love(520,521);

        //同理
        Runnable runnable = () -> {
            System.out.println("6666");
        };
        runnable.run();
    }
}

interface Love{
    void love(int a, int b);
}
