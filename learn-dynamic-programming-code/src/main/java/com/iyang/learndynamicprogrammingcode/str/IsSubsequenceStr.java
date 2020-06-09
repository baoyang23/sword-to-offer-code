package com.iyang.learndynamicprogrammingcode.str;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-5
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/
public class IsSubsequenceStr {

    public static void main(String[] args) {

        String s = "axc";
        String t = "ahbgdc";

        char[] array = s.toCharArray();
        int z = -1;
        boolean isFlag = true;
        for(int i=0,j=array.length;i<j;i++){
            int index = t.indexOf(array[i], z);
            if(index == -1 ){
                isFlag = false;
                break;
            }
            z = index;
        }

        System.out.println(isFlag);
    }

}
