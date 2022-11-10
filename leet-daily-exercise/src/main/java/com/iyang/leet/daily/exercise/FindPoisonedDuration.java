package com.iyang.leet.daily.exercise;

import java.util.HashSet;

public class FindPoisonedDuration {


    public static void main(String[] args) {

        int [] timeSeries = { 1,2 };
        int duration = 2;

        int commonSouletion = new FindPoisonedDuration().commonSolutionYh(timeSeries, duration);
        System.out.println(commonSouletion);

    }

    public int commonSolutionYh(int[] timeSeries, int duration){
        // 12  23
        int ans = 0;
        int last = -1;
        for (int timeSery : timeSeries) {

            int s = timeSery + duration - 1;
            //  timeSery > last 是无重叠, 否则就是有重叠
            // 启示位置,没有经过二次计算的位置
            ans += last < timeSery ? duration : s - last;
            last = s ;
        }
        return ans;
    }

    // 暴力破解,会超过时间限制
    public int commonSouletion(int[] timeSeries, int duration){

        HashSet<Integer> set = new HashSet<>();
        for (int timeSery : timeSeries) {

            for (int i = 0; i < duration; i++) {
                set.add(timeSery+i);
            }

        }

        return set.size();
    }

}
