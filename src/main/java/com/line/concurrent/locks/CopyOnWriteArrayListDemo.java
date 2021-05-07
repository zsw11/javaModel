package com.line.concurrent.locks;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author zsw
 * @date 2021/5/7 11:15
 * @description : 读多写少的场合使用， 读取不加锁， 添加数据加锁
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
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
}
