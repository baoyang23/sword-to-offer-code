package com.yang.queue.book;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * [4,3,5,4,3,3,6,7]   ---> {5,5,5,4,6,7}
 *
 *
 * @Author: Mu_Yi
 * @Date: 2020/1/6 21:58
 * @Version 1.0
 * @qq: 1411091515
 */
public class ArrMaxQueue {

    public static void main(String[] args) {
        int [] arr = {4,3,5,4,3,3,6,7};
        getMaxWindow(arr,3);
    }

    public static void getMaxWindow(int [] arr,int w){
        if(arr == null || w < 1 || arr.length < w){
            // 数据有问题
            return;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int [] res = new int[arr.length - w + 1];
        int index = 0;
        for(int i=0;i < arr.length;i++){

            // 循环来弹出小的数据, 后面再根据索引来进行判断
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }

            // 存放索引
            qmax.addLast(i);

            System.out.println("qmax 添加完后 ---> " + qmax);

            // 如果第一个 = 索引减去 个数 w ; 就去掉 第一个
            if(qmax.peekFirst() == i -w){
                qmax.pollFirst();
            }

            // 索引等于  大于 等于  w -1;就说明三个组成了,然后最大数据的索引是存放在第一个
            if(i >= w -1){
                // System.out.println("qmax --->" + qmax);
                // System.out.println();
                res[index++] = arr[qmax.peekFirst()];
            }

        }

        System.out.println(Arrays.toString(res));
    }

}
