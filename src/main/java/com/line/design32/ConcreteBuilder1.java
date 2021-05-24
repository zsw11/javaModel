package com.line.design32;

/**
 * 具体建造者，实现了抽象建造者接口。 建造者对象1
 */
public class ConcreteBuilder1 extends Builder {
    public void buildPartA() { product.setPartA("建造1 PartA"); }
    public void buildPartB() {
        product.setPartB("建造1 PartB");
    }
    public void buildPartC() {
        product.setPartC("建造1 PartC");
    }
}
