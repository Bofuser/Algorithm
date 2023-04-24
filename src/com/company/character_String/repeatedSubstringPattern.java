package com.company.character_String;


/**
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 */

public class repeatedSubstringPattern {

    public static void main(String[] args) {

        String s1 = "abab";
        String s2 = "aba";
        String s3 = "abcabcabc";
        System.out.println(repeatedSubstringPattern(s1));
        System.out.println(repeatedSubstringPattern(s2));
        System.out.println(repeatedSubstringPattern(s3));

    }


    /**
     * 解题思路：
     * （1）求出这个字符串中的中间位，且从中间位中不断向前推进判断
     * （2）推进时判断字符串长度是否可以整除某个数，如果可以，则证明有重复的字符串，否则返回false
     * （3）判断完如果是可以整除的话，则将字符对其
     *
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {


        //不能被s.length()整除，则
        for (int i = s.length() / 2; i >= 1; i--) {

            //判断其可以被整除时
            if (s.length() % i == 0) {
                //计算字串的个数有多少个
                int count = s.length() / i;
                //substring()函数是获取一个子字符串的函数，接受两个整数参数（i，j），表示获取的起始位置从i到j
                String sub = s.substring(0, i);
                //用于拼接 子串
                StringBuilder sb = new StringBuilder();
                //将截取的子串拼接起来，count为其子串的个数
                for (int j = 0; j < count; j++) {
                    sb.append(sub);
                }
                //判断拼接的子串是否和原来的字符s相等，如果相等返回true
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

}
