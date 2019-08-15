package com.yang.code.str;

import java.util.*;

/**
 * @Author: Mu_Yi
 * @Date: 2019/8/15 18:16
 * @Version 1.0
 * @qq: 1411091515
 */
public class StringUnification {

    /**
     *
     * 请编写一个字符串归一化程序，统计字符串中相同字符出现的次数，并按字典序输出字符及其出现次数。
     * 例如字符串"babcc"归一化后为"a1b2c2"
     */

    /**
     * Test Main
     * @param args
     */
    public static void main(String[] args) {
        strToOneAndSort("oposodkjfijjngjfnjgjasAAa");
    }
    /**
     *
     * @param str
     */
    public static void strToOneAndSort(String str){
        Map<Character,Integer> dataMap = new HashMap<>();
        for(int i = 0,j = str.length();i < j;i++){
            char charAt = str.charAt(i);
            dataMap.put(charAt,dataMap.containsKey(charAt) ? dataMap.get(charAt) + 1 : 1);
        }
        Set<Character> keySet = dataMap.keySet();
        List<Character> list = new ArrayList<>(keySet);
        Collections.sort(list,(s1,s2) -> s1.compareTo(s2));
        for(Character character : list){
            System.out.print(character.toString() + dataMap.get(character));
        }
    }
}
