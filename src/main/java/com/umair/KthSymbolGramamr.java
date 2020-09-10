package com.umair;

public class KthSymbolGramamr {

    public static void main(String[] args) {
        int K=2;
        int N=2;
        System.out.println(recursiveSol(N,K));
    }

    private static int recursiveSol(int N, int K) {

        if(N==1){
            return 0;
        }

        int prev=recursiveSol(N-1,(K+1)/2);
        int mod=(K+1)%2;
        if(prev==0){
            if(mod==0){
                return 0;
            }
            else{
                return 1;
            }
        }
        else{
            if(mod==0){
                return 1;
            }
            else{
                return 0;
            }
        }


    }

}
