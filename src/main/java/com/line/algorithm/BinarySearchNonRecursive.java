package com.line.algorithm;

/**
 * @desc 二分查询（非递归方式）
 * 案例：
 * {1,3,8,10,11,67,100}，编程实现二分查找，要求使用非递归方式完成。
 *@Author zsw
 * @Date 2019/9/27
 */
public class BinarySearchNonRecursive {

    public static void main(String[] args) {
        //遍历二维数组
//        int[][] a=new int[2][];
//        a[0] = new int[3];
//        a[1] = new int[4];
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[i].length; j++) {
//                System.out.print(a[i][j]);
//            }
//            System.out.println();
//        }
        int[] arr = {1, 3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 1);
        if (index != -1) {
            System.out.println("找到了，下标为：" + index);
        } else {
            System.out.println("没有找到--");
        }
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1; // 向左找
            } else {
                left = mid + 1; // 向右找
            }
        }
        return -1;
    }
}
