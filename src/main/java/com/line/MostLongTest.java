package com.line;

import java.util.Arrays;

/**
 * @author zsw
 * @date 2021/11/25 17:49
 * @Company: 广州市两棵树网络科技有限公司
 */
public class MostLongTest {
    public static void main(String[] args) {
        int[] a = {1, 5, 2, 4, 3};
        int i = lengthOfLIS(a);
        System.out.println(i);
    }

    public static int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int result=1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                result=Math.max(result,dp[i]);
            }
        }
        return result;
    }

    public static int lengthOfLIS2(int[] nums) {
        int maxLen = 0;
        int[] dp = new int[nums.length];
        for(int num : nums){
            int l = 0, r = maxLen;
            while(l < r){
                int m = l+(r-l)/2;
                if(dp[m] < num)
                    l = m + 1;
                else
                    r = m;
            }
            dp[l] = num;
            if(l == maxLen) maxLen++;
        }
        return maxLen;
    }

}
