package com.line.lombok;

/**
 * @author zsw
 * @date 2021/8/5 18:14
 */
public class lombokTest {
    public static void main(String[] args) {
        User user = User.builder().testHobbies("ss").testHobbies("wwww").build();
        System.out.println(user);
        int a = 305 /3;
        System.out.println(a);
        String s = subString("[Code:1327;Desc:订单购买人与支付单支付人名字或身份证号码不一致,订单购买人与支付单支付人名字和身份证不一致]", "Desc:", "]");
        System.out.println(s);
    }
    public static String subString(String str, String strStart, String strEnd) {
        int strStartIndex = str.indexOf(strStart);
        int strEndIndex = str.indexOf(strEnd);
        if (strStartIndex < 0 || strEndIndex < 0) {
            return "noString";
        }
        return str.substring(strStartIndex, strEndIndex).substring(strStart.length());
    }
}
