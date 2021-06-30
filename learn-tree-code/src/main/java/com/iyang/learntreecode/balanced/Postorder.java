package com.iyang.learntreecode.balanced;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
public class Postorder {

    public static void main(String[] args) {



    }

    /**
     * 利用栈的先进后出的特性来弹出来做题.
     * @param root
     */
    public void postOrder(ChildRenNode root){
        List<Integer> list = new ArrayList<>();
        List<ChildRenNode> curr = new ArrayList<>();

        Stack<ChildRenNode> stack1 = new Stack<>();
        Stack<ChildRenNode> stack2 = new Stack<>();

        if(root != null){

            stack1.push(root);
            while (!stack1.isEmpty()) {
                ChildRenNode temp = stack1.pop();
                stack2.push(temp);
                curr = temp.children;
            }

            for(int i =0;i<curr.size();i++){
                stack1.add(curr.get(i));
            }
        }

        while (!stack2.isEmpty()){
            ChildRenNode pop = stack2.pop();
            list.add(pop.val);
        }


        System.out.println(list);
    }

}
