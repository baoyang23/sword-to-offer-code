package com.iyang.learntreecode.binary.tree;


/**
 * ( •_•)                          (•_• )
 * ( ง )ง                          ୧( ୧ )
 * /︶\                              /︶\
 *
 * @author : luohong
 * @desc :
 * @since : 2021/7/1 / 下午9:33
 * @desc : 是否是平衡二叉树.
 *
 * 对左右二边对node进行迭代,获取出高度即可.
 */

public class IsBalancedTree {

    public static void main(String[] args) {

        IsBalancedTree is = new IsBalancedTree();

        MidTreeNode one = new MidTreeNode();
        one.val = 1;

        MidTreeNode two = new MidTreeNode();
        two.val = 2;

        MidTreeNode three = new MidTreeNode();
        three.val = 3;

        one.right = two;
        two.right = three;

        // one.left = two;

        System.out.println(is.isBalanced(one));
    }


    public boolean isBalanced(MidTreeNode root) {

        int left =  recursiveNode(root.right);
        int right = recursiveNode(root.left);

        return Math.abs(left-right) <= 1;

    }

    public int recursiveNode(MidTreeNode  midTreeNode){

        if(midTreeNode == null){
            return 0;
        }

        int right = recursiveNode(midTreeNode.right);
        int left = recursiveNode(midTreeNode.left);

        return Math.max(right,left) + 1;

    }


}
