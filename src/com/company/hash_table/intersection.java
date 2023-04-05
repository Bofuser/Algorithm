package com.company.hash_table;


import java.util.HashSet;
import java.util.Set;


/**
 * 题意：
 * 两个数组的交集
 * 给定两个数组 nums1 和 nums2 ，返回它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * 示例
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *
 */


public class intersection {


    /**
     * 解题思路
     *
     *  （1）将一个数组 nums1 转换成Set1集合,
     *  （2）数组 num2 和 Set1进行比较，如果有相同的数组元素，则存储到新的resultSet中
     *  （3）最后转化成新的数组输出出去。
     *
     * @param nums1
     * @param nums2
     * @return
     */

    public int [] intersection(int [] nums1, int [] nums2){

        //判断给定的数组确保不为空
        if(nums1 == null || nums1.length == 0|| nums2 == null || nums2.length == 0){

            return new int[0];

        }

        //（1）创建一个Set1，用来将nums1 转换成HashSet
        Set<Integer> set1 = new HashSet<>();

        //遍历数组nums1,将其存储到HashSet中
        for(int num : nums1){
            set1.add(num);
        }

        //(2)创建一个resultSet，用来比较 nums2是否和set1中有相同的元素，有则存储进去
        Set<Integer> resultSet = new HashSet<>();
        for(int num : nums2){
            if(set1.contains(num)){
                resultSet.add(num);
            }
        }

        //转换成数组输出出去
        int [] result = new int[resultSet.size()];
        int i = 0;
        for(int num : resultSet){
            result[i++] = num;
        }

        return result;



    }


}
