package com.umair.datastructures.array;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4};
        int[] result = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        for(int n:result){
            System.out.println(n);
        }

    }

    public int[] productExceptSelf(int[] nums) {

        int left = 1;
        int right =1;

        int[] result=new int[nums.length];

        for(int i=0;i<nums.length;i++){
            result[i]=left;
            left=left*nums[i];
        }

        for(int i=nums.length-1;i>=0;i--){
            result[i]=result[i]*right;
            right=right*nums[i];
        }

        return result;

    }


}
