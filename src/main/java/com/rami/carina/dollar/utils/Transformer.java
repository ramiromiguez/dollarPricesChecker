package com.rami.carina.dollar.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transformer {
    public Transformer() {
    }

    // xls->4/20/2018 -> 20/04/2018
    public String dateConvert(String date) throws ParseException {
        StringBuilder formatDate = new StringBuilder(date);
        int i = 0;
        for(i=0;i<formatDate.length();i++){
            if(formatDate.charAt(i) == '/'){
                formatDate.setCharAt(i, '-');
            }
        }
        SimpleDateFormat in = new SimpleDateFormat("MM-dd-yyyy");
        Date inDate = in.parse(String.valueOf(formatDate)); // 05-19-1990
        SimpleDateFormat out = new SimpleDateFormat("dd-MM-yyyy");
        String newDate = out.format(inDate);
        return newDate;
    }

    public String buyerConvert(String buyer){
        String dataTransformed = buyerSellerConvert(buyer);
        return dataTransformed;
    }

    public String sellerConvert(String seller){
        String dataTransformed = buyerSellerConvert(seller);
        return dataTransformed;
    }

    private String buyerSellerConvert(String data){
        StringBuilder formatData = new StringBuilder(data);
        int i = 0;
        for(i=0;i<formatData.length();i++){
            if(formatData.charAt(i) == '.'){
                formatData.setCharAt(i, ',');
            }
        }
        String dataFormated = String.valueOf(formatData);
        return dataFormated;
    }


}
