package com.line.lamp;

import com.line.lombok.User;

import java.util.List;
import java.util.Optional;

/**
 * @author zsw
 * @date 2021/8/11 14:05
 * Optional(T value),        empty(),        of(T value),       ofNullable(T value)
 * orElse 和 ifPresent 区别，orElse是 Option对象为null,执行后面结果，有返回值。IfPresent是Option对象不为null,执行后面的操作，没有返回值
 */
public class OptionalTest {
    public static void main(String[] args) {
        String subDesc = "ZLO20210420000000011220119,";
        String sub = subDesc.substring(0, subDesc.length() - 1);
        System.out.println(sub);
        int a = sub.length();
        StringBuilder stringBuilder = new StringBuilder(sub);
        int b = stringBuilder.length();
        String a1 = stringBuilder.toString();
        User user = User.builder().testHobbies("ss").testHobbies("wwww").build(); //创建user对象
        User userNull = null;
        User user1 = Optional.ofNullable(userNull).orElse(User.builder().build());//userNull可以为null，如果为null,则返回user1（User.builder().build()）
        User userNotNull = User.builder().testHobbies("s1").testHobbies("w1").build(); //创建user对象
        User userOrElse = Optional.ofNullable(userNotNull).orElse(User.builder().build());//userNull可以为null，如果为null,则返回user1（User.builder().build()）
        User userOrElseGet = Optional.ofNullable(userNull).orElseGet(() -> { return user; });// 可以获取返回值的orElseGet
        System.out.println(user1);
        System.out.println(userOrElse);
        System.out.println(userOrElseGet);
//        User user2 = null;
//        User user3 = Optional.of(user2).orElse(User.builder().build()); //java.lang.NullPointerException
        User user4 = null;
        User user5 = Optional.ofNullable(user4).orElse(User.builder().build());
        System.out.println(user5);
        User user6 = null;
        boolean present = Optional.ofNullable(user6).isPresent(); //isPresent()：判断值是否存在
        Optional.ofNullable(user).ifPresent(u -> {System.out.println("i-"+user.getHobbies());});
        Optional.ofNullable(user).ifPresent(u -> {System.out.println("p-"+user.getPassword());});
        Optional.ofNullable(user6).ifPresent(u -> {System.out.println("null-"+user.getHobbies());});
        System.out.println(present);
        Optional.ofNullable(user).map(User::getHobbies).ifPresent(System.out::println); //ss,wwww
        //List<String> strings = Optional.ofNullable(user6).map(User::getHobbies).get(); //new NoSuchElementException("No value present")
        User build = User.builder().build();
        System.out.println(build.getHobbies());
        Optional.ofNullable(user6).map(User::getHobbies); // 这样不会报错
        List<String> strings = Optional.ofNullable(user6).map(User::getHobbies).get(); //get() 报 new NoSuchElementException("No value present")
        System.out.println(strings);
    }
}

