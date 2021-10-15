package com.umair.datastructures.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterRight {
    public static void main(String[] args) {
    int[] arr={2 ,5 ,9 ,3 ,1 ,12 ,6 ,8 ,7};
    int[] result=solve(arr);
        Arrays.stream(result).forEach(x->System.out.println(x));

    }

    public static int[] solve(int[] arr){
        int[] result=new int[arr.length];
        Stack<Integer> stack=new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            while(stack.size()>0 && stack.peek()<arr[i]){
                stack.pop();
            }
            result[i]=stack.size()==0?-1:stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }

}
