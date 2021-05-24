package com.line.design32.ifelse;

public interface Strategy {  //定义策略接口
  void algorithmInterface();
}

class ConcreteStrategyA implements Strategy {  //实现策略接口的策略类A
  @Override
  public void  algorithmInterface() {
    System.out.println("a");
    //具体的算法...
  }
}

class ConcreteStrategyB implements Strategy { //实现策略接口的策略类B
  @Override
  public void  algorithmInterface() {
    System.out.println("b");
    //具体的算法...
  }
}

class ConcreteStrategyC implements Strategy { //实现策略接口的策略类c
  @Override
  public void  algorithmInterface() {
    System.out.println("c");
    //具体的算法...
  }
}