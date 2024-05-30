package com.umair.bases;

import java.util.Scanner;
/*
236 754 8
1212
*/


public class NumberAddition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int b = sc.nextInt();

        int result = 0;
        int pow = 1;
        int carry = 0;

        while(n1!=0 || n2!=0 || carry!=0){
            int d1 = n1 % 10;
            int d2 = n2 % 10;
            n1 = n1/10;
            n2 = n2/10;
            int d = d1+d2+carry;
            carry = d/b;
            d = d % b;
            result+= d*pow;
            pow*=10;

        }
        System.out.println(result);
    }
}
