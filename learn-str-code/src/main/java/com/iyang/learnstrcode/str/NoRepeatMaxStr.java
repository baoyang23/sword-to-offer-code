package com.iyang.learnstrcode.str;

import java.util.*;

/***
 * @author: LuoHong
 * @date: 23:01
 * @think: Please keep learning
 * @desc: leetCode:3.  无重复字符的最长子串.
 **/



public class NoRepeatMaxStr {

    public static void main(String[] args) {

        //String s  = "pwwkew";
        String s = "abcdafghemnca";

        solutionByBest(s);

        System.out.println("方法分割符号------------");
        solutionByViolence(s);
    }


    public static void solutionByBest(String s){

        Map<Character, Integer> map  = new HashMap<Character, Integer>();

        // start 记录的是开始指针,  max 记录的是长度 , 利用双指针的方式和map覆盖的方式.
        int max = 0 , start = 0;
        for(int i=0;i<s.length();i++){

            // 当前下标遍历的一个值.
            char charAt = s.charAt(i);

            // 判断map中是否包含有
            if(map.containsKey(charAt)){

                // map.get(chatAt) + 1 , 占用了一位相同的大小进行比较.
                start  = Math.max(map.get(charAt) + 1,start);
                System.out.println("start的值是--->" + start);
            }

            max = Math.max(max,i - start + 1);
            map.put(charAt,i);
        }

        System.out.println("最大长度的字符串是:" + max);
    }


    public static void solutionByViolence(String s){
        // pwwkew
        Set<String> setStr = new HashSet<String>();
        int maxValue = 1;

        for(int i=0;i<s.length();i++){
            StringBuffer sb = new StringBuffer(s.charAt(i));
            for(int j=i+1;j<s.length();j++){
                if(!sb.toString().contains(String.valueOf(s.charAt(j)))){
                    sb.append(s.charAt(j));
                    setStr.add(String.valueOf(sb));
                    maxValue = Math.max(maxValue,sb.toString().length());
                } else {
                    break;
                }
            }
        }


        System.out.println(setStr);
        System.out.println("最大长度是:" + maxValue);
    }

}
