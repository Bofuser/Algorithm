package com.company.character_String;

/**
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，
 * 单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * 示例：
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 */

public class reverseWords {


    public static void main(String[] args) {

        String a = "the sky is blue";
        String b = "  hello world  ";
        String c = "a good   example";
        System.out.println(reverseWords(a));
        System.out.println(reverseWords(b));
        System.out.println(reverseWords(c));


    }

    /**
     * 解题思路：
     * 题目有两个要求，①对字符串中单词的顺序进行反转。②反转后字符串前面和最后不能存在空格，单词中间有多余的空格减少到最后1个
     * 故解题思路有：
     * （1）移除多余的空格（使用移除数组元素的方法）
     * （2）将整个字符串进行反转（使用反转字符串1的方法）
     * （3）将每个单词进行反转（使用反转字符串2的方法）
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {

        //(1)移除多余的字符串，使用快慢指针法，slow为慢指针，i 为快指针

        char[] charArr = s.toCharArray();
        char[] newChar = replaceExtraSpace(charArr);

        //(2) 将整个字符进行反转
        reverse(newChar, 0, newChar.length - 1);

        //(3)翻转单词
        reverseWo(newChar);

        return new String(newChar);


    }


    //(1)移除多余的字符串
    public static char[] replaceExtraSpace(char[] chars) {

        //初始化一个慢指针
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {

            //遇到非空格就处理
            if (chars[fast] != ' ') {
                //当slow不等于零时，表明指针不是从头开始，而是在单词中间遍历，所以在slow之后添加空格
                if (slow != 0) {
                    chars[slow++] = ' ';
                }
                //删除空格元素
                while (fast < chars.length && chars[fast] != ' ') {

                    //将快指针遍历得到的东西传到慢指针中
                    chars[slow++] = chars[fast++];
                }
            }

        }

        //创建一个新的字符串数组，将字符串数组存储到新的数组中并赋值
        char[] newChar = new char[slow]; //slow 为清除空格后的数组长度
        //System.arrycop()函数是将一个数组复制给另一个数组。
        System.arraycopy(chars, 0, newChar, 0, slow);

        return newChar;

    }

    //(2) 将整个字符进行反转
    public static void reverse(char[] chars, int start, int end) {

        if (end >= chars.length) {
            System.out.println("set a wrong end.");
            return;
        }

        while (start < end) {

            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;

        }

    }

    //（3）将每个单词进行反转
    public static void reverseWo(char[] chars) {

        //设置翻转单词的开始
        int start = 0;
        for (int end = 0; end <= chars.length; end++) {
            // end 每次到单词末尾后的空格或串尾,开始反转单词
            if (end == chars.length || chars[end] == ' ') {
                //当end为空时，开始翻转
                reverse(chars, start, end - 1);
                //重新设置start位置，为end在空格时的下标+1，然后重新翻转
                start = end + 1;
            }

        }
    }

}
