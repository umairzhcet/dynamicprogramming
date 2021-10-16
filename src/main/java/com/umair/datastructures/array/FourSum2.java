package com.umair.datastructures.array;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {
    public static void main(String[] args) {

        FourSum2 main=new FourSum2();
        int[] nums1={1,2};
        int[] nums2={-2,-1};
        int[] nums3={-1,2};
        int[] nums4={0,2};
        System.out.println(main.fourSumCount(nums1,nums2,nums3,nums4));

    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer,Integer> map=new HashMap<>();
        int result=0;

        int n=nums1.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum12=nums1[i]+nums2[j];
                map.put(sum12,map.getOrDefault(sum12,0)+1);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int sum34=-(nums3[i]+nums4[j]);
                if(map.containsKey(sum34)){
                    result+=map.get(sum34);
                }
            }
        }

        return result;


    }
}
