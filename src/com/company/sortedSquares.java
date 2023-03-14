package com.company;


import java.util.Arrays;

/**
 *
 * 题型：有序数组的平方
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *示例 1： 输入：nums = [-4,-1,0,3,10] 输出：[0,1,9,16,100] 解释：平方后，
 * 数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
 *
 *示例 2： 输入：nums = [-7,-3,2,3,11] 输出：[4,9,9,49,121]
 *
 */


public class sortedSquares {

    public static void main(String[] args) {

        // {0,1,9,16,25}
        int [] nums = {-4, -1, 0, 3, 5};

        // 方法一：暴力解法
//        System.out.println(sortedSquares1(nums));
        //方法二：双向指针法
        System.out.println(sortedSquarest2(nums));

    }

    /**
     * 暴力排序
     * @param nums
     *分为两步走：
     * (1)数组直接平方
     * (2)给数组排序，使用排序数组Array.sort(nums)
     *
     */

    public static int [] sortedSquares1(int [] nums){


        for(int i = 0; i < nums.length; i ++){

            nums[i] = nums[i] * nums[i];

        }
        Arrays.sort (nums);

        return nums;

    }


    /**
     *  使用双指针法
     *  从左、右两边向中间靠拢查询。置一个result数组，从后往前存储，左边和右边比大小，大的存储到result中。
     *
     * @param nums
     * @return
     */
    public static int [] sortedSquarest2(int [] nums){

        //i为从左边数起来，k从右边数起来，result是新的数组，用来存储排序的结果。
        int i = 0;
        int k = nums.length - 1;
        int [] result = new int [nums.length];
        //index是result的下标，故要减1
        int index = result.length - 1;

        //判断它的值是否大于所需的值
        while(i < k){

            if(nums[i] * nums[i] < nums[k] * nums[k]){

                result[index--] = nums[k] * nums[k];
                k--;

            }else {

                result[index--] = nums[i] * nums[i];
                i++;

            }
        }
        return result;
    }
}
