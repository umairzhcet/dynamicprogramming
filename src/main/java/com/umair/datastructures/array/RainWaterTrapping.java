package com.umair.datastructures.array;

public class RainWaterTrapping {

    public static void main(String[] args) {

        int heights[]={0,1,0,2,1,0,1,3,2,1,2,1};
        int[] lmax=new int[heights.length];

        lmax[0]=heights[0];

        for(int i=1;i<heights.length;i++){
            lmax[i]=Math.max(lmax[i-1],heights[i]);
        }

        int[] rmax=new int[heights.length];

        lmax[heights.length-1]=heights[heights.length-1];

        for(int i=heights.length-2;i>=0;i--){
            lmax[i]=Math.max(lmax[i+1],heights[i]);
        }
        int area=0;

        for(int i=0;i<heights.length;i++){
            area+=Math.min(lmax[i],rmax[i])-heights[i];

        }

        System.out.println(area);
        System.out.print("");;
    }
}
