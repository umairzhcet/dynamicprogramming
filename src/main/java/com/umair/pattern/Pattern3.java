package com.umair.pattern;

import java.util.Scanner;

public class Pattern3 {

    /*
                    *
                *   *
            *   *   *
        *   *   *   *
    *   *   *   *   *

    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=n;j>=1;j--){
                if(j>i){
                    System.out.print("\t");
                }
                else{
                     System.out.print("*\t");
                }
            }
            System.out.println();
        }
    }
}
