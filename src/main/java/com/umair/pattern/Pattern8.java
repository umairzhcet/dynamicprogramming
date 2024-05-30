package com.umair.pattern;

import java.util.Scanner;

public class Pattern8 {

    /*
                    *
                *
            *
        *
    *
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n-1;j++){
                System.out.print("\t");
            }
            System.out.print("*");
            System.out.println();
        }
    }
}
