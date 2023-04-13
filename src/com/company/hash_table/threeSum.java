package com.company.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意： 答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 *
 *
 */


public class threeSum {

    public static void main(String[] args) {

        int [] nums1 = {-1,0,1,2,-1,-4};
        int [] nums2 = {0,-1,-1};
        int [] nums3 = {0,0,0};


        System.out.println(threeSum(nums3));


    }

    /**
     *  解题思路：
     *  使用双指针法，定义三个指针，分别为 i, i+1, nums.length -1。定住一个i指针，移动其他两个指针i+1，和nums.length -1.
     *   (1) 对数组从小到大进行排序，并且去重数组。
     *   (2) 假设当前元素为nums[i]，将问题转化为 nums[i+1, n-1]的区间内找到两个数之和为 -nums[i]。找到满足的两个数
     *   这个问题就变成了从区间 nums[i+1,n-1] 中不断移动左右两个指针，直到指针相遇为止。期间要注意指针的重合。
     *   (3)在遍历时，要注意左值针左边的指针和右指针右边的指针是否有重合，要设置条件避免重合。
     *
     *
     * @param nums
     * @return
     */

    public static List<List<Integer>> threeSum(int[] nums){


        List<List<Integer>> result = new ArrayList<>();

        //(1)排序数组, 从大到小，从左到右进行排序
        Arrays.sort(nums);

        // 找出 a+b+c = 0;
        // a = nums[i], b = nums[left], c = nums[right]

        for(int i = 0; i < nums.length; i++){


            // 排序之后如果第一个元素(排序后第一个为最小)已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            //在外层遍历中去重，否则会得到相同的三元组，去重之后再进去第二层循环。
            if(i > 0 && nums[i] == nums[i-1]) continue;

            //设置左右指针
            int left = i+1;
            int right = nums.length -1;

            //添加循环，当左指针小于右指针时
            while (left < right){


                int sum = nums[i] + nums[left] + nums[right];
                //如果求出了sum  = 0 时，则缩小遍历空间
                if(sum == 0){

                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));


                    //跳过重复函数 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while(left < right && nums[left] == nums[left -1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;

                    left++;
                    right--;

                } else if(sum < 0){
                    left++;
                } else{
                    right--;
                }


            }



        }

    return result;


    }




}
