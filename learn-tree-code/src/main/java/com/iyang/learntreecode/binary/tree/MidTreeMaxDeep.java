package com.iyang.learntreecode.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        int deep = maxDeepByFor(one);


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


    /**
     * 使用迭代，对每个节点进行 offer / poll 操作.
     * @param midTreeNode
     * @return
     */
    public int maxDeepByFor(MidTreeNode midTreeNode){
        Queue<MidTreeNode> queue  = new LinkedList<>();
        queue.offer(midTreeNode);

        int deep = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0){
                MidTreeNode node = queue.poll();
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                size --;
            }

            deep ++;
        }


        System.out.println("最大深度是 ---> " + deep);
        return deep;
    }


}
