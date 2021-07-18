package edu.aliexpressparser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternSearch {
    private final List<String> results;
    private final List<String> outputs = new ArrayList<>();

    public PatternSearch(List<String> results) {
        this.results = results;
    }

    protected List<String> getResults() {
        String str = String.valueOf(results);

        Pattern productTitle = Pattern.compile("\"productTitle\":\"([\\s\\S]+?)\",");
        Matcher titleMather = productTitle.matcher(str);

        Pattern productDetailUrl = Pattern.compile("productDetailUrl\":\"//([\\s\\S]+?)\"?pdp");
        Matcher productUrlMatcher = productDetailUrl.matcher(str);

        Pattern originalMinPrice = Pattern.compile("oriMinPrice\":\"([\\s\\S]+?)\",");
        Matcher originalMinPriceMatcher = originalMinPrice.matcher(str);

        Pattern minPrice = Pattern.compile("minPrice\":\"([\\s\\S]+?)\",");
        Matcher minPriceMather = minPrice.matcher(str);

        while (titleMather.find() && productUrlMatcher.find() && originalMinPriceMatcher.find() && minPriceMather.find()) {
            outputs.add("Title:");
            outputs.add(",\"" + titleMather.group(1) + "\"");
            outputs.add(",URL:");
            outputs.add(",\"" + productUrlMatcher.group(1) + "\"");
            outputs.add(",New minimal price:");
            outputs.add(",\"" + minPriceMather.group(1) + "\"");
            outputs.add(",Original minimal price:");
            outputs.add(",\"" + originalMinPriceMatcher.group(1) + "\"");
            outputs.add("\n");
        }
        return outputs;
    }
}
