package com.line.design32;

/**
 * @author zsw
 * @date 2021/5/8 14:25
 * @description : 工厂方法模式，生产同一种产品。
 *                抽象工厂模式，生产同一族产品。
 */
public class AbstractFactoryTest {


    /**
     * 抽象产品，提供了产品的接口
     */
    interface Productshouji {
        public void show();
    }

    /**
     * 具体产品1
     */
    class ConcreteProduct1 implements Productshouji {
        @Override
        public void show() {
            System.out.println("手机产品显示1");
        }
    }
    /**
     * 具体产品2
     */
    class ConcreteProduct2 implements Productshouji {
        @Override
        public void show() {
            System.out.println("手机产品显示2");
        }
    }
    /**
     * 抽象产品，提供了产品的接口
     */
    interface Productdianshi {
        public void show();
    }

    /**
     * 具体产品1
     */
    class ConcreteProductd1 implements Productdianshi {
        @Override
        public void show() {
            System.out.println("电视产品显示1");
        }
    }
    /**
     * 具体产品2
     */
    class ConcreteProductd2 implements Productdianshi {
        @Override
        public void show() {
            System.out.println("电视产品显示2");
        }
    }

    /**
     * 抽象工厂，提供产品生成方法
     */
    interface AbstractFactory {
        Productshouji newProduct();
        Productdianshi newProduct2();
    }
    /**
     * 具体工厂1：实现了厂品的生成方法
     */
    class ConcreteFactory1 implements AbstractFactory {
        public Productshouji newProduct() {
            System.out.println("具体工厂1生成-->具体产品1...");
            return new ConcreteProduct1();
        }

        @Override
        public Productdianshi newProduct2() {
            return null;
        }
    }
    /**
     *  具体工厂2：实现了厂品的生成方法
     */
    class ConcreteFactory2 implements AbstractFactory {
        public Productshouji newProduct() {
            System.out.println("具体工厂2生成-->具体产品2...");
            return new ConcreteProduct2();
        }

        @Override
        public Productdianshi newProduct2() {
            return null;
        }
    }
}
