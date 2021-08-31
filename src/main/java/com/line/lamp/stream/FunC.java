package com.line.lamp.stream;

/**
 * @author zsw
 * @date 2021/8/10 10:38
 * 函数式接口
 */
@FunctionalInterface
public interface FunC {
    void run();
    boolean equals(Object a); // 可以有object 里的接口
}
