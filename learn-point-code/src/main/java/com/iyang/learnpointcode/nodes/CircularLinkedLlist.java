package com.iyang.learnpointcode.nodes;


import java.util.HashSet;
import java.util.Set;

/***
 * @author: baoyang
 * @data: 2022/8/14
 * @desc:  环形链表,判断是否有环
 ***/

public class CircularLinkedLlist {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head , slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                return true;
            }
        }
        return false;
    }

}
