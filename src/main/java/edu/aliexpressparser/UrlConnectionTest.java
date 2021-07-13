package edu.aliexpressparser;

import com.fasterxml.jackson.core.JsonPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLOutput;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlConnectionTest {

    public static void main(String[] args) throws IOException {

        String urlAdress = "https://gpsfront.aliexpress.com/getRecommendingResults.do?callback=jQuery18308390605486119002_1626180331779&widget_id=5547572&platform=pc&limit=100&offset=0&phase=1&productIds2Top=&postback=&_=1626180332079";
        URLConnection urlConnection = null;
        URL url = null;
        InputStreamReader isrR = null;
        BufferedReader bfR = null;

        url = new URL(urlAdress);
        urlConnection = url.openConnection();
        isrR = new InputStreamReader(urlConnection.getInputStream());
        bfR = new BufferedReader(isrR);
        String line;
        StringJoiner sj = new StringJoiner(System.lineSeparator());

        while ((line = bfR.readLine()) != null) {
            sj.add(line);
        }
        String str = String.valueOf(sj);
        Pattern productTitle = Pattern.compile("productTitle\":\"([\\s\\S]+?)\",");
        Pattern productDetailUrl = Pattern.compile("productDetailUrl\":\"//([\\s\\S]+?)\"?pdp");

        Pattern oriMinPrice = Pattern.compile("productTitle\":\"([\\s\\S]+?)\",");
        Pattern minPrice = Pattern.compile("productTitle\":\"([\\s\\S]+?)\",");

        Matcher titleMather = productTitle.matcher(str);
        Matcher productUrlMatcher = productDetailUrl.matcher(str);
        int i = 0;
        int j = 0;
        int k = 0;
        while (titleMather.find(i)) {
            j++;
            System.out.print(j + "| ");
            System.out.print("Title: " + titleMather.group(1) + " ");
            i = titleMather.start(1);

            while (productUrlMatcher.find(k)) {
                System.out.println("| Url: " + productUrlMatcher.group(1) + " ");
                k = productUrlMatcher.start(1);
                break;
            }

        }

        isrR.close();
        bfR.close();


    }
}
