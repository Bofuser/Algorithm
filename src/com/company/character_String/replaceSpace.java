package com.company.character_String;


/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */

public class replaceSpace {


    public static void main(String[] args) {

        String s = "we are happy";
        System.out.println(replaceSpace2(s));

        String a = "abc";
        

    }

    /**
     * 使用 StringBuilder类 方法来解决
     *
     * @param s
     * @return
     */
    public static String replaceSpace1(String s) {

        //首先，判断字符串是否为空
        if (s == null) {
            return null;
        }


        //初始化 StringBuilder 对象
        StringBuilder bu = new StringBuilder();


        //遍历字符，将空字符 “ ” 转换成 “%20”
        for (int i = 0; i < s.length(); i++) {

            //  charAt 为指定String 中 第 i 个字符
            if (s.charAt(i) == ' ') {

                bu.append("%20");

            } else {

                //否则，拼接原来非空格的数组
                bu.append(s.charAt(i));

            }

        }
        return bu.toString();

    }


    /**
     * 使用双指针的方法，将字符串转换成数组，并且给它多分配存储空间。
     * 需要考虑时间和空间问题：
     * 对于空间，需要对其进行扩充，将其转换成数组，然后扩充其空间
     *
     * @param s
     * @return
     */
    public static String replaceSpace2(String s) {

        if (s == null || s.length() == 0) {
            return null;
        }


        //扩充空间，使用StringBuilder，扩充后将其转换成char[]数组
        StringBuilder bu = new StringBuilder();

        //遍历字符，对大小进行扩充
        for (int i = 0; i < s.length(); i++) {

            //将空间扩充两倍
            if (s.charAt(i) == ' ') {

                //扩充多两个空格
                bu.append("  ");
            }
        }

        //若没有空格，则直接返回字符s
        if (bu.length() == 0) {
            return s;
        }

        //定义两个指针，left 和 right
        //左值针：指向原始字符串最后一个位置。从后往前遍历
        int left = s.length() - 1;

        //将多出来的空格拼接到字符 s 中
        s += bu.toString();


        //并且将字符存储到chars中
        char[] chars = s.toCharArray();
        //右指针：指向扩展字符串的最后一个位置
        int right = s.length() - 1;
        while (left >= 0) {

            //当碰到有空格字符时
            if (chars[left] == ' ') {

                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';

            } else {
                //没有空格的字符则将左值针的指存储到右指针
                chars[right] = chars[left];
            }

            left--;
            right--;

        }

        return new String(chars);

    }


}
