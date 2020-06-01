package com.yang.stack.book.array;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-1
 *
 *  Author          : Gavin
 *
 *  Purpose         :  最长连续递增序列  leetcode: #674
 *
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class FindLengthOfLCIS {


    public static void main(String[] args) {

        int [] nums = new int[]{1,3,5,4,7,9,11,12};

        // 这个参数对应是记录出i的值,也就是一种类似于滑动的效果.
        int midNum = 0;
        // 该值每次记录的是连续最大的
        int ans = 0;
        for(int i=0;i<nums.length;++i){
            if(i > 0 && nums[i-1] > nums[i]){ midNum = i; }
            ans = Math.max(ans,i+1-midNum);
        }

        System.out.println(ans);
    }

}
