package com.iyang.leet.daily.exercise;

public class FindMaxConsecutiveOnes {


    public static void main(String[] args) {

        int hd = new FindMaxConsecutiveOnes().hd();
        System.out.println(hd);

    }

    // 滑动窗口解法
    public int hd(){

        int[] nums = { 1,1,0,1,1,1 };
        int length = nums.length;
        int right = 0;
        int left = 0;
        int maxSize = 0;

        while (right < length){
            // 如果是 1 的话, 就相当于没有走 循环的逻辑
            if(nums[right++] == 0){
                // 走完上面的 if , 也就是 right 是加完 1 的赋值
                maxSize = Math.max(maxSize , right - left -1);
                left = right;
            }
        }
        return Math.max(maxSize, right - left);
    }


    /**
     * 常见思路, 线性遍历来依次记录
     * @return
     */
    public int commonSolution(){

        int[] nums = { 1,1,0,1,1,1 };
        int max = 0;
        int recordMax = 0;
        for (int num : nums) {
            if (num != 0) {
                recordMax ++;
            } else {
                max = Math.max(max, recordMax);
                recordMax = 0;
            }
        }
        max = Math.max(max, recordMax);
        return max;
    }

}
