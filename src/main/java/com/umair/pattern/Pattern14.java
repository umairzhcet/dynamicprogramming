package com.umair.pattern;

import java.util.Scanner;

public class Pattern14 {

    /*
x * 1 = x
x * 2 = 2x
x * 3 = 3x
x * 4 = 4x

nC(k+1) = nCk *(n-k)/(k+1)
*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for(int i=1;i<=10;i++){
           int val = x *i;
            System.out.println(x +" * "+i+" = "+val);
        }
    }
}
