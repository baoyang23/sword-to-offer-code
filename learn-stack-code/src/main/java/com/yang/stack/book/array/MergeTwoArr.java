package com.yang.stack.book.array;

import java.util.Arrays;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-1
 *
 *  Author          : Gavin
 *
 *  Purpose         :  合并二个数组  leetCode #88
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class MergeTwoArr {

    public static void main(String[] args) {

        int [] num1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int [] nums2 = new int[]{2,5,6};
        int n = 3;

        // 将nums2赋值到num1,从num2的下标为0开始, 到m结束, num1就是从下标n开始接受num1赋值的
        System.arraycopy(nums2,0,num1,n,m);
        Arrays.sort(num1);
        System.out.println(Arrays.toString(num1));
        System.out.println(" ---------------------------");

        merge(num1,m,nums2,n);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // [1, 2, 2, 2, 5, 6]
        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        System.out.println(Arrays.toString(nums1));
    }


}
