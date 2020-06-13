package com.iyang.learnpointcode.str;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-13
 *
 *  Author          : Gavin
 *
 *  Purpose         :  leetCode # 28
 *
 *  History         :  case : haystack = "hello", needle = "ll"
 *                            haystack = "aaaaa", needle = "bba"
 *
 *</PRE>
 ***************************************************************************/
public class StrStrCaseMain {

    public static void main(String[] args) {


    }

    public void compareStrEvery(){

        String haystack = "hello";
        String needle = "ll";

        int L = needle.length() , n = haystack.length();

        for(int start = 0; start < n - L + 1; ++start){

            if(haystack.substring(start,start+L).equalsIgnoreCase(needle)){

                System.out.println(start);
                break;

            }

        }

        System.out.println(-1);

    }

    public void subStrWhile(){
        String haystack = "hello";
        String needle = "ll";

        int L = needle.length() , n = haystack.length();
        if (L == 0){
            System.out.println("没有值");
            return;
        }

        int pn = 0;
        while (pn < n - L + 1){

            // pn 首次迭代,与 needle的第一个字符进行对比,如果不相等的话,就继续往下 pn++ ; 来进行迭代处理
            while (pn < n -L + 1 && haystack.charAt(pn) != needle.charAt(0)) {
                ++ pn;
            }

            int currLen = 0 , pl = 0;

            // 相等个的话.
            while (pl < L && pn < n && haystack.charAt(pn) == needle.charAt(pl)) {
                ++ pn;
                ++ pl;
                ++ currLen;
            }

            // 相等情况.
            if (currLen == L ) {
                System.out.println("ok");
                break;
            }

            // 如果相等的话, pn 是需要重置参数的,
            pn = pn - currLen + 1;
        }

        System.out.println(-1);
    }

    public void strHashFunc(){

        String haystack = "hello";
        String needle = "ll";



    }

}
