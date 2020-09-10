package com.umair.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        Integer[] arr={1,5,2,9,7};
       for(int i:arr){
           stack.push(i);
       }
        sort(stack);
        System.out.println(stack);
    }

    private static void sort(Stack<Integer> nums) {

        if(nums.size()==1){
            return;
        }
        int temp=nums.pop();
        sort(nums);
        insert(nums,temp);
    }

    private static void insert(Stack<Integer> nums, int temp) {
        if(nums.size()==0 || nums.peek()<=temp){
            nums.push(temp);
            return;
        }
        int item=nums.pop();
        insert(nums,temp);
        nums.push(item);

    }
}
