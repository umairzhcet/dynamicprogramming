package com.umair.bases;

import java.util.Scanner;
/*
1212 236 8
754
*/


public class NumberMultiplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //assuming n1 is bigger number
        int n = sc.nextInt();
        int mult = sc.nextInt();
        int b = sc.nextInt();

        int result = 0;
        int pow = 1;
        int carry = 0;

        while(mult!=0) {
            int d2 = mult%10;
            mult = mult/10;

            int prodsd =  getProductWithSingleDigit(b,n,d2)  ;

            result= addNumbers(b,prodsd*pow,result);
            pow*=10;


        }

        

        System.out.println(result);
    }

    public static int addNumbers(int base, int n1, int n2){

        int carry = 0;
        int pow = 1;
        int result =0;
        while(n1 !=0 || n2!=0 || carry!=0){
            int d1 = n1%10;
            int d2 = n2%10;
            n1=n1/10;
            n2=n2/10;

            int d= d1+d2+carry;
            carry= d/base;
            d = d % base;

            result+=d*pow;
            pow*=10;

        }

        return result;

    }

    public static int getProductWithSingleDigit(int base, int n, int d2)  {
            int carry = 0;
            int pow = 1;
            int result = 0;

            while(n!=0 || carry!=0){
                int d1 = n%10;
                n=n/10;

                int prod = d1 * d2  + carry;
                int d= prod %base;
                carry = prod/base;
                result+= d*pow;
                pow*=10;

            }

        return result;

    }
}
