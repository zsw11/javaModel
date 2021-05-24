package com.line.design32;

/**
 * 建造者模式 测试类
 */
public class Client {
    public static void main(String[] args) {
        ConcreteBuilder1 concreteBuilder1 = new ConcreteBuilder1();
        Director director1 = new Director(concreteBuilder1);
        Product product = director1.construct();

        ConcreteBuilder2 concreteBuilder2 = new ConcreteBuilder2();
        Director director2 = new Director(concreteBuilder2);
        Product construct = director2.construct();
    }
}