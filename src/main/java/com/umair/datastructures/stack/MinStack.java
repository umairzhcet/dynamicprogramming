package com.umair.datastructures.stack;

import jdk.nashorn.internal.IntDeque;

import java.util.Stack;

public class MinStack {

    private static Stack<Integer> stack=new Stack<>();
    private static Stack<Integer> minStack=new Stack<>();

    public static void main(String[] args) {

        push(512);
        push(-1024);
        push(-1024);
        push(512);
        pop();
        System.out.println(getMin());
        pop();
        System.out.println(getMin());
        pop();
        System.out.println(getMin());


    }

    public static void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek()>=x){
            minStack.push(x);
        }
    }

    public static void pop() {

        int top=stack.pop();
        if(top==minStack.peek()){
            minStack.pop();
        }


    }

    public static int top() {

        return stack.peek();

    }

    public static int getMin() {

        return minStack.peek();
    }
}
