package com.line.algorithm;

/**
 * @author 54623
 * @date 2022/5/14 21:32  滑动窗口算法
 * 给定一个含有n个正整数的数组，和一个正整数 target,找出该数组中满足其和 >= target 的长度最小的连续子数组，并返回器其长度。
 */
public class HuaDongChuangKou {


    public static void main(String[] args) {
        int target = 7;
        int nums[] = {2, 3, 1, 2, 4, 3};
        int result = HuaDongChuangKou(target, nums);
        int result2 = HuaDongChuangKou2(target, nums);
        System.out.println(result);
        System.out.println(result2);

    }

    //找出该数组中满足其和 >= target 的长度最小的连续子数组，并返回器其长度
     static int HuaDongChuangKou(int target, int nums[]) {
        int left = 0; //左指针
        int right = 0;  //右指针
        int sum = 0;
        int minLength = 0;

        while (right < nums.length) {
            sum = sum + nums[right];
            while (sum >= target) {
                if (right - left + 1 < minLength || minLength == 0) {
                    minLength = right - left + 1;
                }
                sum = sum - nums[left];
                left++; //缩小窗口
            }
            right++; //增大窗口
        }
        return minLength;
    }

    //找到 <= 7 的最大连续子数组，并返回其长度
    static int HuaDongChuangKou2(int target, int nums[]) {
        int left = 0; //左指针
        int right = 0;  //右指针
        int sum = 0;
        int minLength = 0;

        while (right < nums.length) {
            sum = sum + nums[right];
            while (sum > target) {
                sum = sum - nums[left];
                left++; //缩小窗口
            }
            if (right - left + 1 > minLength || minLength == 0) {
                minLength = right - left + 1;
            }
            right++; //增大窗口
        }
        return minLength;
    }
}
