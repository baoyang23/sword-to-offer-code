package com.iyang.learntreecode.binary.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ( •_•)                          (•_• )
 * ( ง )ง                          ୧( ୧ )
 * /︶\                              /︶\
 *
 * @author : luohong
 * @desc :
 * @since : 2021/6/29 / 下午10:37
 * 判断二个树是否相同
 */
public class SameTree {

    public static void main(String[] args) {

        MidTreeNode one = new MidTreeNode();
        one.val = 1;

        MidTreeNode two = new MidTreeNode();
        two.val = 2;
        one.right = two;

        MidTreeNode three = new MidTreeNode();
        three.val = 3;
        one.left = three;

        MidTreeNode one1 = new MidTreeNode();
        one1.val = 1;
        one1.left = three;
        one1.right = two;

        new SameTree().isSameTre(one,one1);
    }

    // 利用每次遍历来进行判断 节点的值是否相同.
    public boolean isSameTreeByEqual(MidTreeNode p,MidTreeNode q){

        if(p == null && p == null){
            return true;
        } else if (p == null || q == null){
            return false;
        } else if(p.val != q.val){
            return false;
        } else {
            return isSameTreeByEqual(p.left,q.left) && isSameTreeByEqual(p.right,q.right);
        }
    }


    // 判断二个树是否相同 : 广度优先.
    public boolean isSameTreeByBreadth(MidTreeNode p,MidTreeNode q){

        if(p == null && q == null){
            return true;
        } else if(p == null || q ==null){
            return false;
        }

        Queue<MidTreeNode> queue1 = new LinkedList<>();
        Queue<MidTreeNode> queue2 = new LinkedList<>();

        queue1.offer(p);
        queue2.offer(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            MidTreeNode node1 = queue1.poll();
            MidTreeNode node2 = queue2.poll();
            if(node1.val != node2.val){
                return false;
            }
            MidTreeNode left1 = node1.left , right1 = node1.right , left2 = node2.left , right2 = node2.right;
            if(left1 == null ^ left2 == null){
                return false;
            }
            if(right1 ==null ^ right2 == null){
                return false;
            }
            if(left1 != null){
                queue1.offer(left1);
            }
            if(right1 != null){
                queue1.offer(right1);
            }
            if(left2 != null){
                queue2.offer(left2);
            }
            if(right2 != null){
                queue2.add(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public void isSameTre(MidTreeNode p,MidTreeNode q){

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        recursiveTree(p,sb1);
        recursiveTree(q,sb2);

        boolean isTrue = sb1.toString().equals(sb2.toString());

        System.out.println("二个节点是否相同 : ---> " + isTrue);
    }


    public void recursiveTree(MidTreeNode p,StringBuffer sb){

        if(p == null){
            sb.append("0");
            return;
        }

        recursiveTree(p.left,sb);
        sb.append(p.val);
        recursiveTree(p.right,sb);

    }


}
