package com.iyang.learntreecode.balanced;

import java.util.LinkedList;
import java.util.Queue;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-16
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *</PRE>
 ***************************************************************************/
public class IsSymmetric {

    public static void main(String[] args) {


    }

    public void isSymmetric(IsTreeNode node){


        check(node,node);

    }

    private boolean check(IsTreeNode p,IsTreeNode q){
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        // 左右对比处理.   是使用的 && 来进行同时的左右对比.
        return p.val == q.val && check(p.left,q.right) && check(p.right,q.left);
    }


    /**
     * 循环来实现迭代的逻辑
     * @param u
     * @param v
     * @return
     */
    private boolean checkByFor(IsTreeNode u,IsTreeNode v){
        Queue<IsTreeNode> q = new LinkedList<IsTreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()){
            u = q.poll();
            v = q.poll();
            if(u == null && v == null){
                continue;
            }

            if((u == null || v == null) || (u.val != v.val)){
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.left);
            q.offer(v.right);
        }

        return true;
    }

}
