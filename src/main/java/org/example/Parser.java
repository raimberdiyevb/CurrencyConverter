package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Parser {
    private Document getPage() throws IOException {
        String url = "https://www.x-rates.com/table/?from=USD&amount=1";
        return Jsoup.parse(new URL(url),2000);
    }
    public ArrayList<String> getCurrencyNames() throws IOException {
        Document page = getPage();
        Element table = page.select("table[class=ratesTable]").first();
        Object[] currencies =  table.select("tr").select("td[class!=rtRates]").toArray();
        ArrayList<String> namesArr = new ArrayList<>();
        for (Object o : currencies){
            namesArr.add(o.toString().replaceAll("<td>",""));
        }
        namesArr.replaceAll(s -> s.substring(0, s.length() - 5));
        return namesArr;
    }
    public ArrayList<Double> getUsdToCurrency() throws IOException {
        Document page = getPage();
        Element table = page.select("table[class=ratesTable]").first();
        String values = table.select("tr").select("td[class=rtRates]").text();
        String[] stringVal = values.split(" ");
        ArrayList<Double> usdToCurrency = new ArrayList<>();
        for( int i = 0; i < stringVal.length; i+=2){
            usdToCurrency.add(Double.parseDouble(stringVal[i]));
        }
        return usdToCurrency;
    }
    public ArrayList<Double> getCurrencyToUsd() throws IOException {
        Document page = getPage();
        Element table = page.select("table[class=ratesTable]").first();
        String values = table.select("tr").select("td[class=rtRates]").text();
        String[] stringVal = values.split(" ");
        ArrayList<Double> currencyToUsd = new ArrayList<>();
        for( int i = 0; i < stringVal.length; i+=2){
            currencyToUsd.add(Double.parseDouble(stringVal[i+1]));
        }
        return currencyToUsd;
    }

    public HashMap<String , String> getCurrencyShortNames() throws IOException {
        HashMap<String, String> result = new HashMap<>();
        result.put(getCurrencyNames().get(0),"EUR");
        result.put(getCurrencyNames().get(1),"GBR");
        result.put(getCurrencyNames().get(2),"INR");
        result.put(getCurrencyNames().get(3),"AUD");
        result.put(getCurrencyNames().get(4),"CAD");
        result.put(getCurrencyNames().get(5),"SGD");
        result.put(getCurrencyNames().get(6),"CHF");
        result.put(getCurrencyNames().get(7),"MYR");
        result.put(getCurrencyNames().get(8),"JPY");
        result.put(getCurrencyNames().get(9),"CNY");

        return result;
    }
}