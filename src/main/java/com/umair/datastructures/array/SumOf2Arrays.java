package com.umair.datastructures.array;

public class SumOf2Arrays {

    public static void main(String[] args) {
        int[] n1 = {1,5,4,7,9};
        int[] n2 = {5,3,2,1,0};

        int[] result = new int[Math.max(n1.length,n2.length)];
        int i = n1.length-1;
        int j = n2.length-1;
        int k = result.length-1;
        int carry =0;
        while(k>-1){
            int d =0;
            if(i>-1){
               d =d+n1[i--] ;
            }
            if(j>-1){
                d =d+n2[j--] ;
            }
            d=d+ carry;
            result[k--]=d%10;
            carry = d/10;
        }
        if(carry!=0){
            System.out.print(carry);
        }
        for(int el:result)
            System.out.print(el);
    }
}
