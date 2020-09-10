package com.umair;

import java.util.HashMap;

public class SubArraySum {

    public static void main(String[] args) {

        int[] nums={1,1,1};
        int k=2;

        int result=0;

        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;

        for(int i=0;i<nums.length;i++){

            sum+=nums[i];
            if(sum==k){
                result++;
            }

            if(map.containsKey(sum-k)){
                result+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);

        }

        System.out.println(result);

    }
}
