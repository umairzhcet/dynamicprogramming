package com.umair.datastructures.stack;

import java.util.Stack;

public class DuplicateParanthesis {

    public static void main(String[] args) {


        String str="(a+b)+(c+(d+e))";
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c!=')'){
                stack.push(c);
            }
            else{
                if(stack.peek()=='('){
                    System.out.println("true");
                    return;
                }
                else{
                    while(stack.peek()!='('){
                        stack.pop();
                    }
                    stack.pop();
                }
            }
        }


        System.out.println("false");
    }
}
