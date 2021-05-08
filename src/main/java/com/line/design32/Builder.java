package com.line.design32;

/**
 * @author zsw
 * @date 2021/5/8 16:46  建造者模式
 * @description :抽象建造者：包含创建产品各个子部件的抽象方法。
 */
public abstract class Builder {
    protected Product product = new Product();

    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();

    public Product getResult() {
        return product;
    }
}
