package com.umair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int nums[]={3,2,1,6,0,9};
        int sum=12;
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();

        for(int i=0;i<nums.length-2;i++) {
            int j = i + 1;
            int k = nums.length - 1;
            if(nums[i]!=nums[j]){
            while (j < k) {
                if (nums[j] + nums[k] + nums[i] == sum) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    k--;
                } else if (nums[j] + nums[k] + nums[i] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        }

        System.out.println(result);
    }
}
