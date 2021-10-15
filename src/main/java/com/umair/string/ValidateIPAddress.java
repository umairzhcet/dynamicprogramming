package com.umair.string;

public class ValidateIPAddress {

    public static void main(String[] args) {
        ValidateIPAddress main=new ValidateIPAddress();
        System.out.println(main.validIPAddress("172.16.254.1"));
        System.out.println(main.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(main.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(main.validIPAddress("1e1.4.5.6"));
    }

    public String validIPAddress(String IP) {

        String[] ip4=IP.split("\\.",-1);
        String[] ip6=IP.split("\\:",-1);
        if(ip4.length!=4 && ip6.length!=8){
            return "Neither";
        }
        if(ip4.length==4){
            return validateIP4(ip4);
        }
        else{
            return validateIP6(ip6);
        }

    }

    public String validateIP4(String[] ips){
        for(String str:ips){
            int i;
            try {
                i = Integer.parseInt(str);
            }
            catch(Exception e) {
                return "Neither";
            }
            if(i<0 || i>255){
                return "Neither";
            }
            if(str.length()>1 && str.charAt(0)=='0'){
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String validateIP6(String[] ips){

        for(String str:ips){
            str=str.toLowerCase();
            if(str.length() <1 || str.length()>4){
                return "Neither";
            }
            for(int i=0;i<str.length();i++){
                if((str.charAt(i)-'0' >=0 && str.charAt(i)-'0' <=9)
                        || (str.charAt(i)-'a'>=0 && str.charAt(i)-'a' <=5)){
                    continue;
                }
                else{
                    return "Neither";
                }
            }
        }

        return "IPv6";
    }
}
