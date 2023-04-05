package com.company.hash_table;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」 定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * 举例：
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 */

public class isHappy {


    /**
     * 解题思路:
     *
     * （1）计算快乐数
     * （2）存储到set集合中进行判断是否有重复的数。如果是快乐数是没有重复的数，否则有。
     *
     *
     * @param n
     * @return
     */

    //(2)存储到 Set 集合中进行判断是否有重复的数。如果是快乐数是没有重复的数，否则有。
    public boolean isHappy(int n){

        // 初始化一个 Set 集合
        Set<Integer> set = new HashSet<>();

        while(n != 1){

            //set集合存储 n
            set.add(n);
            //调用快乐数函数
            n = getNext(n);

            //如果集合set包含 重复函数
            if(set.contains(n)){
                return false;
            }

        }

        return true;

    }

    //（1）编写快乐数函数，
    public int getNext(int n){

        int totalSum = 0;

        while( n > 0){

            //求出 n 的个位数
            int digit = n % 10;
            //求出n 的十位数
            n = n / 10;
            //第一次计算的是个位数的累加和，进行累加计算
            // 在第二次循环中计算累加的是十位数，计算出个位和十位得到累加和，直到 n=0.
            totalSum += digit * digit;

        }
        return totalSum;

    }



}
