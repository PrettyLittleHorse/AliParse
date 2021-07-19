package edu.aliexpressparser;

import java.io.IOException;

public class Main {
    private static int offset = 12;
    private static final String getRecommendationsFirstPartUrl =
            "https://gpsfront.aliexpress.com/getRecommendingResults.do?callback=jQuery18308863947305113146_1626186346841&widget_id=5547572&platform=pc&limit=12&offset=";
    private static final String getRecommendationsSecondPartUrl =
            "&phase=1&productIds2Top=&postback=41463c65-d80e-430e-9df9-41610cacd6f4&_=1626186";

    public static void main(String[] args) throws IOException {

        for (int j = 0; j < 9; j++) {
            UrlConnection connect = new UrlConnection(getRecommendationsFirstPartUrl + offset + getRecommendationsSecondPartUrl);
            AliReader reader = new AliReader(connect.Openurl());
            PatternSearch search = new PatternSearch(reader.results());
            FileWriterCSV writerCSV = new FileWriterCSV("AliParseOutput.csv", search.getResults());
            writerCSV.write();
            offset += 12;
        }
    }
}
