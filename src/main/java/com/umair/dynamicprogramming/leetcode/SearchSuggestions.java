package com.umair.dynamicprogramming.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestions {

    public static void main(String[] args) {

        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> result=new ArrayList<>();
        Arrays.sort(products);

        int low=0;
        int high=products.length-1;
        for(int i=0;i<searchWord.length();i++){
            while(low<=high && (products[low].length()<=i
                    || products[low].charAt(i)!=searchWord.charAt(i))){
                low++;
            }
            while(low<=high && (products[high].length()<=i
                    || products[high].charAt(i)!=searchWord.charAt(i))){
                high--;
            }

            int min=Math.min(low+3,high+1);
            List<String> list=new ArrayList<>();
            for(int j=low;j<min;j++){
                list.add(products[j]);
            }
            result.add(list);
        }
        System.out.println(result);
    }
}
