package com.iyang.hashs;

/***
 * @author: baoyang
 * @data: 2022/8/20
 * @desc: 整数转化为 罗马数字
 ***/

public class NumberToRoman {

    public static void main(String[] args) {

        System.out.println(new NumberToRoman().intToRoman(3999));
        System.out.println(new NumberToRoman().intToRoman(1994));

    }


    public String intToRoman(int num) {

        // 类似 900 , 400 , 90 , 40 , 9 , 4 特殊占位
        // 穷举特殊的字段值,然后一次判断和执行
        int [] numVals = { 1000 , 900 , 500 , 400 , 100 , 90 , 50 , 40 , 10 , 9 ,    5 ,   4 ,   1 };
        String [] romans = { "M" , "CM" , "D" , "CD" , "C" , "XC" , "L" , "XL" , "X" , "IX" , "V" , "IV" , "I" };

        StringBuffer sb = new StringBuffer();
        int index = 0;
        while (index < 13) {
            while (num >= numVals[index]) {
                sb.append(romans[index]);
                num -= numVals[index];
            }
            index ++;
        }
        return sb.toString();
    }

}
