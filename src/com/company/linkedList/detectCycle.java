package com.company.linkedList;

/**
 *
 * 题目：环形链表
 *
 *  题意： 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *  为了表示给定链表中的环，使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 *  如果 pos 是 -1，则在该链表中没有环。
 *
 *  解题思路：使用快慢指针法。
 *  定义一个快指针，一个慢指针。快指针每次走两步，慢指针每次走一步，如果有环的话，它两一定能在环中相遇。
 *  当相遇后，重新定义一个相遇节点index1，并再定义一个index2回链表头，两者开始以同样的步数（一步）开始走，
 *  直到后面相遇即为环节点的开头。（原理是一个数学原理,详细解释在笔记中）
 *
 *
 */


public class detectCycle {

    /**
     * 使用快慢指针法
     * @param head
     * @return 环节点的头节点 或 null
     */
    public ListNode detectCycle(ListNode head){

        //首先判断节点不为 null
        if(head == null || head.next == null){
            return null;
        }

        //定义快慢指针法, 两者都是分别从头节点开始
        ListNode fast = head;
        ListNode slow = head;

        //快慢指针开始走，慢指针走一步，快指针走两步
        while(fast != slow){

            fast = fast.next.next;
            slow = slow.next;

            //当快慢指针相遇时
            if(slow == fast){

                //设置相遇节点index1和新的链表头节点index2。然后两者开始重新移动（一步），直到相遇时即为换链表的头节点
                ListNode index1 = fast;
                ListNode index2 = head;

                while(index1 != index2){

                    index1 = index1.next;
                    index2 = index2.next;

                }
                //而当相遇时，返回index2 即为环形链表的头节点
                return index2;

            }

        }

        //如果没有环，则 fast != slow; 返回一个null
        return null;

    }

}
