package com.umair;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestDeclare  {




    public static void main(String[] args) throws IOException {

        int userId=2;
        int locationId=8;
        int netStart=5;
        int netEnd=50;
        String ENDPOINT="https://jsonmock.hackerrank.com/api/transactions/search?userId=";
        Gson gson = new Gson();
        List<Data> list;
        HttpURLConnection connection=null;

        try{
            URL url = new URL(ENDPOINT+userId);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            if (code==200)
            {
                String response="";
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer res = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    res.append(inputLine);
                }
                in.close();
                final UserTransactions userTransactions = gson.fromJson(res.toString(), UserTransactions.class);
                list=userTransactions.data;
                int noOfPages=Integer.parseInt(userTransactions.total_pages);
                if(noOfPages>1){
                    for(int i=2;i<=noOfPages;i++){
                        url = new URL(ENDPOINT+userId+"&page="+i);
                        connection = (HttpURLConnection)url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.connect();
                        code = connection.getResponseCode();
                        if(code==200){
                             in = new BufferedReader(
                                    new InputStreamReader(connection.getInputStream()));
                            res = new StringBuffer();
                            while ((inputLine = in.readLine()) != null) {
                                res.append(inputLine);
                            }
                            in.close();
                            final UserTransactions additionalData = gson.fromJson(res.toString(), UserTransactions.class);
                            list.addAll(additionalData.data);
                        }

                    }

                }

                Predicate<Data> locationPredicate=x -> locationId==Integer.parseInt(x.location.id);
                Predicate<Data> netStartPredicate=y -> Integer.parseInt(y.ip.split("\\.")[0])>=netStart;
                Predicate<Data> netEndPredicate=z -> Integer.parseInt(z.ip.split("\\.")[0])<=netEnd;

                List<Data> result=list.stream()
                        .filter(locationPredicate.and(netStartPredicate).and(netEndPredicate))
                        .collect(Collectors.toList());

                double amount=0;
                for(Data data:result){
                    amount+=parseAmount(data.amount);
                }
                int answer=(int) (amount+0.5);
                System.out.println(answer);
            }
            else{
                System.out.println(0);
            }
        }
        catch(Exception e){
            System.out.println(0);
        }
        finally{
            connection.disconnect();
        }

    }

    public static Double parseAmount(String amount){
        String result=amount.replaceAll(",", "");
        result=result.replaceAll("\\$","");
        return Double.parseDouble(result);
    }

}

class UserTransactions
{
    public String page;
    public String per_page;
    public String total_pages;
    public List<Data> data;
}

class Data
{
    public String id;
    public String timestamp;
    public String userId;
    public String userName;
    public String txnType;
    public String amount;
    public Location location;
    public String ip;
}

class Location
{
    public String id;
    public String address;
    public String city;
    public String zipCode;
}
