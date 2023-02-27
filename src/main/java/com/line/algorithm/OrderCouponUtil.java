package com.line.algorithm;


import java.sql.SQLSyntaxErrorException;
import java.util.*;

/**
 * @ClassName: OrderCouponUtil
 * @Description: TODO
 * @Company: 广州市两棵树网络科技有限公司
 * @Author: xiaosong.zhou
 * @Date: 2021/11/25 10:05
 */
public class OrderCouponUtil {

    private OrderCouponUtil() {
        throw new AssertionError();
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        List<Integer> overK = getOverK(integers, 6);
        System.out.println(overK);
        int k = 6;
        int sun = 0;
        int geShu = 0;
        for (int i = 0; i < integers.size(); i++) {
            for (int j = i + 1; j < integers.size(); j++) {
                if (integers.get(i) + integers.get(j) >= k) {
                    
                }
            }
        }
    }

    public static List<Integer> getOverK(List<Integer> ms, int k) {
        //从ms个数中任取i个数，满足其和大于等于k且最接近k，求i值最小时对应的组合。
        //ms无重复元素
        Collections.sort(ms);
        for (int i = 0; i < ms.size(); i++) {
            List<Integer> ns = select(k, i+1, ms);  // k 优惠劵门槛  ms商品
            if (null != ns && ns.size() != 0) {
                return ns;
            }
        }
        return Collections.emptyList();
    }

    private static List<Integer> select(int k, int n, List<Integer> ms) {
        //从ms中任取i个数，和大于等于k时对应的组合
        Map<Integer, List<Integer>> base = new HashMap<>();
        List<List<Integer>> matches = permute(ms, new ArrayList<>(), n);
        for (List<Integer> match : matches) {
            int sum = 0;
            for (Integer m : match) {
                sum += m;
            }
            base.putIfAbsent(sum, match);
        }
        Integer key = base.keySet().stream().filter(Objects::nonNull).filter(e -> e >= k).min(Comparator.naturalOrder()).orElse(0);
        return base.get(key);
    }

    public static List<List<Integer>> permute(List<Integer> ms, List<List<Integer>> matches, int n) {
        //从ms中任取n个数的排列组合
        matches.clear();
        permutation(ms, matches, n, new ArrayList());
        return matches;
    }

    public static void permutation(List<Integer> ms, List<List<Integer>> matches, int n, List<Integer> list) {
        if(list.size() == n) {
            matches.add(list);
            return;
        }
        for(int i = 0;i < ms.size();i++) {
            if(!list.contains(ms.get(i))) {
                List<Integer> temp = new ArrayList<>(list);
                temp.add(ms.get(i));
                permutation(ms, matches, n,temp);
            }
        }
    }

}
