package com.atovk.execise.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class OwnLockInterruptibly {

    public static void main(String[] args) {


        Thread thread1 = new Thread(new OwnRunable());
        Thread thread2 = new Thread(new OwnRunable());

        thread1.start();
        thread2.start();
        thread2.interrupt();

    }


}

class OwnRunable implements Runnable {

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        try {
            // 默认锁，尝试获取锁，得不到的情况下中断当前线程任务
            lock.lock();

            // 优先考虑如果已经有线程持有该资源锁，优先考虑中断当前线程任务
            //lock.lockInterruptibly();

            System.out.println(Thread.currentThread().getName() + " Running");
            Thread.sleep(3000);
            lock.unlock();

            System.out.println(Thread.currentThread().getName() + " finishend");

        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.out.println(Thread.currentThread().getName() + " Interrupted");
        }

    }
}