package com.line.design32.strategy;

/**
 * @author zsw
 * @date 2021/5/24 17:11
 * @description : 客户端调用
 * @策略模式: 一个拥有共同行为的算法族，每个算法都被封装起来，可以互相替换，独立于客户端而变化
 */
public class Client {
    public static void main(String[] args) throws Exception {
        String param= "";
        Context context;
        if (param == "A") {
            context = new Context(new ConcreteStrategyA());
        } else if (param == "B") {
            context = new Context(new ConcreteStrategyB());
        } else if (param == "C") {
            context = new Context(new ConcreteStrategyC());
        } else {
            throw new Exception("没有可用的策略");
        }
        context.ContextFunC();
    }
}
