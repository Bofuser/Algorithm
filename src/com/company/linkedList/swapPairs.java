package com.company.linkedList;


/**
 * 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 如输入：head = [1,2,3,4]
 * 输出: [2,1,4,3]
 *
 *
 *
 */

public class swapPairs {

    public ListNode swapPairs(ListNode head){

        //初始化 一个虚拟头节点
        ListNode dumyhead = new ListNode(-1);
        //将虚拟头节点指向head
        dumyhead.next = head;
        ListNode cur = dumyhead;
        ListNode firstNode = cur.next;
        ListNode secondNode = cur.next.next;
        //设置一个临时节点, 将第三个节点存储到临时节点中。
        ListNode temp = cur.next.next.next;;

        while(cur.next != null && cur.next.next != null){

            //步骤一 : 虚拟头节点指向第二个节点
            cur.next = secondNode;
            //步骤二：第二个节点指向第一个节点
            secondNode.next = firstNode;
            //步骤三：一节点指向第三个节点
            firstNode.next = temp;

        }

        return dumyhead;

    }


}
