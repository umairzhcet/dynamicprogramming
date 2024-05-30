package com.umair.numbers;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder result = new StringBuilder();
        while(n!=0){
            result.append(n%10);
            n = n/10;
        }

        System.out.println(result.toString());
    }
}
