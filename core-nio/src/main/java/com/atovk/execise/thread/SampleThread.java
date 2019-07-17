package com.atovk.execise.thread;


/**
 * basic thread
 *
 * 线程初始化 两种方式
 *
 * 1. 初始(NEW)：新创建了一个线程对象，但还没有调用start()方法。
 * 2. 运行(RUNNABLE)：Java线程中将就绪（ready）和运行中（running）两种状态笼统的称为“运行”。
 *    线程对象创建后，其他线程(比如main线程）调用了该对象的start()方法。该状态的线程位于可运行线程池中，
 *    等待被线程调度选中，获取CPU的使用权，此时处于就绪状态（ready）。就绪状态的线程在获得CPU时间片后变为运行中状态（running）。
 * 3. 阻塞(BLOCKED)：表示线程阻塞于锁。
 * 4. 等待(WAITING)：进入该状态的线程需要等待其他线程做出一些特定动作（通知或中断）。
 * 5. 超时等待(TIMED_WAITING)：该状态不同于WAITING，它可以在指定的时间后自行返回。
 * 6. 终止(TERMINATED)：表示该线程已经执行完毕。
 *
 */
public class SampleThread {

    public static void main(String[] args) {

        Thread thread = new ThreadRunAn();
        thread.setName("thread-01");
        thread.start();

        ThreadRunBe threadRunBe = new ThreadRunBe();
        Thread thread1 = new Thread(threadRunBe);
        thread1.start();

    }

}

class ThreadRunAn extends Thread {

    @Override
    public void run() {
        System.out.println("thread-02");
    }
}

class ThreadRunBe implements Runnable {

    @Override
    public void run() {
        System.out.println("thread-03");
    }
}