package com.line.design32.ifelse;

// 运行时动态确定，根据配置文件的配置决定使用哪种策略
public class Application {
  public static void main(String[] args) throws Exception {
    StrategyFactory factory = new StrategyFactory(); 
    Strategy strategy = factory.getStrategy("A"); //获取策略类
    strategy.algorithmInterface(); //调用策略接口
    //...
    Strategy strategy2 = factory.getStrategy("zsw11"); //获取策略类
    strategy2.algorithmInterface(); //调用策略接口
  }
}