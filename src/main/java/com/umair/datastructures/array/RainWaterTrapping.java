package com.umair.datastructures.array;

public class RainWaterTrapping {

    public static void main(String[] args) {

        int heights[]={0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(new RainWaterTrapping().trap(heights));
    }


    //2 pointer approach with o(1) space and o(n) time complexity
    public int trap(int[] height) {

        int lMax = height[0];
        int rMax = height[height.length-1];
        int i =0;
        int j =height.length-1;
        int area =0;
        while(i<j){
            lMax =Math.max(lMax,height[i]);
            rMax =Math.max(rMax,height[j]);
            area+=(lMax<rMax)?lMax-height[i++]:rMax-height[j--];
        }

        return area;
    }

    public int trap2(int[] height) {

        //we see rain water trapped = Min of(left max, right max)- height

        //traversing from left, max element so far
        int lMax[]=new int[height.length];
        lMax[0]=height[0];

        for(int i=1;i<height.length-1;i++){
            lMax[i] =Math.max(lMax[i-1], height[i]);

        }

        //traversing from right, max element so far
        int rMax[]=new int[height.length];
        rMax[height.length-1]=height[height.length-1];

        for(int i=height.length-2;i>=0;i--){
            rMax[i] =Math.max(rMax[i+1], height[i]);

        }

        int area =0;

        for(int i=1;i<height.length-1;i++){

            area+=Math.min(lMax[i],rMax[i])-height[i];

        }

        return area;

    }
}
