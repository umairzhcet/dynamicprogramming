package com.umair.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {

    public static void main(String[] args) {

        List<String> list = Arrays.asList(new String[]{"lint", "code", "love", "you"});
        String encode = new EncodeDecode().encode(list);
        System.out.println(encode);
        List<String> decoded= new EncodeDecode().decode(encode);
        System.out.println(decoded);

    }

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str.length()+"#"+str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> list = new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            i=j+1+Integer.valueOf(str.substring(i, j));
            list.add(str.substring(j+1,i));
        }

        return list;
    }
}
