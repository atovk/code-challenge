package com.atovk.execise.concurrent;

import java.util.concurrent.*;

public class OwnCallable implements Callable {

    public static void main(String[] args) throws Exception {

        OwnCallable ownCallable = new OwnCallable();
        FutureTask<Object> futureTask = new FutureTask<Object>(ownCallable);

        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println(futureTask.get());

        //


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Object> submit = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "Callable!!!!";
            }
        });
        Thread.sleep(1000);
        System.out.println(submit.get());
        executorService.shutdownNow();

    }

    @Override
    public Object call() throws Exception {
        return "Callable!!";
    }
}
