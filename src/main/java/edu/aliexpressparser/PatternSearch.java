package edu.aliexpressparser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternSearch {
    private final List<String> resultList;
    private final List<String> outputParsedList = new ArrayList<>();

    public PatternSearch(List<String> resultList) {
        this.resultList = resultList;
    }

    protected List<String> getOutputList() {
        String str = String.valueOf(resultList);

        Pattern productTitle = Pattern.compile("\"productTitle\":\"([\\s\\S]+?)\",");
        Matcher titleMather = productTitle.matcher(str);

        Pattern productDetailUrl = Pattern.compile("productDetailUrl\":\"//([\\s\\S]+?)\"?pdp");
        Matcher productUrlMatcher = productDetailUrl.matcher(str);

        Pattern originalMinPrice = Pattern.compile("oriMinPrice\":\"([\\s\\S]+?)\",");
        Matcher originalMinPriceMatcher = originalMinPrice.matcher(str);

        Pattern minPrice = Pattern.compile("minPrice\":\"([\\s\\S]+?)\",");
        Matcher minPriceMather = minPrice.matcher(str);

        while (titleMather.find() && productUrlMatcher.find() && originalMinPriceMatcher.find() && minPriceMather.find()) {
            outputParsedList.add("Title:,\"" + titleMather.group(1)
                    + "\",URL:,\"" + productUrlMatcher.group(1)
                    + "\",New minimal price:,\"" + minPriceMather.group(1)
                    + "\",Original minimal price:,\"" + originalMinPriceMatcher.group(1)
                    + "\"\n");
        }
        return outputParsedList;
    }
}
