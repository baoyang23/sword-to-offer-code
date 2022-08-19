package com.iyang.learnpointcode.nodes;

/***
 * @author: baoyang
 * @data: 2022/7/7
 * @desc:
 ***/
public class RotateListNode {

    public static void main(String[] args) {

    }


    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        ListNode cur = head;
        int len = 0;
        while (cur != null){
            len ++;
            cur = cur.next;
        }
        // 简化k
        k %= len;
        if(k == 0){
            return head;
        }
        ListNode fast = head;
        while (k > 0){
            fast = fast.next;
            k --;
        }
        // 快慢指针一起走,
        ListNode slow = head;
        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        //  快慢执政走完,走到该走的节点后,进行节点的断开
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }

}
