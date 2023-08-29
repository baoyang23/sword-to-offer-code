package com.iyang.learnstrcode.str;

import java.util.ArrayList;
import java.util.List;

/****
 * author: BaoYang
 * date: 2023/8/29
 * desc: Z型字符串拼接
 ***/

public class ZStrAppend {

    public static void main(String[] args) {


        convertZstr("PAYPALISHIRING", 4);

    }

    public static String convertZstr(String str, int numRow){
        if (numRow <= 1) {
            return str;
        }
        // PAYPALISHIRING   4
        List<StringBuffer> allRowList = new ArrayList<>(numRow);
        for (int i = 0; i < numRow; i++) {
            allRowList.add(new StringBuffer());
        }

        char[] chars = str.toCharArray();
        boolean isConvert = false;
        int indexNum = 0;

        for (char aChar : chars) {
            allRowList.get(indexNum).append(aChar);
            if (indexNum == 0 || indexNum == numRow - 1 ) {
                isConvert = !isConvert;
            }
            // 一上一下的判断条件;
            // true: 数组下标向后移动;   false: 数组下标向前移动;
            indexNum += isConvert ? 1 : -1;
        }

        StringBuffer sb = new StringBuffer();
        for (StringBuffer stringBuffer : allRowList) {
            sb.append(stringBuffer);
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

}
