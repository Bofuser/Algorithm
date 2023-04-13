package com.company.character_String;


/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * 示例：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 */


public class reverseString {

    public static void main(String[] args) {

        char[] arr1 = {'h', 'e', 'l', 'l', 'o'};
        reverseString1(arr1);
        System.out.println(arr1);

    }


    /**
     * 使用 交换temp方法来反转数组
     *
     * @param s
     */
    public static void reverseString1(char[] s) {


        int start = 0;
        int end = s.length - 1;

        while (start < end) {

            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;

        }

    }


}
