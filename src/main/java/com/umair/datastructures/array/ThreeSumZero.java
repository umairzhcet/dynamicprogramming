package com.umair.datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumZero {

    public static void main(String[] args) {

        int nums[]={-1,0,1,2,-1,-4};
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();

        for(int i=0;i<nums.length-2;i++) {
            int j = i + 1;
            int k = nums.length - 1;
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            while (j < k) {
                if (nums[j] + nums[k] + nums[i] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    j++;
                    k--;
                    while(j<k && nums[j-1]==nums[j] && nums[k]==nums[k+1]){
                        j++;
                        k--;
                    }

                } else if (nums[j] + nums[k] + nums[i] > 0) {
                    k--;
                } else {
                    j++;
                }
            }

        }

        System.out.println(result);
    }
}
