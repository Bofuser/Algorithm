package com.company.linkedList;

/**
 * 反转列表题
 * 题意：反转一个单链表。
 *
 * 示例: 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */

public class reverseList {

    //双指针法
    public ListNode reverseList1(ListNode head){


        //前节点
        ListNode pre = null;
        //现节点
        ListNode curr = head;
        // 临时节点
        ListNode nextTemp =null;

        while(curr != null){

            //将curr下一节点存储到临时节点中
            nextTemp = curr.next;
            //将当前节点的next指针指向前一个节点
            curr.next = pre;
            //将pre的值变为当前节点
            pre = curr;
            //将curr的值设为下一个节点
            curr = nextTemp;

        }

        return pre;

    }


    /**
     * 递归法
     *
     * 构造个reverse（ListNode pre, ListNode cur）函数，里面代码仿照双指针的写法
     *
     */

     public ListNode reverseList2(ListNode head){

         return reverse(null, head);

     }


    public ListNode reverse(ListNode pre, ListNode cur){

         //如果链表为空，则返回pre=null
         if(cur == null){
             return pre;
         }

         //将cur下一节点存储到临时变量temp中
         ListNode temp = cur.next;
         //将链表进行翻转
         pre = cur.next;
         //仿照双指针法，将节点带到下一个节点中进行循环，即进行递归
        //pre = cur;
        //cur = temp;
         return reverse(cur,temp);

    }



}
