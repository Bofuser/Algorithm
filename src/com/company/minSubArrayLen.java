package com.company;


/**
 * 题型：长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 *
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3] 输出：2 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 */


public class minSubArrayLen {

    public static void main(String[] args) {

        int [] nums = {2,3,1,2,4,3};
        int index = 8;

       //System.out.println(minSubArrayLen(index,nums));

        System.out.println(minSubArrayLen2(index,nums));

    }


    // 滑动窗口
    public static int minSubArrayLen2(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }



    public static int minSubArrayLen(int index, int [] nums){

        //初始化左指针为0，即为窗口的初始位置
        int left = 0;
        //设置一个最大值后面用来判断
        int result = Integer.MAX_VALUE;

        //sum即为求取窗口范围中的总值
        int sum = 0;


        //right为右指针，也即为窗口的终点位置。通过其移动来判断。
        for(int right = 0; right < nums.length; right++){

            sum += nums[right];

            //判断如果sum的值总和加起来大于s，则左指针移动，减少窗口的大小，且要减去之前被包含在最左边的值。
            while(sum >= index){

                sum -= nums[left];

                // 将值和 result进行比较，是否满足条件下长度最小的子数组。right -left + 1为子数组长度大小

                result = Math.min(result, right - left + 1);
                //左指针移动，+1
                left++;

            }

        }

        return result == Integer.MAX_VALUE ? 0 :result;

    }




}
