package com.line.design32;

import java.util.concurrent.*;

/**
 * @author zsw
 * @date 2021/5/8 10:14
 * @description :懒汉式单例
 */
public class LazySingleton {
    private static volatile LazySingleton instance = null;//保证 instance 在所有线程中同步

    private LazySingleton() {
    } //private 避免类在外部被实例化

    public static synchronized LazySingleton getInstance() {
        //getInstance 方法前加同步
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    } // 如果编写的是多线程程序，则不要删除上例代码中的关键字 volatile 和 synchronized，否则将存在线程非安全的问题。如果不删除这两个关键字就能保证线程安全，但是每次访问时都要同步，会影响性能，且消耗更多的资源，这是懒汉式单例的缺点。

    // 饿汉式 没有线程安全问题
    public static class HungrySingleton {
        public  int a = 0;
        private static final HungrySingleton instance = new HungrySingleton();
        private HungrySingleton() {
        }
        public static HungrySingleton getInstance() {
            return instance;
        }
        public void add() {
            a++;
        }
    }

    // 证明饿汉式线程是安全的
    public static void main(String[] args) throws InterruptedException {
         final int threads = 100;
        final CountDownLatch endGate = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    HungrySingleton instance = HungrySingleton.getInstance();
                    instance.add();
//                    System.out.println(Thread.currentThread().getName() + instance.getClass());
                }
            }, "线程" + i);
            thread.start();
            thread.join();
        }
//        Thread.sleep(2000);
        System.out.println(HungrySingleton.getInstance().a);

        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<threads;i++){
            Thread task = new Thread(new Runnable() {
                @Override
                public void run() {
                    HungrySingleton instance = HungrySingleton.getInstance();
                    instance.add();
//                    System.out.println(Thread.currentThread().getName() + instance.getClass());
                }
            }, "线程" + i);
            executorService.submit(task);
//            task.join();
            endGate.countDown();
        }
//        Thread.sleep(4000);
        endGate.await();
        System.out.println(HungrySingleton.getInstance().a);

    }
}


