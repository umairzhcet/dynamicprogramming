package com.umair;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KSortedArray {
    public static void main(String[] args) {


        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++){
            String ns=sc.next();
            int n=Integer.parseInt(ns);
            String ks=sc.next();
            int k=Integer.parseInt(ks);
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for(int j=0;j<n;j++){
                int num=sc.nextInt();
                queue.add(num);
                if(j>=k){
                    System.out.print(queue.poll()+" ");
                }

            }
            while(queue.isEmpty()){
                System.out.print(queue.poll()+" ");
            }

            System.out.println();

        }

    }
}
