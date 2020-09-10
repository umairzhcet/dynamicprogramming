package com.umair.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        int[] nums={1,2,3};

        List<List<Integer>> result=new ArrayList<>();
        powerSet(nums,0,new ArrayList<>(),result);
        System.out.println(result);

    }

    public static void powerSet(int[] nums, int i, List<Integer> partial, List<List<Integer>> result){

        if(i==nums.length){
            result.add(partial);
            return;
        }
        powerSet(nums,i+1,new ArrayList<>(partial),result);
        partial.add(nums[i]);
        powerSet(nums,i+1,new ArrayList<>(partial),result);
    }
}
