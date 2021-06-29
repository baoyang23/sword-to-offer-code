package com.iyang.learntreecode.binary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * ( •_•)                          (•_• )
 * ( ง )ง                          ୧( ୧ )
 * /︶\                              /︶\
 *
 * @author : luohong
 * @desc :
 * @since : 2021/6/29 / 下午7:30
 * 二叉树的中讯遍历
 */

public class MidForTree {

    public static void main(String[] args) {

        MidTreeNode midTreeNode = new MidTreeNode();
        midTreeNode.val = 1;

//        MidTreeNode left1 = new MidTreeNode();
//        left1.val=2;
//        MidTreeNode left2 = new MidTreeNode();
//        left2.val = 3;
//        left1.right = left2;
//        midTreeNode.left = left1;

        MidTreeNode r1 = new MidTreeNode();
        r1.val = 2;
        midTreeNode.left = r1;



        List<Integer> numberList = new MidForTree().inorderTraversal(midTreeNode);

        System.out.println("获取出来的 numberList 值是 " + numberList);

    }

    // 中遍历
    public List<Integer> inorderTraversal(MidTreeNode root){

        List<Integer> numerList = new ArrayList<>();
        if(root == null){
            return numerList;
        }

        numerList.add(root.val);

        leftOrderVal(root,numerList);
        rightOrderVal(root,numerList);


        return numerList;
    }

    // 获取右节点.
    public void rightOrderVal(MidTreeNode root,List<Integer> listNumber){
        if(root.right != null){
            // 还有数据
            listNumber.add(root.right.val);
            rightOrderVal(root.right,listNumber);
        }
        if(root.left != null && root.left.right != null){
            listNumber.add(root.left.right.val);
            rightOrderVal(root.left.right,listNumber);
        }
    }

    // 获取左节点
    public void leftOrderVal(MidTreeNode root,List<Integer> listNumber){
        if(root.right != null && root.right.left != null){
            // 还有数据
            listNumber.add(root.right.left.val);
            leftOrderVal(root.right.left,listNumber);
        }
        if(root.left != null){
            listNumber.add(root.left.val);
            leftOrderVal(root.left,listNumber);
        }
    }


    // 使用递归来解答
    public void inOrder(MidTreeNode root,List<Integer> vals){

        if(root == null){
            return;
        }
        inOrder(root.left,vals);
        vals.add(root.val);
        inOrder(root.right,vals);

    }

    public List<Integer> inorderTraversalTwo(MidTreeNode midTreeNode){

        List<Integer> vals = new ArrayList<>();
        MidTreeNode predecessor = null;

        if(midTreeNode.left != null){
            while (midTreeNode != null) {

                predecessor = midTreeNode.left;
                if(predecessor.right != null && predecessor.right != midTreeNode){

                    predecessor = midTreeNode.right;
                }

                if(predecessor.right == null){
                    predecessor.right  = midTreeNode;
                    midTreeNode = midTreeNode.left;
                } else {
                    vals.add(midTreeNode.val);
                    predecessor.right = null;
                    midTreeNode = midTreeNode.right;
                }

            }
        } else {
            vals.add(midTreeNode.val);
            midTreeNode = midTreeNode.right;
        }

        return vals;
    }

}
