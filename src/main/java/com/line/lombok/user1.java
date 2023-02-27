package com.line.lombok;

/**
 * @author zsw
 * @date 2022/1/21 11:33
 * @Company: 广州市两棵树网络科技有限公司
 */
public class user1 {
    private String id;
    private String name;

    public static void main(String[] args) {
        user1 user1 = new user1();
        user1.setId("1");
        System.out.println(user1);
    }

    @Override
    public String toString() {
        return "user1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
