package com.umair.datastructures.array;

public class DifferenceOf2Arrays {

    public static void main(String[] args) {
        int[] n2 = {4,9,4,7,9};
        int[] n1 = {5,3,2,1,0};
        //37731

        int[] result = new int[n1.length];
        int i = n1.length-1;
        int j = n2.length-1;
        int k = result.length-1;
        int carry =0;
        while(i>-1){
            int d2 =0;
            if(j>-1){
                d2 =n2[j--];
            }
            int d1= n1[i--]-carry;

            if(d1>=d2){
                result[k--]=d1-d2;
            }
            else{
                result[k--]=d1+10-d2;
                carry=1;
            }

        }
        for(int el:result)
            System.out.print(el);
    }
}
