package com.yang.code.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

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
 *  History         : 查找字符串数组中的最长公共前缀。
 *
 *</PRE>
 ***************************************************************************/
public class LongestCommonPrefixCase {


    public static void main(String[] args) {

        String [] arr = new String[]{"dog","racecar","car"};
        String str = longestCommonPrefix(arr);

        System.out.println("str : " + str);
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length == 1){ return strs[0]; }

        StringBuilder stringBuilder = new StringBuilder("");
        if(strs.length > 1){

            int len = strs[0].length();
            for(int i=0;i<len;i++){
                // 获取第一个元素的第i个字节
                char curr = strs[0].charAt(i);

                for(int j=1;j<strs.length;j++){

                    // 后面的字节
                    char behindChar = strs[j].charAt(i);

                    // 如果后面的长度比第一个小 或者 字节不相等就返回
                    if(strs[j].length() <= i || behindChar != curr){
                        return stringBuilder.toString();
                    }

                    // 如果相同　　并且j是数组中最后的一个元素 　就添加到StringBuilder中
                    if(behindChar == curr && j == strs.length - 1){
                        stringBuilder.append(curr);
                    }

                }

            }

        }
        return stringBuilder.toString();
    }

}
