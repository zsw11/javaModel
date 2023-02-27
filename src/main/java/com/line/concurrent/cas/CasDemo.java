package com.line.concurrent.cas;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @desc CAS保证原子性
 * T1 100 -> 101
 * T2 100 -> 2019
 *@Author zsw
 * @Date 2019/8/20
 */
public class CasDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        // T1 100 -> 101
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t updated: " + atomicInteger.compareAndSet(100, 101) + ",value: " + atomicInteger.get());
        }, "T1").start();
        // T2 100 -> 2019
//        new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName() + "\t updated: " + atomicInteger.compareAndSet(100, 2019) + ",value: " + atomicInteger.get());
//        }, "T2").start();
//        TimeUnit.SECONDS.sleep(2);// 等 T2执行完
//        int i = atomicInteger.get();
//        System.out.println(i);// 没有更新为2019
        // java8 异步线程获取结果
        CompletableFuture<Integer> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t updated: " + atomicInteger.compareAndSet(100, 2019) + ",value: " + atomicInteger.get());
            return 0;
        });
        CompletableFuture<Integer> integerCompletableFuture = voidCompletableFuture.thenApply((integer) -> {
            int i = atomicInteger.get(); // 等 voidCompletableFuture 执行完
            return i;
        });
        System.out.println(integerCompletableFuture.get());
    }
}
