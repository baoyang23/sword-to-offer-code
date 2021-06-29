package com.iyang.learntreecode.binary.tree;

/**
 * ( •_•)                          (•_• )
 * ( ง )ง                          ୧( ୧ )
 * /︶\                              /︶\
 *
 * @author : luohong
 * @desc :
 * @since : 2021/6/29 / 下午7:30
 * 二叉树的类
 */
public class MidTreeNode {

    int val;
    MidTreeNode left = null;
    MidTreeNode right = null;

    public MidTreeNode(){}

    public MidTreeNode(int val) {
        this.val = val;
    }

    public MidTreeNode(MidTreeNode left, MidTreeNode right) {
        this.left = left;
        this.right = right;
    }

    public MidTreeNode(int val, MidTreeNode left, MidTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
