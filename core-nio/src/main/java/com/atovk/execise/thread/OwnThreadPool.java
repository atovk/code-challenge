package com.atovk.execise.thread;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class OwnThreadPool {


    public static void main(String[] args) {

        SynchronousQueue synchronousQueue = new SynchronousQueue();
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);


        new OwnThreadPool().ownExecutor();
        new OwmThreadFactory();
    }

    /**
     * 如果线程数量<=核心线程数量，那么直接启动一个核心线程来执行任务，不会放入队列中。
     * 如果线程数量>核心线程数，但<=最大线程数，并且任务队列是LinkedBlockingDeque的时候，超过核心线程数量的任务会放在任务队列中排队。
     * 如果线程数量>核心线程数，但<=最大线程数，并且任务队列是SynchronousQueue的时候，线程池会创建新线程执行任务，这些任务也不会被放在任务队列中。这些线程属于非核心线程，在任务完成后，闲置时间达到了超时时间就会被清除。
     * 如果线程数量>核心线程数，并且>最大线程数，当任务队列是LinkedBlockingDeque，会将超过核心线程的任务放在任务队列中排队。也就是当任务队列是LinkedBlockingDeque并且没有大小限制时，线程池的最大线程数设置是无效的，他的线程数最多不会超过核心线程数。
     * 如果线程数量>核心线程数，并且>最大线程数，当任务队列是SynchronousQueue的时候，会因为线程池拒绝添加任务而抛出异常。
     * 任务队列大小有限时
     *
     * 当LinkedBlockingDeque塞满时，新增的任务会直接创建新线程来执行，当创建的线程数量超过最大线程数量时会抛异常。
     * SynchronousQueue没有数量限制。因为他根本不保持这些任务，而是直接交给线程池去执行。当任务数量超过最大线程数时会直接抛异常。
     */
    private void ownExecutor() {

        ExecutorService executorService = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();


        Runnable im_in_thread_pool = new Runnable() {
            @Override
            public void run() {
                System.out.println("im in thread pool");
            }
        };

        scheduledExecutorService.schedule(im_in_thread_pool, 3L, TimeUnit.SECONDS);
        executorService.execute(im_in_thread_pool);
        singleThreadExecutor.execute(im_in_thread_pool);

        scheduledExecutorService.shutdown();
        scheduledExecutorService.shutdown();
        singleThreadExecutor.shutdown();
        newFixedThreadPool.shutdown();


    }

}

class OwmThreadFactory implements ThreadFactory {

    private static final AtomicInteger poolNumber = new AtomicInteger(1);
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;

    OwmThreadFactory() {
        SecurityManager var1 = System.getSecurityManager();
        this.group = var1 != null ? var1.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-";
    }

    public Thread newThread(Runnable var1) {
        Thread var2 = new Thread(this.group, var1, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
        if (var2.isDaemon()) {
            var2.setDaemon(false);
        }

        if (var2.getPriority() != 5) {
            var2.setPriority(5);
        }

        return var2;
    }
}

