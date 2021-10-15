package com.umair.datastructures.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {

        int[] heights={2,1,5,6,2,3};
        int[] lfr=lowestFromRight(heights);
        int[] lfl=lowestFromLeft(heights);
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int area=heights[i]*(lfr[i]-lfl[i]-1);
            maxArea=Math.max(maxArea,area);
        }
        System.out.println(maxArea);
    }

    public static int[] lowestFromRight(int[] arr){

        int[] result=new int[arr.length];
        int defaultvalue=arr.length;
        Stack<Integer> stack=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(stack.size()>0 && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            result[i]=stack.size()==0?defaultvalue:stack.peek();
            stack.push(i);
        }
        return result;
    }

    public static int[] lowestFromLeft(int[] arr){

        int[] result=new int[arr.length];
        int defaultvalue=-1;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(stack.size()>0 && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            result[i]=stack.size()==0?defaultvalue:stack.peek();
            stack.push(i);
        }
        return result;
    }

}
