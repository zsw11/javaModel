package com.line.util;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * @author 54623
 * @date 2021/10/30 17:16
 * java只有值传递验证test
 */
public class CodeValueTest {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(24);
        user.setS("zsw");
        String s = "zsw1";
        int a = 24;
        List<String> list1 = Arrays.asList("a", "b", "c");
        change(user, s, a, list1);
        System.out.println("-----------");
        System.out.println(user);//CodeValueTest.User(age=25, s=zsw2)
        System.out.println(s);//zsw1
        System.out.println(a);//24
        System.out.println(list1);//[a, b, c]
        
    }

    private static void change(User user, String s, int a, List list1) {
        user.setS("zsw2");
        user.setAge(25);
        s = s.substring(1);
        a = a + 23;
        List<String> list2 = Arrays.asList("e", "f");
        list1 = list2;
        System.out.println(user);
        System.out.println(s);
        System.out.println(a);
        System.out.println(list1);
    }

    @Data
    private static class User{
        private Integer age;
        private String s;
    }
}
