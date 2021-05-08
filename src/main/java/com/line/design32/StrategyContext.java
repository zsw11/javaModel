package com.line.design32;

/**
 * @author zsw
 * @date 2021/5/8 16:22
 * @description : 策略模式
 */
public class StrategyContext {
    private TravelStrategy strategy;
    public StrategyContext(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public int calculateMinCost(){
        return strategy.calculateMinCost();
    }
}
