package com.atovk.execise.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class WaitNotify {

    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws Exception {

        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();

    }


    private static class Wait implements Runnable {
        @Override
        public void run() {

            synchronized (lock) {

                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true . wait @ " + new SimpleDateFormat(String.format("HH:mm:ss", new Date())));

                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread() + " flag is false . running @ " + new SimpleDateFormat(String.format("HH:mm:ss", new Date())));


                }
            }

        }
    }

    private static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again . notify @ " + new SimpleDateFormat(String.format("HH:mm:ss", new Date())));

                lock.notifyAll();
                flag = false;

                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            synchronized (lock) {

                System.out.println(Thread.currentThread() + " hold lock again . sleep @ " + new SimpleDateFormat(String.format("HH:mm:ss", new Date())));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
