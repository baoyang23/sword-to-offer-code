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
public class MinCostClimbingStairsNumber {

    public static void main(String[] args) {

        int [] ns = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        minCostClimbingStairs(ns);

    }

    public static void minCostClimbingStairs(int [] cost){

        int f1 =0 , f2 = 0 ;
        for(int i=cost.length-1;i>=0;i--){
            int f0 = cost[i] + Math.min(f1,f2);
            f2 = f1 ;
            f1 = f0;
        }

        System.out.println(Math.min(f1, f2));
    }

}
