package com.umair.numbers;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PrimeFactors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder result = new StringBuilder();
        for(int i=2; i*i<=n;i++){
            while(n % i == 0){
                n = n/i;
                result.append(i+" ");
            }
        }

        if(n!=1){
            result.append(n);
        }

        System.out.println(result.toString());
    }


}
