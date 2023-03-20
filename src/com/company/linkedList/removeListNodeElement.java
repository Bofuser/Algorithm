package com.company.linkedList;


/**
 * 题意：删除链表中等于给定值 val 的所有节点。
 *
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 *
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 *
 *
 *
 */



public class removeListNodeElement {


    public static void main(String[] args) {

        int [] values = {1, 2, 3, 4, 5, 6};

        //创建头节点
        ListNode head = new ListNode(0);
        ListNode curr = head;

        //遍历数组，将创建的节点连接起来
        for(int val : values){
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        //移除头节点
        head = head.next;
        //System.out.println(curr);
       System.out.println(removeListNodeElement1(curr,6));

    }


    /**
     * 使用虚拟头节点的方法解题。解该题时需要注意判断头节点head和head->是否为空才能进一步判断
     *
     * 注意事项：
     * （1）首先要判断头节点不能为空，然后再进行以下判断
     * （2）定义虚拟节点dummy后，需要有个初始化指针pre指向它才能用。
     * （3）同时分不同情况判断，当要删除头节点的时候和不删除时。
     * （4）最后返回的是dummy.next而不是head，因为删除了头节点可能影响了head的内容。
     *
     * @return
     */
    public static ListNode removeListNodeElement1(ListNode head, int val){

        //判断head节点不为空节点
        if(head == null){
            return head;
        }


        //创建一个虚拟节点
        ListNode dummy = new ListNode(-1,head);
        //初始化‘pre’指针，指向链表的虚拟节点dummy
        ListNode pre = dummy;
        //定义一个临时节点cur
        ListNode cur = head;


        //当cur节点不为空时
        while(cur != null){

            //判断，这是要删除头节点
            if(cur.val == val){
                pre.next = cur.next;
            }else {     //否则将虚拟节点等于头节点

                pre = cur;

            }
            //删除其他节点
            cur = cur.next;

        }

        //返回虚拟节点的下一位。因为这样才能避免出现意外情况，防止头节点被删除后没有了，虚拟节点的下一位才是我们所需要的链表
        return dummy.next;

    }


    /**
     * 使用的是非“虚拟节点创建的方法”
     *
     * 分两个循环判断，一个为头节点判断，另一个为其他节点判断。
     * 头节点判断时要注意判别头节点  head != null;
     * 其他节点判断时，要注意判断其他节点也不能为空 cur.next != null;
     *
     *
     * @param head
     * @param val
     * @return
     */

    public static ListNode removeListNodeElement2(ListNode head, int val){

        //(1)判断是否删除头节点
        while(head != null && head.val == val){

            head = head.next;
        }

        //（2）判断删除其他节点

        ListNode cur = head;
        while(cur != null ){

            //判断节点是否是我们要删除的节点（非头节点）如果是则跳到下一个节点。（这里使用的是cur.next表示非头节点）
            while(cur.next != null && cur.next.val == val){

                cur.next = cur.next.next;

            }
            //如果不是所要删除的节点，则跳转到下一个节点。
                cur = cur.next;
        }

        return head;


    }





    /**
     * 声明一个ListNode的内部类，后面才能调用ListNode创建函数
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode head) {
            this.val = val;
            this.next = head;
        }
    }
}
