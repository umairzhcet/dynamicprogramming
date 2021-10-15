package com.umair.recursion;

import java.util.Arrays;

public class DecodeWays {

    static int[] cache;
    public static void main(String[] args) {

        String s="226";
        if(s.charAt(0)=='0'){
            System.out.println(0);
            return;
        }
        cache=new int[s.length()+1];
        Arrays.fill(cache,-1);
        System.out.println(solve(s,0));
    }

    public static int solve(String s, int i){

        if(i>=s.length()){
            return 1;
        }

        if(cache[i]!=-1)
            return cache[i];

        int result = s.charAt(i) == '0'? 0: solve(s, i+1);

        int check2digit=0;

        if(i+2<=s.length())
            check2digit=Integer.parseInt(s.substring(i,i+2));

        if(check2digit>=10 && check2digit<=26){
            result+=solve(s,i+2);
        }
        return cache[i]=result;
    }
}
