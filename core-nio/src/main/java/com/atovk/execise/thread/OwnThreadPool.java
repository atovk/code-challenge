package com.atovk.execise.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OwnThreadPool {


    public static void main(String[] args) {

        new OwnThreadPool().ownExecutor();
    }

    private void ownExecutor() {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable im_in_thread_pool = new Runnable() {
            @Override
            public void run() {
                System.out.println("im in thread pool");
            }
        };

        executorService.execute(im_in_thread_pool);

    }

}

