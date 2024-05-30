package com.umair.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

    public static void main(String[] args) {
        UniqueEmailAddress unique = new UniqueEmailAddress();
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(unique.numUniqueEmails(emails));
    }

    public int numUniqueEmails(String[] emails) {

        Set<String> uniqueEmails = new HashSet<>();

        for(String str: emails){
            String email[]= str.split("@");
            String localName=email[0];
            String domainName=email[1];
            uniqueEmails.add(parseLocalname(localName)+"@"+domainName);

        }
        return uniqueEmails.size();
    }

    String parseLocalname(String str){

        StringBuilder result =new StringBuilder();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='+'){
                break;
            }
            else if(str.charAt(i)!='.'){
                result.append(str.charAt(i));
            }

        }

        return result.toString();
    }
}
