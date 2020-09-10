package com.umair.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    static List<String> result=new ArrayList<>();

    public static void main(String[] args) {

        String S="a1b2";

        permute(S,"",0);
        System.out.println(result);

    }

    public static void permute(String input,String partial, int index){
        if(index==input.length()){
            result.add(partial);
            return;
        }
        String op1= input.substring(index,index+1);
        String op2=caseChange(op1);
        if(!op1.equals(op2)){
            permute(input,partial+op1,index+1);
            permute(input,partial+op2,index+1);
        }
        else{
            permute(input,partial+op1,index+1);
        }


    }

    public static String caseChange(String s){
        int c=s.charAt(0);
        if(c>=65 && c<=90){
            return s.toLowerCase();
        }
        else if(c>=97 && c<=122){
            return s.toUpperCase();

        }

        return s;
    }
}
