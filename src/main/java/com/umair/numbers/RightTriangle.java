package com.umair.numbers;

import java.util.Scanner;

public class RightTriangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int max = a>=b?a:b;
        max = c >=max?c:max;

        if(a*a + b*b + c*c - max*max==max*max){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }

    }
}
