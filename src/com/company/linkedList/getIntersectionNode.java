package com.company.linkedList;

/**
 * 求链表相交
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 举例一
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'（最终输出间隔8）
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 */


public class getIntersectionNode {

    /**
     * 解题思路：
     * 使用双指针法，分别初始化一个指针PA和指针PB。对链表headA和链表headB进行循环遍历，
     * 当链表headA循环遍历结束后，重定向到遍历链表B，遍历链表B。同理，B链表也是如此遍历。
     * 最后当PA和PB相遇时，则他们所指向的节点就是两个链表相交的起始节点。
     * <p>
     * 举个例子，如果A、B链表有相交的节点时，其呈现出Y型的结构的（如例子所举的）。假设 A链表的长度为 a ，B链表的长度为b，
     * 他两相交的节点长度为c。当遍历完成后，A链表和B链表同时开始遍历，所走的节点长度分别为：a+c+b 和 b+c+a。
     * 由于 Y形结构的长度是固定的，两指针又是同时开始，步速一致，若存在重合节点，两者最终一定可以这个节点会和。
     * 例子listA = [4,1,8,4,5], listB = [5,0,1,8,4,5] 相交节点为8
     *
     * @param headA
     * @param headB
     * @return
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //1.判断链表不能为空。即当链表headA和链表headB有一个为空时，即没有交点，就返回null。
        if (headA == null || headB == null) {
            return null;
        }

        //2.初始化两个指针，分别指向链表A和链表B的头节点。
        ListNode PA = headA;
        ListNode PB = headB;

        //当PA遍历到末尾null时，将它重定向到链表B的头节点；同理，如果PB到达链表B的末尾，将它重定向到链表A的头节点。
        while (PA != PB) {

            PA = (PA == null) ? headB : PA.next;
            PB = (PB == null) ? headA : PB.next;
        }
        // 当PA和PB相遇时，返回他们所指向的重合节点。
        return PA;
    }


}
