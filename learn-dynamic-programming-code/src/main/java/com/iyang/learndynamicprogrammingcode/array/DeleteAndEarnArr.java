package com.iyang.learndynamicprogrammingcode.array;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-12
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class DeleteAndEarnArr {

    public static void main(String[] args) {

        int [] nums = new int [] {2, 2, 3, 3, 3, 4};
        int len = nums.length;
        int max = nums[0];
        for(int i=0;i<len;++i){
            max = Math.max(max,nums[i]);
        }

        int [] all = new int[max+1];
        for(int item : nums){
            all[item] ++;
        }


        int [] dp = new int[max + 1];
        dp[1] = all[1] * 1;
        dp[2] = Math.max(dp[1],all[2] * 2);
        for(int i=2;i<=max;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + i * all[i]);
        }

        System.out.println(dp[max]);
    }

}
