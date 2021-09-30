package com.iyang.learn.dynamic.planning.medium;

/***
 * @author: luohong
 * @package: com.iyang.learn.dynamic.planning.medium
 * @date: 2021/9/30
 * @project: learn-dynamic-programming-code
 * @desc: leetcode11: 盛最大容器的水
 */

public class MaxVesselWater11 {

    public static void main(String[] args) {

        int [] nums = { 1,8,6,2,5,4,8,3,7 };
        // int [] nums = {  1, 1};
        // int [] nums = { 4,3,2,1,4 };
        // int [] nums = { 1, 2, 1 };
        // int maxArea = maxArea(nums);
        int maxArea = twoPointFun(nums);

        System.out.println("获取出来最大值是 ---> " + maxArea);
    }

    /**
     * 双指针法.
     * @param height
     * @return
     */
    public static int twoPointFun(int[] height){

        int startIndex = 0;
        int endIndex = height.length - 1;
        int maxResult = 0;
        while (endIndex > startIndex){
            int startVal =  height[startIndex];
            int endVal = height[endIndex];
            int claVal = 0;
            if(startVal > endVal){
                claVal = endVal * (endIndex - startIndex);
                endIndex -- ;
            } else {
                claVal = startVal * (endIndex - startIndex);
                startIndex ++;
            }
            maxResult  = maxResult > claVal ? maxResult : claVal;
        }

        return maxResult;
    }

    /**
     * 暴力破解法,将所有可能的进行穷举出来,每次只记录最大值的那个.
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {

        int maxVal = 0;
        for(int i= 0; i < height.length; i ++){
            for(int j = i ; j < height.length ; j++){

                int iVal = height[i];
                int jVal = height[j];
                int result = maxVal;
                int removeIndex = j - i;
                if(jVal > iVal){
                    result = iVal * removeIndex;
                } else {
                    result = jVal * removeIndex;
                }
                maxVal = maxVal > result ? maxVal : result;
            }

        }

        return maxVal;
    }

}
