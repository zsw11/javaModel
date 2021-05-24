package com.line.design32;

/**
 * @author zsw
 * @date 2021/5/8 16:46  建造者模式，根据一个类，组成成分不同来创建的对象，比如电脑是由cpu 磁盘组成。我们创建两个对象，一个i5,500T.一个i7,1000T.
 * @description :抽象建造者：包含创建产品各个子部件的抽象方法。
 *
 * 建造者（Builder）模式的主要角色如下。
 * 产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个零部件。
 * 抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。
 * 具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 * 指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
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
