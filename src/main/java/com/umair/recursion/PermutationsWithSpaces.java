package com.umair.recursion;

import java.util.Locale;

public class PermutationsWithSpaces {

    public static void main(String[] args) {
        String s=new String("abc");
        permute(s,1,Character.toString(s.charAt(0)));

    }

    public static void permute(String s,int index,String partial){
        if(index==s.length()){
            System.out.print("("+partial+")");
            return;
        }
        String temp=Character.toString(s.charAt(index));
        permute(s,index+1,partial+temp);
        temp=" "+temp;
        permute(s,index+1,partial+temp);

    }
}
