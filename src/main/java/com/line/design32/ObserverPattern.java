package com.line.design32;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * @author zsw
 * @date 2021/5/8 17:28
 * @description :观察者（Observer）模式的定义：指多个对象间存在一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新
 */
public class ObserverPattern {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject(); // 目标
        Observer obs1 = new ConcreteObserver1(); // 观察者
        Observer obs2 = new ConcreteObserver2();
        concreteSubject.add(obs1);
        concreteSubject.add(obs2);
        concreteSubject.notifyObserver();
    }

    //抽象目标
    static abstract class subject{
        protected List<Observer> observers = new ArrayList<>();
        //增加观察者方法
        public void add(Observer observer) {
            observers.add(observer);
        }
        //删除观察者方法
        public void remove(Observer observer) {
            observers.remove(observer);
        }
        public abstract void notifyObserver(); //通知观察者方法
    }

     static class ConcreteSubject extends subject {

        @Override
        public void notifyObserver() {
            System.out.println("具体目标发生改变...");
            System.out.println("--------------");
            for (Object obs : observers) { // 遍历每一个目标,通知观察者
                ((Observer) obs).response();
            }
        }
    }

    //抽象观察者
    interface Observer {
        void response(); //反应
    }

    //具体观察者1
    static class ConcreteObserver1 implements Observer {
        public void response() {
            System.out.println("具体观察者1作出反应！");
        }
    }
    //具体观察者1
    static class ConcreteObserver2 implements Observer {
        public void response() {
            System.out.println("具体观察者2作出反应！");
        }
    }
}
