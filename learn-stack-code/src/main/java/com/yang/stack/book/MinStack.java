package com.yang.stack.book;

import java.util.Stack;

/**
 *  实现一个特殊栈,在实现基本得功能上,再实现返回栈中最小的元素的操作
 *  时间复杂度 O(1)
 *
 *
 * @Author: Mu_Yi
 * @Date: 2020/1/5 11:27
 * @Version 1.0
 * @qq: 1411091515
 */
public class MinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack(){
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int number){
        if(stackData.empty() && stackMin.empty()){
            this.stackMin.push(number);
        }else if (number <= this.getMin()){
            stackMin.push(number);
        }
        this.stackData.push(number);
    }

    private void pushDouble(int number){
        if(this.stackMin.empty()){
            this.stackMin.push(number);
        } else if(number <= this.getMin()){
            this.stackMin.push(number);
        } else {
            Integer minPeekNumber = this.stackMin.peek();
            this.stackMin.push(minPeekNumber);
        }
        this.stackData.push(number);
    }

    private int popDouble(){
        if(this.stackData.empty()){
            throw new RuntimeException("The stackData is empty.");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int pop(){
        if(this.stackData.empty()){
            throw new RuntimeException("The stackData is empty.");
        }
        Integer value = this.stackData.pop();
        if(value == this.getMin()){
            return this.stackMin.pop();
        }
        return value;
    }

    public int getMin(){
        if(stackMin.empty()){
            throw new RuntimeException("The StackMin is empty.");
        }
        return stackMin.peek();
    }

    @Override
    public String toString(){
        return "[The stackData value is ----> " + stackData + "] ; [ The stackMin value is ----> " + stackMin + "]";
    }

    public static void main(String[] args) {
        MinStack minStack  = new MinStack();
        minStack.push(10);
        minStack.push(1);
        minStack.push(5);
        minStack.push(3);
        System.out.println(minStack.toString());

        int pop = minStack.pop();
        System.out.println("pop  ---> " + pop);
    }

}
