package com.line.lamp.funcInterface;

import java.util.Optional;

/**
 * @author zsw
 * @date 2021/8/31 14:43
 * @Company: 广州市两棵树网络科技有限公司
 */
public class test1 {

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setPhone("110");
        getCity(user);
    }
    public static String getCity(User user) throws Exception{
        Optional.ofNullable(user).ifPresent(user1 -> {
            String s = user1.getName();
            User user2 = new User();
            user2.setName(s);
            System.out.println(s);
        });
        return "200";

    }
}
