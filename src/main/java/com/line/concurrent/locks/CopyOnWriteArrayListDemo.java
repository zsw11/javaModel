package com.line.concurrent.locks;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author zsw
 * @date 2021/5/7 11:15
 * @description : 读多写少的场合使用(并且只要求数据最终一致性)， 读取不加锁， 写入、删除、修改时数据加锁
 * 缺点：数据一致性问题，CopyOnWrite容器只能保证数据的最终一致性，不能保证数据的实时一致性。所以如果你希望写入的的数据，马上能读到，请不要使用CopyOnWrite容器。
 *        内存占用问题：因为CopyOnWrite的写时复制机制
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        write();
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 5; i++) {
            boolean add = copyOnWriteArrayList.add(1);
            System.out.println("数据是否添加成功："+add);
        }
        boolean b = copyOnWriteArrayList.addIfAbsent(99); // 如果没有99 这个元素就添加就去
        boolean absent = copyOnWriteArrayList.addIfAbsent(1);
        System.out.println("元素99是否存在："+b+","+"元素1是否存在："+absent);
        copyOnWriteArrayList.set(2, 3);
        Integer integer = copyOnWriteArrayList.get(2);
        Iterator<Integer> iterator = copyOnWriteArrayList.iterator();
        System.out.println(integer);
        while (iterator.hasNext()) {
            System.out.println("迭代结果："+iterator.next());
        }
        copyOnWriteArrayList.remove(2);
        Integer intget2 = copyOnWriteArrayList.get(2);
        System.out.println(intget2);
        Iterator<Integer> iterator2 = copyOnWriteArrayList.iterator();
        while (iterator2.hasNext()) {
            System.out.println("迭代结果："+iterator2.next());
        }

    }

    public static void write(){
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 50; i++) {
            copyOnWriteArrayList.add(1);
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Integer integer = copyOnWriteArrayList.get(2);
                    System.out.println(integer);
                }
            });
        }

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                copyOnWriteArrayList.set(2, 100);
            }
        });

        executorService.shutdown();
    }
}
