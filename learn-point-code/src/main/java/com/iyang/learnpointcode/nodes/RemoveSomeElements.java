package com.iyang.learnpointcode.nodes;

/***
 * @author: baoyang
 * @data: 2022/8/21
 * @desc:
 ***/
public class RemoveSomeElements {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null ) {
            return head;
        }
        head.next = removeElements(head.next,val);
        if(head.val == val){
            return head.next;
        } else {
            return head;
        }

    }

}
