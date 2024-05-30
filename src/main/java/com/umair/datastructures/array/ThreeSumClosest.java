package com.umair.datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

    public static void main(String[] args) {

        int nums[]={-1,2,1,-4};
        int target = 1;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result =0;
        for(int i=0;i<nums.length-2;i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum =nums[i] + nums[j] + nums[k];
                if(sum<target){
                    j++;
                }
                else{
                    k--;
                }
                if(Math.abs(sum-target)<diff){
                    result =sum;
                    diff = Math.abs(sum-target);
                }
            }

        }

        System.out.println(result);
    }
}
