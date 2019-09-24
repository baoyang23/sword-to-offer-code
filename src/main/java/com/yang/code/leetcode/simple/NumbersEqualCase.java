package com.yang.code.leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 19-9-23
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class NumbersEqualCase {

    public static void main(String[] args) {



    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        // [-1, 0, 1, 2, -1, -4]

        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // 跳过可能重复的答案
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                // 当前 i + 1 ; 也就是 i 的后一位
                int l = i + 1;

                // 最后一位的的长度,也就是数组的长度减一,防止越界
                int r = nums.length -1;

                // ０ 减去当前i对应的数组下标的值
                int sum = 0 - nums[i];


                // l 小于　数组长度减一的值
                while (l < r) {

                    if (nums[l] + nums[r] == sum) {

                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {l++;}
                        while (l < r && nums[r] == nums[r - 1]) {r--;}
                        l++;
                        r--;

                    } else if (nums[l] + nums[r] < sum) {

                        // 跳过重复值
                        while (l < r && nums[l] == nums[l + 1]) {
                            r--;
                        }
                        l++;

                    } else {

                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;

                    }
                }

            }

        }
        return ls;

    }
}
