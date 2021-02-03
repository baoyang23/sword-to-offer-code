package com.iyang.learn.dynamic.planning.medium;

/**
 * Created by Yang on 2021/2/3 21:50
 *
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 */

public class OneAndZero474 {

    public static void main(String[] args) {
        String [] strs =  new String []{ "10", "0001", "111001", "1", "0" };
        int m = 5;
        int n = 3;
        findMaxForm(strs,m,n);
    }

    /**
     * 使用官方来解答操作
     * @param strs
     * @param m
     * @param n
     */
    public static int findMaxFormByOfficail(String[] strs, int m, int n){

        int [][] dp = new int[m + 1][n + 1];
        for(String s : strs){
            int[] sones = countZeroSones(s);
            for(int zeros=m;zeros >= sones[0];zeros--){
                for(int ones=n;ones>=sones[1];ones--){
                    dp[zeros][ones] = Math.max(1+dp[zeros-sones[0]][ones-sones[1]],dp[zeros][ones]);
                }
            }
        }
        return dp[m][n];
    }

    public static int[] countZeroSones(String s){
        int [] c = new int[2];
        for(int i=0;i<s.length();i++){
            c[s.charAt(i)-'0'] ++;
        }
        return c;
    }

    /**
     *  ["10", "0001", "111001", "1", "0"], m = 5, n = 3
     *  ["10", "0", "1"], m = 1, n = 1
     * @param strs
     * @param m
     * @param n
     */
    public static void findMaxForm(String[] strs, int m, int n){
        int count = 0;
        for(String str : strs){
            int x = m;
            int y = n;
            char[] chars = str.toCharArray();
            for(char ch : chars){
                if(String.valueOf(ch).equals("0")){
                    x --;
                } else {
                    y --;
                }
            }
            int all = x + y;
            if(all > 0 && x >= 0 && y >= 0){ count ++; }
        }
        System.out.println(count);
    }

}
