package com.umair.recursion;

public class IsInSequence {

    public static void main(String[] args) {
        int[] nums={2,3,4,5,6,8};
        boolean  result=checkSequence(nums,0);
        System.out.println(result);
    }

    private static boolean checkSequence(int[] nums, int i) {

        if(i==nums.length-1){
            return true;
        }
        return nums[i]==nums[i+1]-1 && checkSequence(nums,i+1);
    }
}
