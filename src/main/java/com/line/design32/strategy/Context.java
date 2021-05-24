package com.line.design32.strategy;

/**
 * @author zsw
 * @date 2021/5/24 17:04
 * @description : 环境
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    //调用策略方法
    public void ContextFunC(){
        strategy.StrategyFunction();
    }
}
