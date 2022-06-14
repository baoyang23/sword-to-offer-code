package com.iyang.learn.dynamic.planning.simple;

/****
 * @author: Yang_Bao
 * @time: 2022/6/14 / 11:26
 * @desc:
 **/


public class ClimbStairsProblem {

    public static void main(String[] args) {

        System.out.println(new ClimbStairsProblem().climbStairs(1));
    }

    public int climbStairs(int n) {

        if(n <= 2){
            return n;
        }
        int [] recordNums = new int[n];
        recordNums[0] = 1;
        recordNums[1] = 2;
        for(int i=3;i<=n;i++){
            recordNums[i-1] = recordNums[i-2] + recordNums[i-3];
        }

        return recordNums[n-1];
    }

}
