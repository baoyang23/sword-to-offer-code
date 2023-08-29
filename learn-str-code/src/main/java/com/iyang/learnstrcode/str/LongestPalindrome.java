package com.iyang.learnstrcode.str;

/****
 * author: BaoYang
 * date: 2023/8/26
 * desc:
 ***/
public class LongestPalindrome {

    /**
     * 1. 如果是for暴力解法的话, 第一层就是开始下标位置，
     *    第二层就是从开始下标位置到结束最后一位的穷据字符串，然后判断是不是回文，如果是回文的话，判断最大长度
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        // System.out.println(maxLongetStrFor("aaaaaa"));

        centerDiffusion("aaaaaa");
    }

    /**
     * 中心扩散法声明
     * @param str
     */
    public static void centerDiffusion(String str){
        char[] chars = str.toCharArray();
        int left  = 0;
        int rigth = 0;
        int maxLen = 0;
        String maxStr = new String(chars[0] + "");

        for (int i = 0; i < chars.length; i++) {
            // 向二边进行扩散操作
            left = i;
            rigth = i + 1;
            // 说明是满足扩散的条件
            while (left >=0 && rigth < chars.length && chars[left] == chars[rigth]) {
                // 往左边进行减少;往右边进行添加
                left --;
                rigth ++;
            }

            // 重置最大的对称数据 ; 1 - (-1) - 1 > 0 : 重置条件
            if (rigth - left - 1 > maxLen) {
                maxLen = rigth - left - 1;
                maxStr = str.substring(left + 1, rigth);
            }
        }

        System.out.println("the maxStr is ---> " + maxStr);
    }

    /**
     * dp 记录子状态;  父类的前置条件是子类也必须是回文状态
     * @param str
     * @return
     */
    public static String maxLongetStrFor(String str){
        if (str == null || str.length() < 2) {
            return str;
        }

        int length = str.length();
        // 记录子字符串的集合状态;判断子集合字符串是否是回文
        boolean [][]db = new boolean[length][length];
        int min = 0;
        int max = 0;
        int maxLen = 1;

        for (int i = 1; i < length; i++) {
            // 长度 0 - i 的字符串子集合判断;
            for(int j = 0; j < i; j ++){
                if (str.charAt(i) == str.charAt(j) && (i - j <= 2 || db[i-1][j+1])) {
                    // 确保子集合是回文字符串
                    db[i][j] = true;
                    // 记录最值长度,以及组成最大长度的  开始index和结束index
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        min = j;
                        max = i;
                    }
                }
            }
        }
        return str.substring(min, max + 1);

    }


}
