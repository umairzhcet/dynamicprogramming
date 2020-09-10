package com.umair;

public class MinimumInRotatedArray {

    public static void main(String[] args) {

        int nums[]={2,3,4,5,1};
        int N=nums.length;
        int start=0;
        int end=N-1;
        if(N==1) System.out.println(nums[0]);

        while(start<=end){
            if(nums[start]<nums[end]){
                System.out.println(nums[start]);
            }
            int mid=start +(end-start)/2;
            if(mid>0 && nums[mid]<nums[mid-1]){
                System.out.println(nums[mid]);
            }
            else if(nums[mid]>=nums[start]){
                start=mid+1;
            }
            else {
                end=mid-1;
            }

        }

        System.out.println(-1);
    }
}
