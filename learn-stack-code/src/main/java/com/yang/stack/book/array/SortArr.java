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
 *  Purpose         :  	高度检查器.  leetcode : #1051
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/


public class SortArr {

    public static void main(String[] args) {

        int [] heights = new int []{1,1,4,2,1,3};

        // 因为题目定义大小不是超过101的
        int[] arr = new int[101];
        for(int hei : heights){
            arr[hei] ++;
        }

        int count = 0;

        // 迭代 arr 中的每个元素.
        for(int i=1,j=0;i<arr.length;i++){

            // 如果大于0,就说明这个位置需要进行判断的.
            while (arr[i]-- > 0){
                // heights 数组中 j++,不等于i,则count++.
                if(heights[j++] != i){ count++; }
            }

        }

        System.out.println(count);
    }

}
