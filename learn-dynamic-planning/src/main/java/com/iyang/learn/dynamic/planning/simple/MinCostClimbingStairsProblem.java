package com.iyang.learn.dynamic.planning.simple;

/****
 * @author: Yang_Bao
 * @time: 2022/6/14 / 14:02
 * @desc:
 **/
public class MinCostClimbingStairsProblem {


    public static void main(String[] args) {
        int [] cost = { 1,100,1,1,1,100,1,1,100,1 };

        System.out.println(new MinCostClimbingStairsProblem().minCostClimbingStairs(cost));

    }

    // 1,100,1,1,1,100,1,1,100,1
    // 10,15,20
    public int minCostClimbingStairs(int[] cost){

        int [] record = new int[cost.length];
        record[0]=0;
        record[1] = Math.min(cost[0],cost[1]);
        for(int i=2;i<cost.length;i++){
            record[i] = Math.min(record[i-1] + cost[i] , cost[i-1] + record[i-2]);
        }
        return record[cost.length-1];
    }

}
