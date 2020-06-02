package com.iyang.learnstrcode.str;


/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-2
 *
 *  Author          : Gavin
 *
 *  Purpose         :  字符串的反转. leetCode #557
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

public class StrReverseWords {

    /**
     * 时间复杂度O(N) / 空间复杂度O(N)
     *
     * @param args
     */
    public static void main(String[] args) {

        String str = "Let's take LeetCode contest";
        String[] split = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s : split){
            sb.append(new StringBuffer(s).reverse().toString()+ " ");
        }
        System.out.println(sb.toString().trim());

        System.out.println(" ----------  ");
        reverseWords();
    }

    public static void reverseWords(){
        String s = "this is a teacher";
        char[] chars = s.toCharArray();
        reverse(chars,0,chars.length-1);
        int i=0,j=0;
        // chars 是整体倒过来的.
        while (j < chars.length){
            while (j < chars.length && chars[j] != ' '){
                j ++;
            }
            reverse(chars,i,j-1);
            i = j + 1;
            j++;
        }
        System.out.println(new String(chars));
    }

    /**
     * 双指针来记录对应的数值信息.
     * @param arr
     * @param start
     * @param end
     */
    public static void reverse(char [] arr,int start,int end){
        while (start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            ++ start;
            --end;
        }
    }

}
