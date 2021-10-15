package com.umair.datastructures.stack;

import java.util.HashMap;
import java.util.Stack;

public class StockSpan2 {

    static Stack<int[]> stack = new Stack<>();

    static int elements = 0;

    public static void main(String[] args) {

        System.out.println(next(100));
        System.out.println(next(80));
        System.out.println(next(60));
        System.out.println(next(70));
        System.out.println(next(60));
        System.out.println(next(75));
        System.out.println(next(85));


    }

    public static int next(int price) {
        int count = 1;

        while(stack.size()!=0 && stack.peek()[0]<=price)
    {
        count = count + stack.peek()[1];
        stack.pop();


    }
        stack.push(new int[]{price,count});

         return count;

}
}
