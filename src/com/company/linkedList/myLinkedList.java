package com.company.linkedList;

/**
 * 设计链表
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 */


//单链表
public class myLinkedList {

    //size 存储链表元素的个数
    int size;
    // 虚拟头节点
    ListNode head;


    //初始化链表, 用 myLinkedList 的构造函数
    public myLinkedList(){

        //初始化 size和虚拟头节点
        size = 0;
        head = new ListNode(0);

    }

    /**
     * 获取第index个节点的数值，注意index是从0开始的，第0个节点就是头节点
     * @param index
     * @return
     */
    public int get(int index){
        //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点
        //首先判断index是否在可用区间中
        if(index < 0 || index >= size){

            return -1;

        }

        // 设置一个虚拟头节点
        ListNode currentNode = head;
        //遍历循环需要获取的节点, 因为包含一个虚拟头节点，所以查找第 index+1 个节点
        for(int i = 0; i <= index; i++){

            currentNode = currentNode.next;
        }

        //获取currentNode 的val值。
        return currentNode.val;

    }


    /**
     * 在链表头插入节点
     * 调用了index函数，当 index = 0 时表示在节点头插入节点
     * @param val
     */
    public void addAtHead(int val){
        addAtIndex(0, val);
    }


    /**
     * 在链表尾中插入节点
     * 调用index添加函数，当index = size时表示在节点尾巴插入了节点。
     *
     * @param val
     */
    public void addAtTail(int val){
        addAtIndex(size, val);
    }





    /**
     *  在index个节点之前插入一个新节点
     * @param index
     * @param val
     */
    private void addAtIndex(int index, int val) {

        //判断添加的节点是否超出范围了
        if(index > size){
            return;
        }

        if(index < 0){
            index = 0;
        }
        //size是指链表的长度，每当添加一个节点时，都需要+1，增加链表的长度
        size++;

        //找到要插入节点的前驱。
        ListNode pred = head;
        for(int i = 0; i < index; i++){

            pred = pred.next;

        }

        //初始化需要添加的节点
        ListNode toAdd = new ListNode(val);
        // 要添加的节点先指向后面，然后再用前面的节点指向。
        /**
         * 这段代码举个例子，画个图就能理清楚。
         *
         * 举个例子，如果有一个链表是1->2->3->4->5，你要在index=2处插入一个值为9的节点，那么你需要做以下操作：
         *
         * 找到index=2处的前驱节点pred，它是值为2的节点。
         * 创建一个新节点toAdd，并将其值设为9。
         * 将toAdd的next指针指向pred的next指针所指向的节点，即值为3的节点。此时，toAdd已经接在了3之前。
         * 将pred的next指针指向toAdd，此时，toAdd已经接在了2之后。
         * 最终得到一个新的链表：1->2->9->3->4->5。
         * 如果你写成toAdd.next = pred.next.next，那么相当于将toAdd接在值为4的节点之前。最终得到一个错误的结果：1->2->3->9->4->5。
         *
         */
        toAdd.next = pred.next;
        pred.next = toAdd;

    }


    /**
     * 删除节点
     * @param index
     */
    public void deleteAtIndex(int index){

        //判断index是否在查询的范围内
        //注意，"index >= size"， 如果index = size，说明要删除的是超出链表范围的下一个位置 ，这是不和法的
        if(index < 0 || index >= size){

            return;
        }

        //表示每当删除一个节点的时候，都需要减少其长度。
        size--;
        //判断当要删除第一个节点的时候
        if(index == 0){
            head = head.next;
            return;
        }

        //找到要插入节点的前驱。
        ListNode pred = head;
        //查找到要删除的节点 “pred” 的
        for(int i = 0; i < index; i++){

            pred = pred.next;
        }

        //让其指向下一个即为删除
        pred.next = pred.next.next;

    }



}




