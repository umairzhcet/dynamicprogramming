package com.umair.dynamicprogramming.leetcode;

import java.util.Arrays;

public class JumpGame {


    static int[] cache;
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        cache=new int[100001];
        Arrays.fill(cache,-1);
        System.out.println("Recursive method:"+helper(nums,0));

        int pos=nums.length-1;

        for(int i=nums.length-1;i>=0;i--){
            if(i+nums[i]>=pos){
                pos=i;
            }
        }

        System.out.println(pos==0);

    }

    public static boolean helper(int[] nums, int pos){

        if(pos==nums.length-1){
            return true;
        }

        if(nums[pos]==0){
            return false;
        }
        if(cache[pos]!=-1){
            return cache[pos]==1?true:false;
        }
        boolean flag=false;
        for(int i=1;i<=nums[pos];i++){
            flag=flag|| helper(nums,pos+i);
            if(flag){
                cache[pos]=1;
                return true;
            }
        }
        if(flag){
            cache[pos]=1;
        }
        else{
            cache[pos]=0;
        }
        return flag;
    }
}
