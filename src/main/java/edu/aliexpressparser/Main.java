package edu.aliexpressparser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int offset = 12;
    private static final List<String> resultList = new ArrayList<>();
    private static final String getRecommendationsFirstPartUrl = "https://gpsfront.aliexpress.com/getRecommendingResults.do?callback=jQuery18308863947305113146_1626186346841&widget_id=5547572&platform=pc&limit=12&offset=";
    private static final String getRecommendationsSecondPartUrl = "&phase=1&productIds2Top=&postback=41463c65-d80e-430e-9df9-41610cacd6f4&_=1626186";

    public static void main(String[] args) throws IOException {
        PatternSearch patternSearch = null;
        for (int j = 0; j <= 8; j++) {
            UrlConnection urlConnection = new UrlConnection(getRecommendationsFirstPartUrl + offset + getRecommendationsSecondPartUrl);
            AliReader aliReader = new AliReader(urlConnection.Openurl(),resultList);
            patternSearch = new PatternSearch(aliReader.results());
            offset += 12;
        }
        FileWriterCSV writerCSV = new FileWriterCSV("AliParseOutput.csv", patternSearch.getOutputList());
        writerCSV.writeToFile(100);
    }
}
