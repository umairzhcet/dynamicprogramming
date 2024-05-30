package com.umair.numbers;

import java.util.Scanner;

public class InverseNumber {

    // inverse of  anumber means number if number  at ith digit = j, then number at jth digit = i
    // 15243 =>    4 2 1 3 5
    //
    //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        int cp = 1;

        while(n!=0){
            int ip = n% 10;
            result = result + cp *(int)Math.pow(10, ip-1);
            cp++;
            n= n/10;
        }

        System.out.println(result);
    }
}
