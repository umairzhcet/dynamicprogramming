package com.umair.datastructures.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MaximumRectangleBinaryMatrix {

    public static void main(String[] args) {

        char[][] matrix={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        int max=0;
        int[] arr=new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]=='0'){
                    arr[j]=0;
                }
                else{
                    arr[j]+=1;
                }
            }
            int area=calculateHistogram(arr);
            max=Math.max(max,area);
        }

        System.out.println(max);
    }


    public static int calculateHistogram(int[] heights){

        ArrayList<Integer> lfl=lowestFromLeft(heights);
        ArrayList<Integer> lfr=lowestFromRight(heights);
        int max=0;

        for(int i=0;i<heights.length;i++){

            int area=heights[i]*(lfr.get(i)-lfl.get(i)-1);
            max=Math.max(max,area);
        }

        return max;

    }

    public static ArrayList<Integer> lowestFromRight(int[] heights) {

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

    public  static ArrayList<Integer> lowestFromLeft(int[] heights) {


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
