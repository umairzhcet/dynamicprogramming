package com.umair;

import com.google.gson.internal.bind.util.ISO8601Utils;

public class AllocateMinimumPages {

    public static void main(String[] args) {

        int[] weights={1,2,3,1,1};
        int D=4;

        int start=0;
        int end=0;
        for(int i=0;i<weights.length;i++){
            end+=weights[i];
        }
        int result=Integer.MAX_VALUE;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(isValid(weights,D,mid)){
                result=Math.min(result,mid);
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }
        System.out.println(result);

    }
    public static boolean isValid(int[] weights,int D, int max){

        int sum=0;
        int days=1;
        for(int i=0;i<weights.length;i++){
            if(weights[i]>max){
                return false;
            }
            sum+=weights[i];
            if(sum>max){
                sum=weights[i];
                days++;
            }
            if(days>D){
                return false;
            }
        }
        return true;
    }





}
