package com.umair.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {

        int[] nums={1,2,3};

        List<List<Integer>> result=new ArrayList<>();
        result =powerSet2(nums,0,new ArrayList<>());
        System.out.println(result);

    }



    public static void powerSet1(int[] nums, int i, List<Integer> partial, List<List<Integer>> result){

        if(i==nums.length){
            result.add(partial);
            return;
        }
        powerSet1(nums,i+1,new ArrayList<>(partial),result);
        partial.add(nums[i]);
        powerSet1(nums,i+1,new ArrayList<>(partial),result);
    }

    public static List<List<Integer>> powerSet2(int[] nums, int i, List<Integer> partial){

        if(i==nums.length){
            List<List<Integer>> result = new ArrayList<>();
            result.add(partial);
            return result;
        }
        List<List<Integer>> r1 =powerSet2(nums,i+1,new ArrayList<>(partial));
        partial.add(nums[i]);
        List<List<Integer>> r2 =powerSet2(nums,i+1,new ArrayList<>(partial));
        r1.addAll(r2);
        return r1;

    }

    public List<List<Integer>> iterative(int[] nums){

        List<List<Integer>> outer=new ArrayList<>();

        outer.add(new ArrayList<>());

        for(int num:nums){
            int n =outer.size();
            for(int i=0;i<n;i++){
                List<Integer> internal =outer.get(i);
                internal.add(num);
                outer.add(internal);
            }

        }


        return outer;


    }
}
