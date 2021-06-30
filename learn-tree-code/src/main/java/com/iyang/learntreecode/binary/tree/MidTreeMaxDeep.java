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
 * @since : 2021/6/30 / 下午11:19
 */
public class MidTreeMaxDeep {

    public static void main(String[] args) {

        new MidTreeMaxDeep().maxDeep();

    }


    public void maxDeep(){

        List<Integer> deepList = new ArrayList<>();

        MidTreeNode one = new MidTreeNode();
        one.val = 3;

        MidTreeNode two = new MidTreeNode();
        two.val = 20;

        MidTreeNode three = new MidTreeNode();
        three.val = 15;

        two.left = three;
        one.left = two;

        // maxDeepByTree(deepList,one);
        int deep = maxDeepByTree(one);


        System.out.println("树的深度是 : " + deep);

    }


    public int maxDeepByTree(MidTreeNode midTreeNode){


        if(midTreeNode == null) {
            return 0;
        } else {

            // 按照层级返回操作,最底下一层是 0 , 依次往上追加一.
            int leftHeight = maxDeepByTree(midTreeNode.left);
            int rightHeight = maxDeepByTree(midTreeNode.right);

            return Math.max(leftHeight,rightHeight) + 1;
        }


    }



}
