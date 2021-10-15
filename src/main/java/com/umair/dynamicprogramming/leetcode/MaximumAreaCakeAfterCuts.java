package com.umair.dynamicprogramming.leetcode;

import java.util.Arrays;

public class MaximumAreaCakeAfterCuts {

    public static void main(String[] args) {

        int h=5;
        int w=4;
        int[] horizontalCuts={3, 1};
        int[] verticalCuts={1};

        int maxH=findMax(horizontalCuts,h);
        int maxW=findMax(verticalCuts,w);

        System.out.println((int)((long)maxH * maxW % 1000000007));
    }

    public static int findMax(int[] cuts,int length){
        int max=0;
        int prev=0;
        Arrays.sort(cuts);

        for (int i = 0; i < cuts.length; i++) {

            max=Math.max(cuts[i]-prev,max);
            prev=cuts[i];
        }
        return Math.max(max,length-prev);
    }
}
