package com.iyang.learnstrcode.str;

/****
 * author: BaoYang
 * date: 2023/8/29
 * desc:
 ***/

public class ConvertNumber {

    public static void main(String[] args) {


        converNum(-123);
    }


    public static int converNum(int x){

        // x = 1000000000
        int res = 0;
        while (x != 0) {
            // 取尾数
            int lastNum = x % 10;
            if (res > 214748364 || (res == 214748364 && lastNum > 7)) {
                return 0 ;
            }
            if (res < -214748364 || (res == -214748364 && lastNum < -8)) {
                return 0;
            }
            // 做新结果的计算
            res = res * 10 + lastNum;
            // 对原有的x进行取莫操作
            x /= 10;
        }

        System.out.println("res: " + res);
        return res;
    }

}
