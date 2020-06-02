package com.yang.stack.book.array;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-1
 *
 *  Author          : Gavin
 *
 *  Purpose         :  拼接单词. leetcode #1160
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class SplicingStr {

    public static void main(String[] args) {

        String [] words = new String[]{"cat","bt","hat","tree"};
        String chars = "atach";
        int count = 0;

        int [] wordCache = new int[26];
        for(char c : chars.toCharArray()){
            wordCache[c-'a']++;
        }

        for(String word : words){

            int [] temp = new int[26];
            boolean flag = true;
            for(char c : word.toCharArray()){
                temp[c-'a']++;
            }

            for(int i=0;i<chars.length();i++){
                if(temp[i] >  wordCache[i]){
                    flag = false;
                    break;
                }

            }

            if(flag) { count += word.length(); };
        }

        System.out.println(count);
    }

}
