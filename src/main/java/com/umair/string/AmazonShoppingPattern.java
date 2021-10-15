package com.umair.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonShoppingPattern {

    public static void main(String[] args) {
        List<String> codes= Arrays.asList("apple apple","banana anything banana");
        List<String> shoppingCart=Arrays.asList("orange","apple","apple","banana","orange","banana");
        AmazonShoppingPattern main=new AmazonShoppingPattern();
        System.out.println(main.foo(codes,shoppingCart));
    }

    public  int foo(List<String> codes, List<String> shoppingCart) {
        // Write your code here

        if(codes==null || codes.size()==0)
            return 1;

        List<List<String>> codeList=new ArrayList();
        for(int i=0;i<codes.size();i++){
            List<String> temp=new ArrayList<>(Arrays.asList(codes.get(i).split(" ")));
            codeList.add(temp);
        }

        int codeIndex=0;
        int cartindex=0;

        while(codeIndex<codeList.size() && cartindex<shoppingCart.size()){
            //System.out.println("codeIndex:"+codeIndex+" CartIndex:"+cartindex);
            List<String> code=codeList.get(codeIndex);
            if(code.size()==0) return 1;
            int codeItem=0;
            while(codeItem<code.size() && cartindex<shoppingCart.size() ){
                if(code.get(codeItem).equals("anything")
                        || code.get(codeItem).equals(shoppingCart.get(cartindex))){
                    codeItem++;
                    cartindex++;
                }
                else{
                    cartindex++;
                    codeItem=0;
                }
                if(cartindex==shoppingCart.size() && codeItem==code.size()){
                    return 1;
                }
            }
            codeIndex++;

        }

        return 0;
    }
}
