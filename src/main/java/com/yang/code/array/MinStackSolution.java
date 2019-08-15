package com.yang.code.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 包含min 函数得栈
 * @Author: Mu_Yi
 * @Date: 2019/8/15 23:19
 * @Version 1.0
 * @qq: 1411091515
 */
public class MinStackSolution {
    Stack<Integer> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();

    public void push(int node){
        stack.push(node);
        if(list.size() != 0){
            int min = list.get(list.size() - 1).intValue();
            list.add(min < node ? min : node);
        } else {
            list.add(node);
        }
    }

    public void pop(){
        stack.pop();
        list.remove(list.size() -1 );
    }

    public int top(){
        return stack.peek();
    }

    public int min(){
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        MinStackSolution minStackSolution = new MinStackSolution();
        minStackSolution.push(2);
        minStackSolution.push(3);
        minStackSolution.push(1);
        int min = minStackSolution.min();
        System.out.println(min);
    }

}
