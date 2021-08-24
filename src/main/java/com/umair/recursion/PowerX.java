package com.umair.recursion;

public class PowerX {

    public static void main(String[] args) {

        int x=2;
        int n=10;

        double result= recursive(x,n);
        if(n<1){
            System.out.println(1/result);
        }
        else{
            System.out.println(result);
        }
    }

    public static double recursive(double x, int n){
        if(n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        if(n%2==0){
            return recursive(x*x,n/2);
        }
        else{
            return x* recursive(x*x,n/2);
        }
    }
}
