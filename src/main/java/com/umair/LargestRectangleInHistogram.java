package com.umair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {

        int[] heights={2,1,5,6,2,3};

        ArrayList<Integer> lfl=lowestFromLeft(heights);
        ArrayList<Integer> lfr=lowestFromRight(heights);
        int max=0;

        for(int i=0;i<heights.length;i++){

            int area=heights[i]*(lfr.get(i)-lfl.get(i)-1);
            max=Math.max(max,area);
        }

        System.out.println(max);
    }

    private static ArrayList<Integer> lowestFromRight(int[] heights) {

        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> result=new ArrayList<>();
        int pseudoIndex=heights.length;

        for(int i=heights.length-1;i>=0;i--){
         if(stack.isEmpty()){
             result.add(pseudoIndex);
         }
         else if(!stack.isEmpty() && heights[stack.peek()]<heights[i]){
             result.add(stack.peek());
         }
         else if(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
             while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                 stack.pop();
             }
             if(stack.isEmpty()){
                 result.add(pseudoIndex);
             }
             else{
                 result.add(stack.peek());
             }
         }
         stack.add(i);

        }
        Collections.reverse(result);

        return result;
    }

    private static ArrayList<Integer> lowestFromLeft(int[] heights) {


        Stack<Integer> stack=new Stack<>();
        ArrayList<Integer> result=new ArrayList<>();
        int pseudoIndex=-1;

        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty()){
                result.add(pseudoIndex);
            }
            else if(!stack.isEmpty() && heights[stack.peek()]<heights[i]){
                result.add(stack.peek());
            }
            else if(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    result.add(pseudoIndex);
                }
                else{
                    result.add(stack.peek());
                }
            }
            stack.add(i);

        }

        return result;
    }
}
