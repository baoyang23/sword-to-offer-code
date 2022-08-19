package com.iyang.learnpointcode.nodes;

/***
 * @author: baoyang
 * @data: 2022/7/7
 * @desc: 删除排序链表中的重复元素
 ***/

public class DeleteRepeatNode {

    public static void main(String[] args) {


    }

    public ListNode deleteDuplicatesFor(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        // 维护一个不变的节点guard
        ListNode guard = new ListNode();
        guard.next = head;
        ListNode pre = guard;
        ListNode cur = head;
        while (cur != null) {
            // 出现重复的情况
            // 去除重复的情况
            while (cur.next != null && cur.next.val == cur.val) {
                cur = cur.next;
            }
            // 控制pre中是否重复的节点
            // 这里使用新的来进行记录
            if(pre.next == cur){
                pre = pre.next;
            } else {
                pre.next = cur.next;
                cur = cur.next;
            }

        }

        return guard.next;
    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        // 如果不等值则进行删除,如果相则进行判断
        if(head.val != head.next.val ){
            // 不相等就递归处理,处理下一个节点
            head.next = deleteDuplicates(head.next);
        } else {
            //
            ListNode temp = head.next;
            // 删除到下一个节点与该节点(temp)不相等为止.
            // 这个while秒啊,
            // 如果 head.val == head.next.val , 说明头节点的值等于下一个节点值,
            // 所以当前节点需要删除,并且后面与 head.val 相等的节点值也都需要删除,删除到下一个与当前节点值不相等为止.
            while (temp != null && head.val == temp.val ){
                // 相等就从下一个节点开始
                temp = temp.next;
            }
            return deleteDuplicates(temp);
        }

        return head;
    }

}
