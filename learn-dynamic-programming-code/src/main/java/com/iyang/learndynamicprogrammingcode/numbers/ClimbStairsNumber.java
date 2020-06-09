package com.iyang.learndynamicprogrammingcode.numbers;

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
public class ClimbStairsNumber {

    public static void main(String[] args) {

        climbStairs(6);

    }

    public static void climbStairs(int n){

        if(n == 1 || n == 2){
            System.out.println(n);
        }

        int [] nums = new int[n+1];
        nums[1] = 1;
        nums[2] = 2;
        for(int i = 3;i<=n;i++){
            nums[i] = nums[i-1] + nums[i-2];
        }

        System.out.println(nums[n]);
    }

    public static void twoPoint(int n){

        if(n == 1 || n == 2){
            System.out.println(n);
        }

        int one = 1;
        int two = 2;
        for(int i=3;i<=n;i++){
            int three = one + two;
            one = two;
            two = three;
        }

        System.out.println(two);
    }

}
