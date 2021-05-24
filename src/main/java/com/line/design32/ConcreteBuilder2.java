package com.line.design32;

/**
 * @author zsw
 * @date 2021/5/24 15:07
 * @description : 建造者对象2
 */
public class ConcreteBuilder2 extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("建造2 PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartA("建造2 PartA");
    }

    @Override
    public void buildPartC() {
        product.setPartA("建造2 PartA");
    }
}
