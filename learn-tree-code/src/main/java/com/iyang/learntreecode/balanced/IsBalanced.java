package com.iyang.learntreecode.balanced;

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
 *</PRE>
 ***************************************************************************/
public class IsBalanced {

    public static void main(String[] args) {


    }


    public boolean isBalanced(IsTreeNode treeNode){

        if(treeNode == null){
            System.out.println("treeNode is null");
        }

        /**  获取出左右子树的深度. */
        int deptLeft = getDept(treeNode.left,0);
        int deptRight = getDept(treeNode.right,0);

        // 相差大于1的话,就不是平衡树.
        if(Math.abs(deptLeft - deptRight) > 1){
            System.out.println("相差的差距是大于1的");
        }

        // 递归检查左右子数结点信息
        return isBalanced(treeNode.left) && isBalanced(treeNode.right);
    }

    /**
     *  获取从某个结点开始的深度.
     * @param root
     * @param dept
     * @return
     */
    public int getDept(IsTreeNode root,int dept){
        if(root == null){
            return dept;
        }

        int deptLeft = getDept(root.left,dept+1);
        int deptRight = getDept(root.right,dept+1);

        return Math.max(deptLeft,deptRight);
    }


}
