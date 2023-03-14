package com.company;


/**
 * 题型：螺旋矩阵题目
 *
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例:
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */


public class generateMatrix {


    public static void main(String[] args) {

        int n = 3;
        System.out.println(generateMatrix(n));

    }


    /**
     *假设这个是一个数组，startX为1->11的纵向坐标，startY是1->4的横向坐标
     *          1   2   3  4
     *          5   6   7  8
     *          9  10  11 12
     *          13 14  15 16
     *
     *模拟顺时针画矩阵的过程:
     *
     * 填充上行从左到右
     * 填充右列从上到下
     * 填充下行从右到左
     * 填充左列从下到上
     *
     *遵循循环不变量原则，且循环范围为左闭右开[左，右)型，四个角的节点（1，4，11，14）为起始点（或终点）
     *
     *
     * @param n
     * @return res
     */

    public static int[][] generateMatrix (int n){

        //startX为1->11的纵向坐标，startY是1->4的横向坐标
        int startX = 0;
        int startY = 0;

        //初始化一个n x n数组
        int [][] res = new int [n][n];
        //offerSet用来控制循环遍历的长度，用n-offerSet来控制循环的大小
        int offSet = 1;
        //count 为初始值，用来填充空数组的
        int count = 1;

        //loop表示数组循环顺时针循环多少次, 控制循环次数。当值为3/2=1.5（带有小数点时，）都向左取值。
        int loop = 0;

        // 矩阵中间的位置，例如：n为3， 中间的位置就是(1，1)，n为5，中间位置为(2, 2)
        int mid = n/2;


        while(loop++ < n/2) {

            int i = startX;
            int j = startY;

            //用i表示startX的循环路径，j表示startY的循环路径
            //填充上行从左到右那边, startX 不变， startY变化
            for (j = startY; j < n - offSet; j++) {

                //count++ 表示每填充一个数组位，则数值增加一位。
                res[startX][j] = count++;
            }

            //填充右列从上到下，startX 变化， startY不变
            for (i = startX; i < n - offSet; i++) {

                //j为变化后的数组坐标位置，不能用startY,其为0
                res[i][j] = count++;
            }

            //填充下行从右到左， startX 不变， startY变化
            for (;j > startY; j--){

                res[i][j] = count++;
            }

            //填充左列从下到上, startX 变化， startY不变
            for (; i > startX; i--){
                res[i][j] = count++;
            }

            //遍历循环第一圈后，开始循环第二圈,（1）节点启示位置需要变化 startX和startY，（2）每条边的循环长度也要变化 offSet
            //offSet 加一缩短循环位置
            offSet++;

            //startX和startY也加一
            startX++;
            startY++;

        }

        // 如果n为奇数的话，需要单独给矩阵最中间的位置赋值
        if (n % 2 == 1){

            res[mid][mid] = count;
        }

        return res;
    }


}
