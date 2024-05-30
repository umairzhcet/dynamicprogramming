package com.umair.datastructures.stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    static List<String> result;

    public static void main(String[] args) {
        result = new GenerateParanthesis().generateParenthesis(2);
        System.out.println(result);

    }
    public List<String> generateParenthesis(int n) {

        result =new ArrayList<>();

        generate(n,0,0,"");

       return result;

    }

    private void generate(int n,int l,int r,String partial){
        if(l==r && r==n){
            result.add(partial);
            return;
        }
        if(l<r || l>n || r>=n){
            return;
        }

        generate(n,l+1,0,partial+"(");


        if(l>r){
            generate(n,l,r+1,partial+")");
        }

    }
}
