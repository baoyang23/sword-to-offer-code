package com.yang.book.linekeds.same;

/**
 * @Author: Mu_Yi
 * @Date: 2020/1/7 23:49
 * @Version 1.0
 * @qq: 1411091515
 */
public class SomeNode {

    public int value;
    public SomeNode next;

    public SomeNode(int data){
        this.value = data;
    }

    public void printCommonPart(SomeNode head1,SomeNode head2){
        while (head1 != null && head2 != null) {
            if(head1.value > head2.value){
                head1 = head1.next;
            } else if (head1.value > head2.value){
                head2 = head2.next;
            } else {

                System.out.println(head1.value + "  ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }
}
