package com.yang.stack.book;

import java.util.Stack;

/**
 * @Author: Mu_Yi
 * @Date: 2020/1/5 12:16
 * @Version 1.0
 * @qq: 1411091515
 */
public class RecursionInverseStack {

    public static int inverseFunction(Stack<Integer> stack){
        int result = stack.pop();
        System.out.println("result ---> " + result);
        if(stack.isEmpty()){
            stack.push(result);
            return result;
        } else {
            int last = inverseFunction(stack);
            stack.push(result);
            return last;
        }
    }

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);

        inverseFunction(stack);
        System.out.println(stack);
    }

}
