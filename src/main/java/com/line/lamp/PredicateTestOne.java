package com.line.lamp;

import java.util.function.Predicate;

public class PredicateTestOne {

    public static void main(String[] args) {

        PredicateTestOne predicateTestOne = new PredicateTestOne();

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {

                return s.equals("zhangsan");
            }
        };

        System.out.println(predicate.test("lisi"));
        System.out.println("--- --- --- --- --- ---");
        System.out.println(predicate.test("zhangsan"));
    }
}
