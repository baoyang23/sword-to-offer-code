package com.iyang.learnpointcode.nodes;

public class TwoNextNodeReplace {

    public static void main(String[] args) {


    }


    public ListNode swapPairs(ListNode head) {
        // 剩下来的只有一个,无需进行
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }


    public ListNode swapPairsWhile(ListNode head){
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        ListNode temp = listNode;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;

            // end替换到next上来
            temp.next = end;
            // 将 end的next指向,给指向到start的next
            start.next = end.next;
            // end 的 next 指向start来进行替换
            end.next = start;

            // 重制temp,因为start已经替换到end最原始的节点上了
            temp = start;
        }

        return listNode.next;
    }

}
