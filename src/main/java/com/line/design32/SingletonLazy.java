package com.line.design32;

/**
 * @author zsw
 * @date 2021/5/8 10:23
 * @description : 在每一届任期内，美国的总统只有一人，所以本实例适合用单例模式实现
 */
public class SingletonLazy {
    public static void main(String[] args) {
        President president = President.GetInstance();
        president.getName(); // 输出总统的名字
        President president1 = President.GetInstance();
        president1.getName(); //输出总统的名字
        if (president == president1) {
            System.out.println("他们是同一个人");
        } else {
            System.out.println("他们不是同一个人");
        }
    }

   static class President{
        private static volatile President instance = null;

        private President() {
            System.out.println("产生一个总统");
        }

        public static synchronized President GetInstance(){
            if (instance == null) {
                instance = new President();
            }else {
                System.out.println("已经有一个总统了");
            }
            return instance;
        }

       public void getName() {
            System.out.println("我是美国总统周述文");
       }
    }
}
