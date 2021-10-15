package com.umair.dynamicprogramming.longestcommonsubsequence;

import java.util.Arrays;

public class Heaters {

    public static void main(String[] args) {

        int[] houses={1,2,3};
        int[] heaters={2};

        Arrays.sort(heaters);
        int result=Integer.MIN_VALUE;

        for(int i=0;i<houses.length;i++){
            int distance=findNearestHeater(houses[i],heaters);
            result=Math.max(result,distance);

        }

        System.out.println(result);

    }

    public static int findNearestHeater(int i,int[] heaters){

        int start=0;
        int end=heaters.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(i==heaters[mid]){
                return 0;
            }
            if(i<heaters[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        if(start==-1) start++;
        if(start==heaters.length) start--;
        if(end==-1)end++;
        if(end==heaters.length) end--;
        return Math.min(Math.abs(i-heaters[start]),Math.abs(i-heaters[end]));
    }
}
