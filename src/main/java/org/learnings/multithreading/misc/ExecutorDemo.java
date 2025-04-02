package org.learnings.multithreading.misc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorDemo {

    private static ExecutorService executorService = null;

    public static void main(String[] args) {
        futureDemo();
        customExecutorDemo();
    }

    private static void futureDemo() {
        Future<String> futureTask = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted");
            }
            return "Hello";
        });
        try {
            var result = futureTask.get(5000, TimeUnit.MILLISECONDS);
            System.out.println("Result of future " + result);
        } catch (InterruptedException e) {
            System.out.println("Thread is interuupted");
        } catch (ExecutionException e) {
            System.out.println("Thread execution has error");
        } catch (TimeoutException e) {
            System.out.println("Timeout while fetching");
        }
    }

    private static void customExecutorDemo() {
        ExecutorDemo.executorService = new ThreadPoolExecutor(3, 5, 2L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                new CustomThreadFactory(), new CustomRejectExecutionHandler());
        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + " is currently executing");
                } catch (InterruptedException e) {
                    throw new IllegalArgumentException("Interrupted");
                }
            });
        }
        executorService.shutdown();
    }
}

class CustomThreadFactory implements ThreadFactory {

    private static int count = 0;

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, "CustomThread-" + count);
        count++;
        return thread;
    }
}

class CustomRejectExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(Thread.currentThread().getName() + " Thread rejected execution" + " for " + r.toString());
        ThreadPoolExecutor.DiscardOldestPolicy policy = new ThreadPoolExecutor.DiscardOldestPolicy();
        policy.rejectedExecution(r, executor);
    }

}
