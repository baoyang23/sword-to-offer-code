package com.iyang.learnpointcode.nodes;

/***
 * @author: baoyang
 * @data: 2022/8/20
 * @desc: 合并两个有序链表
 ***/

public class MergeTwoLists {

    public static void main(String[] args) {

    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }

}
