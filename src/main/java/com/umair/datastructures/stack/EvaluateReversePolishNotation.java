package com.umair.datastructures.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {

        String[] tokens ={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<tokens.length;i++){

            String token =tokens[i];
            if(token.equals("+")){
                int a =stack.pop();
                int b =stack.pop();
                stack.push(a+b);
            }
            else if(token.equals("-")){
                int c =stack.pop();
                int d =stack.pop();
                stack.push(d-c);
            }
            else if(token.equals("*")){
                int e =stack.pop();
                int f =stack.pop();
                stack.push(f*e);
            }
            else if(token.equals("/")){
                int g =stack.pop();
                int h =stack.pop();
                stack.push(h/g);
            }
            else{
                stack.push(Integer.parseInt(token));

            }
        }

        return stack.pop();
    }
}
