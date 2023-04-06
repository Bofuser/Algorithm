package com.company.hash_table;


import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 示例：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 *
 *
 */



public class twoSum {


    /**
     * 解题思路：
     *  （1）用 target - 遍历的数组，所得的值在 map 中进行查找
     *  （2）如果存在则输出其键值，如果不在，则将遍历的数组存储到 map 中
     *
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int []nums, int target){

        //新建一个数组，用来存储后面的键值。
        int [] res = new int[2];

        // 判断数组不能为 null
        if(nums == null || nums.length == 0){
            return res;
        }

        //初始化一个map，用来存储一个数值
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            //(1)计算target - 遍历的数组，找出是否有和它相等的值。
            int temp = target - nums[i];

            // map.containsKey 判断集合是否包含指定的键
            if(map.containsKey(temp)){

                //将temp对应的值传给数组 这里注意temp是元素值，他所对应的值为数组下标值。
                res[1] = map.get(temp);
                res[0] = i;
                break;
            }

            //否则不相等时则将值存储到map中
            map.put(nums[i],i);


        }
        return res;

    }


}
