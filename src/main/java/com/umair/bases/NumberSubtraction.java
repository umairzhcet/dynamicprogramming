package com.umair.bases;

import java.util.Scanner;
/*
1212 236 8
754
*/


public class NumberSubtraction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //assuming n1 is bigger number
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int b = sc.nextInt();

        int result = 0;
        int pow = 1;
        int carry = 0;

        while(n2!=0){
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 = n1/10;
            n2 = n2/10;
            int d = 0;
            d1= d1 + carry;
            if(d1>=d2){
                d = d1-d2;
                carry = 0;
            }
            else{
                d = d1+b-d2;
                carry= -1;
            }
            result+= d*pow;
            pow*=10;


        }
        System.out.println(result);
    }
}
