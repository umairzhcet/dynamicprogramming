package com.umair.dynamicprogramming;

public class MaximumSubarraySum {

    public static void main(String[] args) {

        int[] arr ={4,3,-2,6,-12,7,-1,6};
        System.out.println(maxSubarraySum(arr));

    }

    public static int maxSubarraySum(int[] arr){

        int currMax = arr[0];
        int maxSumSoFar = arr[0];

        for(int i=1;i<arr.length;i++){
            currMax=currMax+arr[i];
            if(currMax<arr[i]){
                currMax = arr[i];
            }
            if(maxSumSoFar<currMax){
                maxSumSoFar = currMax;
            }
        }
        return maxSumSoFar;
    }
}
