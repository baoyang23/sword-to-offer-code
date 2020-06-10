package com.iyang.learndynamicprogrammingcode.array;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-10
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/


public class MassageArr {

    public static void main(String[] args) {

        int [] nums = {2,1,4,5,3,1,1,3};
        int [] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],dp[1]);

        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }

        System.out.println(dp[dp.length-1]);

        System.out.println("-------------------");

        message();
    }

    public static void message(){

        int [] nums = {2,1,4,5,3,1,1,3};
        int a = 0,b=0;
        for(int i=0;i<nums.length;i++){
            int c = Math.max(b,a+nums[i]);
            a = b;
            b = c;
        }

        System.out.println(b);
    }

}
