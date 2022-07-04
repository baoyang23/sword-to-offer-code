package com.iyang.learnpointcode.nodes;

public class TwoNodeSum {




    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 使用临时存储来做记录
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
                int x = l1 == null ? 0 : l1.val;
                int y = l2 == null ? 0 : l2.val;

                // carry 上一个下标的值,合起来是否大于10,如果是大于10的话，则这里会进行+1
                int sum = x + y + carry;

                carry = sum / 10;
                sum = sum % 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                if(l1 != null){
                    l1 = l1.next;
                }
                if(l2 != null){
                    l2 = l2.next;
                }
        }

        // 如果最后二个数,相加的时候有进位数的时候,就将进位数,赋予链表的新节点
        if(carry == 1){
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

}
