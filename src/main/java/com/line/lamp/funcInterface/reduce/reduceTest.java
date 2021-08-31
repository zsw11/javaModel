package com.line.lamp.funcInterface.reduce;

import java.util.Arrays;
import java.util.List;

/**
 * @author zsw
 * @date 2021/8/10 11:31
 * reduce 聚合求和
 */
public class reduceTest {
    public static void main(String[] args) {
        List<Integer> numList = Arrays.asList(1,2,3,4,5);
        int result = numList.stream().reduce(0,(a,b) ->  {
            System.out.println(a+"-----"+b);
            return a+b;
        } );  //a的初始值为0
        System.out.println(result);
        int result2 = numList.stream().reduce((a,b) -> {
            System.out.println(a+"-----"+b);
            return a+b;
        } ).get();
        System.out.println(result2);
    }
}
