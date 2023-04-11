package com.company.hash_table;

import java.util.HashMap;
import java.util.Map;


/**
 *  题目：
 *  给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *  0 <= i, j, k, l < n
 *  nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 *  输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 *  输出：2
 *  解释：
 *  两个元组如下：
 *  1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 *  2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 *
 *
 *  解题思路：
 *  （1）定义一个哈希表，用来存放数组1和数组2的值（这里简称大数组A）,map中的key用来存放大数组A的和，
 *  value用来存放大数组A中key值出现的次数。
 *  （2)遍历循环数组A
 *  （3）遍历循环数组3和数组4的值（这里简称大数组B），由于 A+B = 0; A = -B。所以用来判断 -B 中是否包含值。
 *   如果包含了-B，则统计次数res+1，表示 nums1+nums2+nums3+nums4 = 0;有多少次。
 *
 *
 *
 *
 */


public class fourSumCount {

    public static void main(String[] args) {

        int [] nums1 = new int[]{1,2};
        int [] nums2 = new int[]{-2,-1};
        int [] nums3 = new int[]{-1,2};
        int [] nums4 = new int[]{0,2};

        int a = forSumCount(nums1,nums2,nums3,nums4);
        System.out.println(a);

    }




    public static int forSumCount(int [] nums1, int[] nums2, int[] nums3, int[] nums4){

        //定义一个哈希表map来存放所求的值。其中 key 用来存储 大数组A的值
        Map<Integer,Integer> map = new HashMap<>();
        //定义一个res来统计
        int res = 0;
        //定义一个临时变量用来暂存数组A和数组B的值
        int temp;

        //(1)遍历数组1+数组2
        for(int i : nums1){
            for(int j : nums2){
                //nums1+nums2 的值
                temp = i + j;
                //将temp的值存储到map中
                if(map.containsKey(temp)){

                    //判断temp出现次数，每出现一次就+1。map.get 是根据键获取值。
                    map.put(temp,map.get(temp)+1);

                }else {

                    //否则temp出现一次就加1
                    map.put(temp,1);

                }


            }
        }

        //(2)遍历数组3+数组4
        for(int i : nums3){
            for(int j : nums4){

                //计算数组3+数组4的值
                temp = i + j;

                //由于 A+B = 0; A = -B。所以用来判断 -B 中是否包含值。
                // 如果包含了-B，则统计次数res+1，表示 nums1+nums2+nums3+nums4 = 0;有多少次。
                if(map.containsKey(-temp)){

                    //表示符合出现的键值次数加一
                    res += map.get(-temp);

                }


            }
        }

    return res;

    }



}
