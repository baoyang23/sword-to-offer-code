package com.iyang.learndynamicprogrammingcode.array;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-5
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/


public class MaxSubArray {

    public static void main(String[] args) {

        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int [] backupsNums = new int[nums.length];

        backupsNums[0] = nums[0];

        int maxValue = 0;
        for(int i=1,j=nums.length-1;i<j;i++){
            int backIndexValue = backupsNums[i-1];
            if(backIndexValue < 0){
                backupsNums[i] = nums[i];
            } else {
                backupsNums[i] = backIndexValue + nums[i];
                maxValue = backupsNums[i] > maxValue ? backupsNums[i] : maxValue;
            }
        }

        System.out.println(maxValue);

        maxSubArray(nums);
    }

    public static void maxSubArray(int [] nums){
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i] += Math.max(nums[i-1],0);
            res = Math.max(res,nums[i]);
        }

        System.out.println(res);
    }

}
