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
public class MaxProfitArray {

    public static void main(String[] args) {

        int [] nums = {7,1,5,3,6,4};
        int minNumsValue = Integer.MAX_VALUE;
        int diffValue = 0;
        for(int i=0,j=nums.length;i<j;i++){
            if(nums[i] < minNumsValue){
                minNumsValue = nums[i];
            } else if (nums[i] - minNumsValue > diffValue) {
                diffValue = nums[i] - minNumsValue;
            }
        }

        System.out.println(diffValue);
    }


}
