package com.company.hash_table;


import java.util.HashMap;
import java.util.Map;

public class canConstruct {


    public static void main(String[] args) {

        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println(canConstruct2(ransomNote,magazine));


    }

    /**
     *使用哈希 map 解法
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine){

        //创建一个map表，用来存储存放magazine字符出现的次数 。key存储字符，value存储出现的次数
        Map<Character,Integer> map = new HashMap<>();

        // (1)遍历 magazine,使用str.toCharArray()函数调用字符数组，可以输出字符串的每一个字母为数组
        // 例如：String str = "hello", str.toCharArray() = ['h','e','l','l','o'];

        for(char c : magazine.toCharArray()){

            //将输出的每一个字符串传给c，判断，map 是否包含字符c，如果有包含则加一，否则不加一
            if(map.containsKey(c)){

                map.put(c,map.get(c)+1);
            }else {
                map.put(c,1);
            }

        }

        //(2) 判断ransomNote中的字符是否有在map中，有在的话就减一，不在则返回false

        for(char c : ransomNote.toCharArray()){

            //判断 c 是否在map中，有的话减 value减1
            if(map.containsKey(c)){

                //判断value值是否为0，为 0 则返回false
                if(map.get(c) == 0){
                    return false;
                }

                //ransomNote和 magazine 相似的字母时减一
                map.put(c, map.get(c) - 1);

            }else {
                return false;
            }

        }
        return true;

    }

    /**
     *  使用数组解法
     *  这道题和有效字母异位词解法一样，循环遍历出字符串，进行判断
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct2(String ransomNote, String magazine){

        //初始化一个数组,用来记录每次出现的字母次数
        int [] record = new int [26];


        //遍历 magazine，统计有出现的字符+1
        for(char c : magazine.toCharArray()){

            record[c - 'a'] += 1;

        }

        //遍历ransomNote，统计有出现的字符-1
        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -=1;
        }

        //判断，如果当 ransomNote 有 magazine 没有的字符，则record 中记录有负数
        for(int i :  record){
            if(i < 0){
                return false;
            }
        }

        return true;

    }


}
