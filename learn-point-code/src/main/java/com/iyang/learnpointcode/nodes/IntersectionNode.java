package com.iyang.learnpointcode.nodes;

/***
 * @author: baoyang
 * @data: 2022/8/14
 * @desc:  相交链表
 ***/
public class IntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA , pB = headB;
        while (pA != pB) {
            pA = pA == null ? pB : pA.next;
            pB = pB == null ? pA : pB.next;
        }
        return pA;
    }

}
