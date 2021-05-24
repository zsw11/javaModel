package com.line.design32.ifelse;

import java.util.HashMap;
import java.util.Map;

/**
 * 工厂模式里的Map进行创建策略
 */
public class StrategyFactory {
  private static final Map<String, Strategy> strategies = new HashMap<>();

  static {
    strategies.put("A", new ConcreteStrategyA());
    strategies.put("B", new ConcreteStrategyB());
    strategies.put("C", new ConcreteStrategyC());
  }

  public Strategy getStrategy(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("type should not be empty.");
    }
    // 写个难点的if 判断，作为c的判断，以后可以在这里扩展if
      if (type.contains("zsw")) {
//         int num = Dao.select("zsw");
//         num >=100;
        return strategies.get("C");
      }
    return strategies.get(type);
  }
}