package com.iyang.hashs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/***
 * @author: baoyang
 * @data: 2022/8/20
 * @desc: 电话号码的字母组合
 ***/

public class NumberLetterCombinations {

    public static void main(String[] args) {

        List<String> strings = new NumberLetterCombinations().letterCombinations("23");
        System.out.println(strings);
    }

    List<String> allRes = new ArrayList<>();
    String[] letterMap = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {


        if("".equals(digits) || digits.length() == 0){
            return new ArrayList<>();
        }

        return null;
    }

    // 递归获取有可能的字符串
    public void appendAll(String str , StringBuffer sb, int index){
        if(index == str.length() ){
            allRes.add(sb.toString());
            return;
        }
        char c = str.charAt(index);
        int pos = c - '0';
        // abc , def
        String s = letterMap[pos];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            // 如果第二次没有的话,就只取上面的 sb.append 里面的值
            appendAll(str,sb,index +1);
            // 删除单头的一个节点
            sb.deleteCharAt(s.length() - 1);
        }

    }


}
