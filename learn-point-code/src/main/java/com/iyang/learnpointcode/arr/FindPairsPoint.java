package com.iyang.learnpointcode.arr;

import java.util.Arrays;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-13
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class FindPairsPoint {

    public static void main(String[] args) {

        int [] nums = new int[]{3, 1, 4, 1, 5};
        int k = 2;
        Arrays.sort(nums);
        int start = 0 , count = 0 , prev =  0x7fffffff;
        for(int i =1 ; i < nums.length;i++){

            if(nums[i] - nums[start] > k || prev == nums[start]){
                if ( ++ start != i){  i--; }
            } else if(nums[i] - nums[start] == k){
                prev = nums[start++];
                count ++;
            }

        }

        System.out.println(count);
    }

}
