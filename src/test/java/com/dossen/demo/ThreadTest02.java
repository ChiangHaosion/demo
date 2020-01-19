package com.dossen.demo;

import java.util.concurrent.*;

/**
 * @ClassName ThreadTest02
 * @Description: TODO
 * @Author Haosion
 * @Date 2020/1/19
 * @Version V1.0
 **/
public class ThreadTest02 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 启动一个线程
        new Thread(new MyRunnable()).start();
        new MyThread().start();

        FutureTask<String> task = new FutureTask<>(new MyCallable());
        new Thread(task).start();
        System.out.println("The result of task is " + task.get());

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(new MyRunnable());
        executorService.execute(new MyThread());
        executorService.submit(task);
        System.out.println("The result of task is " + task.get());
        executorService.shutdown();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("This is MyRunnable...");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("This is MyThread...");
    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("This is MyCallable...");
        return "SUCCESS";
    }
}
