package com.umair.dynamicprogramming.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TinyUrl {

    Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
      TinyUrl codec=new TinyUrl();
      String tinyUrl=codec.encode("https://leetcode.com/problems/design-tinyurl");
      System.out.println(tinyUrl);
      System.out.println(codec.decode(tinyUrl));
    }
    public String encode(String longUrl) {
        StringBuilder sb=new StringBuilder();
        sb.append("http://tinyurl.com/");

        for(int i=0;i<7;i++){
            int upperCase = (int)(Math.random()*(26)+65);
            int lowerCase = (int)(Math.random()*(26)+97);
            int digit = (int)((Math.random()*(10))+48);
            int[] ascii = {upperCase,digit,lowerCase};
            sb.append((char)(ascii[(int)(Math.random()*(3))]));
        }
        map.put(sb.toString(), longUrl);
        return sb.toString();
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

}
