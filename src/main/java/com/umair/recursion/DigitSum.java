package com.umair.recursion;

public class DigitSum {

    public static void main(String[] args) {
        int num=1245;
        int result=findSum(num);
        System.out.println(result);
    }

    private static int findSum(int num) {

        if(num==0){
            return 0;
        }

        int digit=num%10;
        return digit+findSum(num/10);
    }
}
