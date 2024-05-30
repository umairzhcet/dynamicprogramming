package com.umair.numbers;

import java.util.Scanner;
import java.util.concurrent.SynchronousQueue;

public class DigitsOfNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nod = 0;
        int temp = n;

        while(temp!= 0){
            temp = temp/10;
            nod++;
        }

        int div = (int)Math.pow(10, nod-1);
        StringBuilder result = new StringBuilder();

        while(div!=0){
                result.append(n/div).append(" ");
                n = n % div;
                div = div/10;
        }

        System.out.println(result.toString());

    }

}
