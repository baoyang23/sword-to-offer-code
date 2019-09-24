package com.yang.code.leetcode.simple;

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
 *  History         : 　罗马数字转整数
 *
 *</PRE>
 ***************************************************************************/
public class RomeNumberToNumber {


    public static void main(String[] args) {
        int number = romeToInt("MCMXCIV");
        System.out.println(number);
    }


    public static int romeToInt(String s) {

        int n = s.length();
        int romeInt = 0;
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'I':
                    romeInt = romeInt + 1;
                    break;
                case 'V':
                    romeInt = romeInt + 5;
                    break;
                case 'X':
                    romeInt = romeInt + 10;
                    break;
                case 'L':
                    romeInt = romeInt + 50;
                    break;
                case 'C':
                    romeInt = romeInt + 100;
                    break;
                case 'D':
                    romeInt = romeInt + 500;
                    break;
                case 'M':
                    romeInt = romeInt + 1000;
                    break;
                default:
                    System.out.println("default");
                    break;
            }
            if (i != 0) {
                if (((s.charAt(i) == 'V') || (s.charAt(i) == 'X')) && (s.charAt(i - 1) == 'I')) {
                    romeInt = romeInt - 1 * 2;
                }
                if (((s.charAt(i) == 'L') || (s.charAt(i) == 'C')) && (s.charAt(i - 1) == 'X')) {
                    romeInt = romeInt - 10 * 2;
                }
                if (((s.charAt(i) == 'D') || (s.charAt(i) == 'M')) && (s.charAt(i - 1) == 'C')) {
                    romeInt = romeInt - 100 * 2;
                }
            }
        }

        return romeInt;
    }
}
