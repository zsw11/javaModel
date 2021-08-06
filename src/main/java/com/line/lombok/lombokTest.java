package com.line.lombok;

/**
 * @author zsw
 * @date 2021/8/5 18:14
 */
public class lombokTest {
    public static void main(String[] args) {
        User user = User.builder().testHobbies("ss").testHobbies("wwww").build();
        System.out.println(user);
    }
}
