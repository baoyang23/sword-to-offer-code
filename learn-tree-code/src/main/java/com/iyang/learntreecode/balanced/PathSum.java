package com.iyang.learntreecode.balanced;

import java.util.HashMap;
import java.util.Map;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-16
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *        10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 * sum : 8
 *</PRE>
 ***************************************************************************/
public class PathSum {


    public static void main(String[] args) {



    }


    public int pathNum(IsTreeNode root, int sum){

        // key 是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer,Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0,1);

        // 前缀和的递归回溯思想
        return recursionPathSum(root,prefixSumCount,sum,0);
    }

    private int recursionPathSum(IsTreeNode node,Map<Integer,Integer> prefixSumCount,int target,int currSum){
        if(node == null){
            return 0;
        }
        int res = 0;

        // 当前路径和
        currSum += node.val;

        /***
         * 回溯到之前的值.
         * eg :  10 -> 5 -> 3 -> 3
         * 这里map 存储的是, 10 15 18 21 , 每次利用  currSum - target的值就是剩余下值,比如到18的时候,18-8=10是在map中有的,所以就加一,
         * ret满足条件.
         *
         */
        res += prefixSumCount.getOrDefault(currSum-target,0);
        prefixSumCount.put(currSum,prefixSumCount.getOrDefault(currSum,0)+1);

        res += recursionPathSum(node.left,prefixSumCount,target,currSum);
        res += recursionPathSum(node.right,prefixSumCount,target,currSum);

        prefixSumCount.put(currSum,prefixSumCount.getOrDefault(currSum,0)-1);
        return res;
    }


}
