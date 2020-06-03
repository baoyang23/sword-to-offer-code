package com.yang.stack.book.leetcode;

import java.util.Arrays;
import java.util.Stack;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-3
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class StackFind132pattern {

    public static void main(String[] args) {

        int [] nums = {3,1,4,2};
        Stack<Integer> stack = new Stack<>();
        int [] min = new int[nums.length];
        min[0] = nums[0];
        for(int i=1,j=nums.length;i<j;i++){
            min[i] = Math.min(nums[i-1],nums[i]);
        }

        for(int j = nums.length-1;j>=0;j--){

            if(nums[j] > min[j]){
                while (!stack.isEmpty() && stack.peek() <= min[j]){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() < nums[j]){
                    System.out.println("OK");
                    break;
                }
                stack.push(nums[j]);
            }

        }

        System.out.println("false");
        System.out.println(Arrays.toString(min));
    }

}
