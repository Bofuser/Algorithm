package com.company.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {


    public static void main(String[] args) {

        int[] nums1 = {1, 0, -1, 0, -2, 2};
        int[] nums2 = {2, 2, 2, 2, 2};
        int[] nums3 = {1000000000, 1000000000, 1000000000, 1000000000};
        int target1 = -4;
        int target2 = 8;
        int target3 = -294967296;
        System.out.println(fourSum(nums1, target1));

    }


    /**
     * 解题思路：
     * 使用双指针法。可以枚举 2 个数组，将其设为 i , j;后面两个数组 设为 j+1, nums.length -1;可以将 j,j+1,nums.length -1
     * 看为一个 求和三数组
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        //初始化一个列表，用于存储数组
        List<List<Integer>> result = new ArrayList<>();
        //判断数组不能为空
        if (nums == null || nums.length < 4) {
            return result;
        }


        //(1) 排序数组
        Arrays.sort(nums);
        //使用一个 for 循环
        for (int i = 0; i < nums.length; i++) {

            //减枝操作。
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }

            //第一层去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {

                //在外层遍历中去重，否则会得到相同的三元组，去重之后再进去第二层循环。
                //第二层去重
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                for (int left = j + 1, right = nums.length - 1; left < right; ) {


                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {

                        //找到符合条件的四元组
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));


                        //第三层去重
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;


                        left++;
                        right--;

                    } else if (sum < target) { // 当sum 太小时，区间右移动

                        left++;

                    } else {
                        //当sum太大时，区间左移动
                        right--;
                    }
                }
            }
        }

        return result;

    }


}
