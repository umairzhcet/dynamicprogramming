package com.umair.datastructures.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {
        int[] arr=new int[]{2 ,5 ,9, 3 ,1, 12, 6, 8, 7};
        int[] result=solve(arr);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] solve(int[] arr){
        // find index of nearest greater to left
        int[] result=new int[arr.length];
        Stack<int[]> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(stack.size()>0 && stack.peek()[0]<arr[i]){
                stack.pop();
            }
            result[i]=stack.size()>0?stack.peek()[1]:-1;
            stack.push(new int[]{arr[i],i});
        }
        for(int i=0;i<result.length;i++){
            result[i]=i-result[i];
        }
        return result;

    }
}
