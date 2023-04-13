package com.company.character_String;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 注：题目的意思其实概括为 每隔2k个反转前k个，尾数不够k个时候全部反转
 * <p>
 * 示例：
 * 输入：s = "abcdefg", k =2
 * 输出: "bacdfeg"
 */


public class reverseStr2 {


    public static void main(String[] args) {

        String s1 = "abcdefg";
        String s2 = "abcd";
        int k = 2;
        //System.out.println(reverseStr1(s1, k));
        System.out.println(reverseStr2(s1, k));

    }

    /**
     * 反转字符串
     * 使用和上一次相同的解法，不过循环的条件变了，变成 start 和 end
     *
     * @param s
     * @param k
     * @return
     */

    public static String reverseStr1(String s, int k) {


        //将字符串转换为数组，这样问题就变回原来的第一种转换字符串的题目
        char[] charArr = s.toCharArray();

        for (int i = 0; i < charArr.length; i += 2 * k) {

            //设置一个 循环的开始
            int start = i;

            //设置一个循环的结束,min函数的目的是判断尾数够不够k个来取决 end指针的位置
            int end = Math.min(charArr.length - 1, start + k - 1);


            while (start < end) {

                //交换字符串
                char temp = charArr[start];
                charArr[start] = charArr[end];
                charArr[end] = temp;

                start++;
                end--;

            }


        }

        return new String(charArr);

    }


    /**
     * 使用构造翻转函数的解法
     *
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr2(String s, int k) {

        //初始化一个函数用来存储
        char[] charArr = s.toCharArray();
        //1.每隔2k个字符的前k个字符进行反转
        for (int i = 0; i < charArr.length; i += 2 * k) {

            //2.剩余字符小于 2k 但大于或等于k个，则反转前k个字符
            if (i + k <= charArr.length) {

                reverse(i, i + k - 1, charArr);
                //执行完continue直接下一个循环，不执行后面的语句
                continue;
            }
            //3.否则，剩余字符少于k个，则将剩余字符全部反转
            reverse(i, charArr.length - 1, charArr);

        }

        return new String(charArr);

    }


    /**
     * 定义反转函数，由上面直接调用
     *
     * @param i
     * @param j
     * @param chars
     */
    public static void reverse(int i, int j, char[] chars) {


        while (i < j) {

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;

            i++;
            j--;

        }


    }


}
