package com.company.array;


/**
 * 题型：移除数组
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5,
 * 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 */


public class Remove_element {

    public static void main(String[] args) {

        int [] nums = {1,2,2,3,4,5,6,7,7,7,7};
        int val = 7;

        //方法一暴力解法
//        System.out.println("方法一：");
//        System.out.println(removeElement1(nums,val));

//        方法二返回的是慢指针的索引值
        System.out.println("方法二：");
        System.out.println(removeElement2(nums,val));

        //方法三chatGPT暴力解法(错误不太行)
//        System.out.println("方法三：");
//        System.out.println(removeElement3(nums,val));

    }


    /**
     * 方法一：暴力解法
     * @param nums
     * @param val
     * @return length
     *
     * 通过后面一位来覆盖前面一位的值，进而覆盖前面。
     */
    public static int removeElement1(int [] nums, int val){

        int length = nums.length;
        //遍历循环每一个数组
        for(int i = 0; i < length; i++){

            //当val值等于其中一个时,数组向前覆盖
            if(nums[i] == val){

                //发现需要移除的元素时
                for(int j = i+1; j < length; j++){
                    nums[j-1] = nums[j];
                }

                //覆盖之后长度减少,因为下标都向前移动了一位，所以i也向前移动。
                i--;
                length--;
            }
        }

        return length;

    }

    /**
     * 慢指针方法
     * @param nums
     * @param val
     * @return showIndex
     *
     * 返回快慢指针索引
     *
     */

    public static int removeElement2(int [] nums, int val){

        //slowIndex就是新数组，将旧数组赋值到新数组中。
        int slowIndex = 0;
        for(int fastIndex = 0; fastIndex < nums.length; fastIndex++){

            //如果快指针的值等于val值，则将快指针的值赋予给慢指针
            if(nums[fastIndex] != val){

                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }

        }
        //返回索引值就是新数组的大小
        return slowIndex;


    }

    /**
     * 方法三：chatGPT暴力解法
     * @param nums
     * @param val
     * @return
     *
     * 使用数组最后的值来赋值前面的值，然后再减少数组的长度。比起第一种方法速度快很多，不用一个个赋值到前面一个。
     *
     */
    public static int removeElement3(int [] nums, int val){

        int length = nums.length;

        for (int i = 0; i < length; i++){

            //如果循环中数组有与他相等的值
            if(nums[i] == val){

                // 将数组中的最后值赋值到val值中
                nums[i] = nums[length - 1];
                //
                length --;
            }
        }

        return length;

    }




}
