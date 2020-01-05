package com.yang.stack.book;

import java.util.Stack;

/**
 *   使用二个栈来实现队列
 *
 * @Author: Mu_Yi
 * @Date: 2020/1/5 12:02
 * @Version 1.0
 * @qq: 1411091515
 */
public class DoubleStackToQueue {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public DoubleStackToQueue(){
        this.stackPush = new Stack<>();
        this.stackPop = new Stack<>();
    }

    public void push(int number){
        this.stackPush.push(number);
    }

    public int poll(){
        if(stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("The stack is empty.Pls check it.");
        } else if(stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek(){
        if(stackPush.empty() && stackPop.empty()){
            throw new RuntimeException("The stack is empty.Pls check it.");
        } else if(stackPop.empty()){
            while (!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    @Override
    public String toString(){
        return "[The stackPush value is " + stackPush + "]  ;  [The stackPop value is" + stackPop + "]" ;
    }

    public static void main(String[] args) {

        DoubleStackToQueue doubleStackToQueue = new DoubleStackToQueue();
        doubleStackToQueue.push(1);
        doubleStackToQueue.push(2);
        doubleStackToQueue.push(3);
        doubleStackToQueue.push(4);

        System.out.println(doubleStackToQueue.toString());

        System.out.println(doubleStackToQueue.poll());

        System.out.println(doubleStackToQueue.toString());
    }
}
