package com.umair.datastructures.array;

public class TwoSumSorted {

    public static void main(String[] args) {

        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] result =new TwoSumSorted().twoSum(numbers,target);
        System.out.println(result[0]+ " "+result[1]);

    }

    public int[] twoSum(int[] numbers, int target) {

        int i =0;
        int j=numbers.length-1;

        while(i<j){

            int sum =numbers[i]+numbers[j];

            if(sum==target){
                return new int[]{i+1,j+1};
            }
            else if(sum<target){
                i++;
            }
            else{
                j--;
            }

        }

        return null;

    }
}
