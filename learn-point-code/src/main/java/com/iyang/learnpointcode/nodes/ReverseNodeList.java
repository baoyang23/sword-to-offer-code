package com.iyang.learnpointcode.nodes;

/***
 * @author: baoyang
 * @data: 2022/8/21
 * @desc:
 ***/
public class ReverseNodeList {

    public ListNode reverseList(ListNode head) {

        // 终止递归的条件
        if(head == null || head.next == null){
            return head;
        }

        // 1 -> 2 -> 3 -> 4 -> 5
        // cur 是最后一个节点
        // 将2之后的反转了, 此时是 1 -> 2 <- 3 <- 4 <- 5
        // 这时候只需要将 1 和 5 进行调换
        ListNode cur = reverseList(head.next);
        // cur是5的话,head就是4.
        // head.next.next 就是 5 的下一个,也就是4
        // 可以理解成1的下一个的下一个再指向1，也就是2->1，然后再断开原来1和2之间的线
        // 精华:  1和2之间的反转,然后再返回5就是整个操作了
        //
        head.next.next = head;
        // 防止循环链表,需要将 head.next 设置为 null
        head.next = null;
        //
        return cur;
    }

}
