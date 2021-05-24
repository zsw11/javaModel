package com.line.design32;

/**
 * @author zsw
 * @date 2021/5/8 13:43
 * @description : 原型模式，：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象
 */
public class PrototypeTest {
    static class Realizetype implements Cloneable {
        public Realizetype() {
            System.out.println("具体原型创建成功");
        }
        public Object clone() throws CloneNotSupportedException {
            System.out.println("具体原型复制成功");
            return (Realizetype)super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype realizetype = new Realizetype();
        Object clone = realizetype.clone();
        System.out.println("relizetype == clone？"+(realizetype==clone));// 深拷贝
    }
}
