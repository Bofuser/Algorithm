package com.company.character_String;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * <p>
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */

public class strStr {

    public static void main(String[] args) {

        String h1 = "sadbutsad";
        String h2 = "leetcode";
        String n1 = "sad";
        String n2 = "leeto";

        System.out.println(strStr(h1, n1));
        System.out.println(strStr(h2, n2));

    }

    public static int strStr(String haystack, String needle) {

        if (haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0) {
            return 0;
        }

        int index = 0;

        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();

        // （1）使用 contains函数判断字符串needle是否包含在haystack中

        if (haystack.contains(needle)) {
            //如果相等，返回 haystack第一个匹配项的下标
            for (int i = 0; i < chars1.length; i++) {

                //(2) 如果包含，则将该数组对应的下标表示出来。
                if (chars1[i] == chars2[0]) {
                    index = i;
                    break;
                }

            }
        } else {
            return -1;
        }


        return index;
    }


}
