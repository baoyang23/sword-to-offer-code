package com.yang.stack.book.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-3
 *
 *  Author          : Gavin
 *
 *  Purpose         :   leetCode : 检验字符,使用Stack来完成
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class VaildCharacter {


    public static void main(String[] args) {

        String s = "()";
        Map<Character,Character> map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');

        boolean isTrue = true;
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(!map.containsKey(c)){ stack.add(c); }
            else {
                if(stack.isEmpty()){ isTrue = false; break;}
                Character character = stack.pop();
                isTrue = map.get(c).equals(character);
                if(!isTrue){ break; }
            }
        }

        System.out.println((isTrue ? stack.isEmpty() : isTrue));

    }

}
