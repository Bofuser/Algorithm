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
        String h3 = "aabaabaaf";
        String n1 = "sad";
        String n2 = "leeto";
        String n3 = "aabaaf";


        System.out.println(strStr(h3, n3));
        /*System.out.println(strStr(h1, n1));
        System.out.println(strStr(h2, n2));*/


    }

    public static int strStr(String haystack, String needle) {


        if (needle.length() == 0) {
            return 0;
        }


        int[] next = new int[needle.length()];
        //调用getnext函数，用于制作前缀表
        getNext(next, needle);

        //因为 next 数组里记录的起始位置为-1
        int j = -1;
        //注意i就从0开始
        for (int i = 0; i < haystack.length(); i++) {

            //如果 haystack 的字符和 needle 的字符不匹配的话
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                // j 寻找之前匹配的位置
                j = next[j];
            }

            //匹配，j和i同时向后移动
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                //i的增加在for循环中
                j++;
            }
            //文本串s里出现了模式串t
            if (j == needle.length() - 1) {
                return (i - needle.length() + 1);
            }


        }
        return -1;

    }

    /**
     * 构造next数组，定义一个getNext来构建next数组
     * 计算前缀表的值。
     * <p>
     * 构造next数组主要有以下三步：
     * (1)初始化
     * (2) 处理前后缀不相同的情况
     * (3)处理前后缀相同的情况
     *
     * @param next
     * @param s
     */
    public static void getNext(int[] next, String s) {

        //（1）初始化前缀表。j初始化为-1表示减一，前缀表有多种操作（不变，右移，减1）
        int j = -1;
        //next[i] 表示 i（包括i）之前最长相等的前后缀长度（其实就是j），所以初始化为next[0] = j
        next[0] = j;

        for (int i = 1; i < s.length(); i++) {
            //（2）处理前后缀不相同的情况
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {

                //向前回退
                j = next[j];
            }
            //（3）当前后缀相同的情况
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }

            // 将j（前缀的长度）赋给next[i]
            next[i] = j;

        }

    }

    /**
     * 把haystack中看成一个大的移动窗口，长度为needle.length() 的长度，在 haystack中移动并且遍历，可以判断其移动过程中
     * 和needle的元素是否相等。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr1(String haystack, String needle) {


        // 首先判断 needle是否存在
        if (needle.length() == 0) {
            return 0;
        }

        //使用 for循环遍历原字符串haystack的每一个可能的起始位置。haystack.length() - needle.length() + 1 为滑动窗口可以移动的位置
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            //判断 haystack 移动窗口中，首元素是否和needle相等。相等则继续移动滑动窗口
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 1;

                //判断 haystack 的第二位元素和needle中的第二位元素是否相等，相等则元素继续往下判断
                while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                    j++;
                }
                //最后判断j是否和needle长度相等，相等则表示 元素相同。
                if (j == needle.length()) {
                    return i;
                }
            }
        }

        return -1;
    }


}
