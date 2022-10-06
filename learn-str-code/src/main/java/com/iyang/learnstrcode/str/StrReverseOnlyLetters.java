package com.iyang.learnstrcode.str;

import java.util.Stack;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-2
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class StrReverseOnlyLetters {

    public static void main(String[] args) {
        String s = "Test1ng-Leet=code-Q!";
        char[] chars = s.toCharArray();
        int first = 0;
        int end = s.length() - 1;
        while (first < end) {
            if(!Character.isLetter(chars[first])){
                ++ first;
            } else if (!Character.isLetter(chars[end])){
                -- end;
            } else {
                char temp = chars[first];
                chars[first] = chars[end];
                chars[end] = temp;
                ++ first;
                -- end;
            }
        }
        System.out.println(new String(chars));
    }


    /**
     *
     * 利用栈的先进后出来完成反转操作.666
     *
     */
    public static void reverseByStack(){

        String s = "Test1ng-Leet=code-Q!";
        Stack<Character> letters = new Stack<Character>();

        for(char c : s.toCharArray()){

            if(Character.isLetter(c)){
                letters.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetter(c)){
                sb.append(letters.pop());
            } else {
                sb.append(c);
            }
        }

        System.out.println(sb.toString());
    }

}
