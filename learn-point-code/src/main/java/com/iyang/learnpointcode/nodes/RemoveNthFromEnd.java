package com.iyang.learnpointcode.nodes;

public class RemoveNthFromEnd {

    public static void main(String[] args) {


    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode index1 = head;
        ListNode index2 = head;
        // for 循环到节点之间的差距,这样剩下来,只需要处理到 index2节点是null的话,就说明双指针是满足条件的
        for (int i = 0; i < n; i++) {
            index2 = index2.next;
        }
        if(index2 == null){
            return head.next;
        }
        while (index2.next != null) {
            index2 = index2.next;
            index1 = index1.next;
        }
        // 重置需要替换的
        index1.next = index1.next.next;
        return head;
    }

}
