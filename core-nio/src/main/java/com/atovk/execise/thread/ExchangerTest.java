package com.atovk.execise.thread;

import java.util.concurrent.*;

public class ExchangerTest {

    private static final Exchanger<String> exgr = new Exchanger<>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "thread B";
                    String A = exgr.exchange("B");

                    System.out.println("is same: " + A.equals(B) + ", A is : " + A + ", B is : " + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });


        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "threat A";
                    String B = exgr.exchange(A);
                    System.out.println(B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        threadPool.shutdown();

    }


}
