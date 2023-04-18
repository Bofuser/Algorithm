package com.company.character_String;

/**
 * 题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 */


public class reverseLeftWords {

    public static void main(String[] args) {

        String s1 = "abcdefg";
        int k1 = 2;
        String s2 = "lrloseumgh";
        int k2 = 6;

        System.out.println(reverseLeftWords(s1, k1));
        System.out.println(reverseLeftWords(s2, k2));


    }


    /**
     * 解题思路：
     * 可以根据翻转字符串里的单词方法进行求解
     * （1）将字符全部反转
     * <p>
     * （2）给定反转的范围，对其进行反转
     * 因为区间是固定的，所以反转的时候区间可以设为：[0,charArr - n - 1]，[charArr - n, charArr - 1]
     *
     * @param s
     * @param n
     * @return
     */

    public static String reverseLeftWords(String s, int n) {

        //将字符串转换为数组
        char[] chars = s.toCharArray();

        //(1) 全部翻转
        reverseAll(chars, 0, chars.length - 1);

        //(2)  给定反转的范围
        reverseRange(chars, n);

        //返回反转后的字符 String
        return new String(chars);


    }

    /**
     * 反转函数
     *
     * @param chars
     * @param start 遍历开始
     * @param end   遍历结束
     */
    public static void reverseAll(char[] chars, int start, int end) {

        while (start < end) {

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;

        }


    }

    /**
     * @param chars
     * @param n     为反转的范围
     */
    public static void reverseRange(char[] chars, int n) {


        //反转前 chars.length - n - 1个
        reverseAll(chars, 0, chars.length - n - 1);
        //反转后面剩余的
        reverseAll(chars, chars.length - n, chars.length - 1);

    }


}
