package com.company.linkedList;


/**
 * 题目：
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 *
 * 解题思路：
 * 使用双指针法 + 虚拟头节点的方法来解题。
 * 首先定义一个虚拟头节点和 快 慢指针。 快指针先走 n 步，（n为需要删除的倒数第几个节点）
 * 然后 快慢指针同时向前走，直到走到末尾。此时，慢指针的位置就到了要删除的倒数 n 个节点的前一位。
 * 然后删除慢指针指向的下一节点，即倒数第n个节点。
 *
 *
 */

public class removeNthFromEnd {


    public ListNode removeNthFromEnd(ListNode head, int n){

        //初始化虚拟节点和 快慢指针
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;

        //初始化快慢指针
        ListNode fast = dummyhead;
        ListNode slow = dummyhead;



        //删除倒数第n个节点，fast先走第n步
        for(int i = 0; i < n; i++){

            fast = fast.next;
        }

        //然后快慢指针一起走,  直到走到最后指向 null
        while(fast.next != null){

            fast = fast.next;
            slow = slow.next;
        }

        //当快指针走到null时，慢指针在要删除的节点的前一位，则只需将慢指针的节点指向删除节点的下一节点即为删除。
        slow.next = slow.next.next;
        return dummyhead.next;


    }



}
