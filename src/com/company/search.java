package com.company;


/**
 *  题型：二分法查找
 *  题目：给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，
 *  如果目标值存在返回下标，否则返回 -1。
 *
 * 示例一：输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 *
 * 示例二：输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 *
 *
 *
 * 二分法查询
 *
 * 解题思路：
 * 首先：分两种情况（1）区间左闭右闭型[left,right],（2）区间左闭右开型[left, right)
 *
 * 对于（1），需要循环条件 while(left <= right), right = middle - 1;(区间包含middle，故不用在middle查询，因为 num[middle] > target了)
 * 对于（2），需要循环条件 while(left < right), right = middle;(区间本来就不包含middle， 故可以直接middle)
 *
 * 计算中间值方法  middle = left + ((right - left)/2) 或 middle = (right + left)/2  或 middle = left + ((rignt - left) >> 1)
 *
 * 当 num[middle] < target 值时，左边区间向右靠拢一步，即 left = middle + 1;
 * 当 num[middle] > target 值时，右边区间向左靠拢一步，即 right = middle -1
 * 直到 num[middle] = target 时退出循环。 注意要区分数组中的下标和数组的值，不要把两者搞混了。
 *
 *
 *
 */
public class search {

    public static void main(String[] args) {

        //初始一个数组
        int [] num = {1,2,3,4,5,6,7,8,9,10};
        int target = 8;

        //方法一
//        System.out.println(rank1(num, target));
        //方法二
        System.out.println(rank2(num,target));

    }

    public static int rank1(int [] num, int target){

        //定义下标
        int left = 0;
        //right 下标要减1
        int right = num.length - 1;


        while (left <= right) {
            //给个数组的范围不要让目标函数超过数组中的值。 注意数组最右边的下标要减1
            if (target < num[0] || target > num[num.length - 1]) {
                return -1;
            }

//            int middle = left + ((right - left )/2);
//            int middle = (right + left)/2 ;
            int middle = left + ((right - left) >> 1);

            //当数组中的中间值小于目标值时,左边区间右移一个单位。当中间值大于目标值时，右边区间向左移动一步
            if (num[middle] < target) {
                left = middle + 1;
            } else if (num[middle] > target) {
                right = middle - 1;
            } else if (num[middle] == target){ //两种情况都不是，则为相等。

                return middle;
            }
        }
        return 1;
    }

    public static int rank2(int [] num, int target){

        //定义左右下标
        int left = 0;
        int right = num.length - 1;

        while (left < right){

            //给个数组的范围不要让目标函数超过数组中的值。 注意数组最右边的下标要减1
            if (target < num[0] || target > num[num.length - 1]) {
                return -1;
            }

            //定义middle的值
            int middle = (right + left)/2 ;


            if(num[middle] < target){
                left = middle + 1;
            }else if (num[middle] > target){
                right = middle;
            }else if(num[middle] == target){
                    return middle;
            }



        }


        return 1;
    }








}
