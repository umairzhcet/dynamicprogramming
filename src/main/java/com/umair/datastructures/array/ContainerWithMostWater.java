package com.umair.datastructures.array;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(new ContainerWithMostWater().maxArea(height));


    }

    public int maxArea(int[] height) {

        int i =0;
        int j=height.length-1;
        int maxArea=0;

        while(i<j){

            int area =(j-i)* Math.min(height[i],height[j]);

            maxArea = Math.max(maxArea,area);

            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }

        return maxArea;

    }
}
