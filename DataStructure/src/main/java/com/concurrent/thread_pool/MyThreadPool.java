package com.concurrent.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MyThreadPool {
    public static void main(String[] args){
        // fixedThreadPool();
        //cachedThreadPool();
        threadPoolExecutorExample();
    }

    public static void threadPoolExecutorExample(){
        ThreadPoolExecutor executor =
                (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        executor.submit(() -> {
            Thread.sleep(1000);
            return null;
        });
        System.out.println(executor.getPoolSize());
        System.out.println(executor.getQueue().size());
    }

    public static void singleThreadPool(){
        PrinterJob pj = new PrinterJob(1);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(pj);
    }

    public static void fixedThreadPool(){
        PrinterJob pj;
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Object rs = null;
        for(int i =0 ;i< 5;i++) {
            pj = new PrinterJob(i);
            rs = executor.submit(pj, rs);
            System.out.println("ID:"+i+"result:"+rs);
        }
    }

    public static void cachedThreadPool(){
        PrinterJob pj;
        ExecutorService executor = Executors.newCachedThreadPool();
        Object rs = null;
        for(int i =0 ;i< 5;i++) {
            pj = new PrinterJob(i);
            rs = executor.submit(pj, rs);
            System.out.println("ID:"+i+"result:"+rs);
        }
    }
}
