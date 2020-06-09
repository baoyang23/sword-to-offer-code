package com.iyang.learndynamicprogrammingcode.array;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-9
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class NumArray {

    private int [] sums;

    /** [-2, 0, 3, -5, 2, -1]
     *  sums填充一位,其实每位的就是前面的之前,所以在 i 到 j 之间的差距范围,就可以感觉 j+1 - i 来实现.
     *
     * */
    public NumArray(int [] nums){
        sums = new int[nums.length + 1];
        for(int i=0,j=nums.length;i<j;i++){
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i,int j){
        return sums[j + 1] - sums[i];
    }

}
