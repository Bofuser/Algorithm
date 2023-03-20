package com.company.linkedList;


/**
 *
 *  链表的定义，初始化单链表
 *
 */

public class ListNode {


    //结点的值
    int val;

    //下一个节点
    ListNode next;

    //节点的构造参数 （无参）
    public ListNode(){
        this.val = val;
    }

    //节点的构造参数（有一个参数）
    public ListNode(int val){
        this.val = val;
    }

    //节点的构造参数（有两个参数）
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }



}
