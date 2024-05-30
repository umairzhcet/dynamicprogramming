package com.umair.pattern;

import java.util.Scanner;

public class Pattern11 {

    /*
1
2   3
4   5   6
7   8   9   10
11  12  13  14  15


     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int no =1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(no++ +"\t");
            }
            System.out.println();
        }
    }
}
