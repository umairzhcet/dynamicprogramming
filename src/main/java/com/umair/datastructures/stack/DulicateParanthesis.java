package com.umair.datastructures.stack;

import java.util.Scanner;
import java.util.Stack;

// (a+b)+(c-d)+((f+g))
public class DulicateParanthesis {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch!=')'){
                stack.push(ch);
            }
            else{
                if(stack.peek()!='('){
                    while(stack.peek()!='('){
                         stack.pop() ;
                    }
                    stack.pop();
                }
                else{
                    System.out.println("True");
                    System.exit(0);
                }
            }
        }
        System.out.println("False");

    }
}
