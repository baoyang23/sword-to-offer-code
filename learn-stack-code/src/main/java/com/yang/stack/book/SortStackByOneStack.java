package com.yang.stack.book;

import java.util.Stack;

/**
 * @Author: Mu_Yi
 * @Date: 2020/1/5 17:03
 * @Version 1.0
 * @qq: 1411091515
 */
public class SortStackByOneStack {

    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> helpStack = new Stack<>();
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            while (!helpStack.isEmpty() && helpStack.peek() < pop) {
                stack.push(helpStack.pop());
            }
            helpStack.push(pop);
        }

        while (!helpStack.isEmpty()){
            stack.push(helpStack.pop());
        }
    }

}
