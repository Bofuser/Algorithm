package com.company.hash_table;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * <p>
 * 如：输入: s = "anagram", t = "nagaram" 输出: true
 * <p>
 * 输入: s = "rat", t = "car" 输出: false
 */


public class isAnagram {


    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));


    }


    public static boolean isAnagram(String s, String t) {

        //初始化一个数组,大小为26包含26个字母，每个数组下标对应一个字符
        int[] record = new int[26];

        /**
         *
         * for循环遍历这个数组，s.charAt表示返回字符串中第 i 个字符。代码中‘a’的ASCII码值不用计算，因为s.charAt也表示
         * 字母，两个字母相加减会成阿拉伯数字。
         * 当 s.charAt(i) - 'a'表示数组的下标，对应的数组下标的值将会加 1。
         * 举个例子：
         * 假设 s.charAt(i) = b
         * 则代码为 record[‘b’ - 'a']++ = record[1]++， 表示数组 record 下标为 1 值 + 1；
         * 同理 record['z' - 'a']++ = record[25]++,  表示数组 record 下标为 25 的值+1；
         *
         */

        for (int i = 0, j = 0; i < s.length(); i++) {

            //表示 出现的字母在数组元素中加一
            record[s.charAt(i) - 'a']++;


        }

        for (int i = 0; i < t.length(); i++) {
            //表示 出现的字母在数组元素中减一
            record[t.charAt(i) - 'a']--;
        }

        //最后字符s和t出现相同的字符时，里面的数组元素相互抵消。 record为计数相等的字符，当record为0表示两个字符串相等。


        for (int count : record) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }


}
