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
 * @since : 2021/6/30 / 下午10:37
 */
public class IsSymmetricTree {


    public static void main(String[] args) {

        MidTreeNode one = new MidTreeNode();
        one.val = 1;

        MidTreeNode two = new MidTreeNode();
        two.val = 2;
        MidTreeNode two2 = new MidTreeNode();
        two2.val = 2;

        MidTreeNode three = new MidTreeNode();
        three.val = 3;

        MidTreeNode four = new MidTreeNode();
        four.val = 4;

        one.left = two;
        one.right = two2;

        two.right = three;
        two.left = four;

        two2.left = three;
        two2.right = four;

        new IsSymmetricTree().isSymmetric(one);
    }


    private void isSymmetric(MidTreeNode midTreeNode){

        StringBuffer sb = new StringBuffer();
        isSymmetricTwoTree(sb,midTreeNode.right,midTreeNode.left);

        System.out.println(sb.toString().equals("") ? "是" : "不是");
    }


    private void isSymmetricTwoTree(StringBuffer sb,MidTreeNode rightTree,MidTreeNode leftTree){

        if(rightTree == null && leftTree == null){
            // 满足条件.
            return;
        } else if (rightTree == null || leftTree == null){
            // 不满足.
            sb.append("1");
            return;
        } else if(rightTree.val != leftTree.val ){
            sb.append("1");
            return;
        }

        isSymmetricTwoTree(sb,rightTree.right,leftTree.left);
        isSymmetricTwoTree(sb,rightTree.left,leftTree.right);

    }

    /**
     * 使用递归来判断 树是否为对称树.
     * @param p
     * @param q
     * @return
     */
    private boolean isCheck(MidTreeNode p,MidTreeNode q){

        if(p == null && q == null){
            return true;
        }
        if(p == null || q ==null){
            return false;
        }

        return p.val == q.val && isCheck(p.right,q.left) && isCheck(q.right,p.left);
    }

    // 使用队列, 集合 , 对此当当前节点的左右节点来进行配对.
    private boolean isCheckByFor(MidTreeNode p,MidTreeNode q){

        Queue<MidTreeNode> list = new LinkedList<>();
        list.offer(p);
        list.offer(q);

        while (!list.isEmpty()){

            p  = list.poll();
            q = list.poll();
            if(p == null && q == null){
                continue;
            }

            if((p == null || q == null) || (p.val != q.val)){
                return false;
            }

            list.offer(p.right);
            list.offer(q.left);

            list.offer(p.left);
            list.offer(q.right);

        }

        return true;
    }

}
