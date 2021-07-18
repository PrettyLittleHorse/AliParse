package edu.aliexpressparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class AliParser {

    private String aliParserClassOutputString = "";
    private final URL url;

    public AliParser(String urlAli) throws Exception {
        url = new URL(urlAli);
    }

    public String parseUrl () throws IOException {
        URLConnection urlConnection = url.openConnection();

        InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            stringJoiner.add(line);
        }
        String str = String.valueOf(stringJoiner);

        Pattern productTitle = Pattern.compile("productTitle\":\"([\\s\\S]+?)\",");
        Pattern productDetailUrl = Pattern.compile("productDetailUrl\":\"//([\\s\\S]+?)\"?pdp");
        Pattern originalMinPrice = Pattern.compile("oriMinPrice\":\"([\\s\\S]+?)\",");
        Pattern minPrice = Pattern.compile("minPrice\":\"([\\s\\S]+?)\",");

        Matcher titleMather = productTitle.matcher(str);
        Matcher productUrlMatcher = productDetailUrl.matcher(str);
        Matcher originalMinPriceMatcher = originalMinPrice.matcher(str);
        Matcher minPriceMather = minPrice.matcher(str);

        StringJoiner stringJoin = new StringJoiner(System.lineSeparator());

        int i = 0;

        if (titleMather.find(i) && productUrlMatcher.find(i)&& originalMinPriceMatcher.find(i)&& minPriceMather.find(i)) {
            stringJoin.add("Title").add(titleMather.group(1));
            stringJoin.add("URL").add(productUrlMatcher.group(1));
            stringJoin.add("New minimal price").add(minPriceMather.group(1));
            stringJoin.add("Original minimal price").add(originalMinPriceMatcher.group(1));
            aliParserClassOutputString = String.valueOf(stringJoin);
        }

        inputStreamReader.close();
        bufferedReader.close();
        return aliParserClassOutputString;
    }
}
