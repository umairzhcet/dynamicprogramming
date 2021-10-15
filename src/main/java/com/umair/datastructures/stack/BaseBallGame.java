package com.umair.datastructures.stack;

import java.util.Stack;

public class BaseBallGame {
    public static void main(String[] args) {
         BaseBallGame main=new BaseBallGame();
         main.calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
    }
    public int calPoints(String[] ops) {

        Stack<Integer> stack=new Stack<>();

        for(String op:ops){
            if(op.equals("+")){

                int a=stack.pop();
                int b=stack.pop();
                int c=a+b;
                stack.push(b);
                stack.push(a);
                stack.push(c);
            }
            else if(op.equals("D")){
                int temp=stack.peek();
                stack.push(temp*2);
            }
            else if(op.equals("C")){
                stack.pop();
            }

            else{
                stack.push(Integer.parseInt(op));
            }
        }
        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }

        return sum;
    }
}
