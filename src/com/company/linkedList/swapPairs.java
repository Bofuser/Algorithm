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

    /**
     *
     * 使用虚拟头指针方法
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head){

        //初始化 一个虚拟头节点
        ListNode dumyhead = new ListNode(-1);
        //将虚拟头节点指向head
        dumyhead.next = head;
        ListNode cur = dumyhead;
        ListNode firstNode = cur.next;
        ListNode secondNode = cur.next.next;
        //设置一个临时节点, 将第三个节点存储到临时节点中。
        ListNode temp = cur.next.next.next;

        while(cur.next != null && cur.next.next != null){


            firstNode = cur.next;
            secondNode = cur.next.next;
            //设置一个临时节点, 将第三个节点存储到临时节点中。
            temp = cur.next.next.next;


            //步骤一 : 虚拟头节点指向第二个节点
            cur.next = secondNode;
            //步骤二：第二个节点指向第一个节点
            secondNode.next = firstNode;
            //步骤三：一节点指向第三个节点
            firstNode.next = temp;
            //cur进行移动，准备下一轮交换
            cur = firstNode;

        }

        return dumyhead.next;

    }


    /**
     * 使用递归的方法解题
     * @param head
     * @return
     */
    //1.定义函数
    public ListNode swapPairs2(ListNode head){

        //3.终止条件.递归循环条件，判断其等于null时跳出递归
        if(head == null && head.next == null){
            return head;
        }

        //2.等价条件
        //设置next为节点2
        ListNode next = head.next;
        //进行递归（还是没懂）将 head 的下一个节点设置为递归调用 swapPairs(next.next) 的结果。这样，我们就可以递归地交换剩余的节点。
        head.next = swapPairs2(next.next);
        //将第三个节点设为头节点.
        next.next = head;

        return next;
    }



}
