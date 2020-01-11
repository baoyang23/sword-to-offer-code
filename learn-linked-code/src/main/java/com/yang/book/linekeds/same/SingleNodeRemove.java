package com.yang.book.linekeds.same;

/**
 *  在 单链表中删除 倒数第k个节点
 *
 * @Author: Mu_Yi
 * @Date: 2020/1/11 18:57
 * @Version 1.0
 * @qq: 1411091515
 */
public class SingleNodeRemove {

    public int value;
    public SingleNodeRemove next;

    public SingleNodeRemove(int value, SingleNodeRemove next) {
        this.value = value;
        this.next = next;
    }

    public SingleNodeRemove removeLastKthNode(SingleNodeRemove head,int lastKth){
        if(head == null || lastKth < 1){
            return head;
        }
        SingleNodeRemove cur = head;
        while (cur != head){
            lastKth --;
            cur = cur.next;
        }
        if(lastKth == 0){
            head = head.next;
        }
        if(lastKth < 0){
            cur = head;
            while (++lastKth != 0){
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
