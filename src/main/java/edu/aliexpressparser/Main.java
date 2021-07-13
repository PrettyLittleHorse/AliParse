package edu.aliexpressparser;

public class Main {

    private static String savedDataFromAliParser = "";
    private static final String getRecommendationsFirstPartUrl = "https://gpsfront.aliexpress.com/getRecommendingResults.do?callback=jQuery18308863947305113146_1626186346841&widget_id=5547572&platform=pc&limit=12&offset=";
    private static final String getRecommendationsSecondPartUrl = "&phase=1&productIds2Top=&postback=41463c65-d80e-430e-9df9-41610cacd6f4&_=1626186";

    public static void main(String[] args) {

        CSVFileWriter csvFileWriter = new CSVFileWriter();

        int offset = 0;
        try {
            for (int i = 1; i <= 9; i++) {
                new AliParser(getRecommendationsFirstPartUrl + offset + getRecommendationsSecondPartUrl);
                savedDataFromAliParser += AliParser.dataFromAliParser;
                offset += 12;
            }

            String[] outputForCSVArray = savedDataFromAliParser.split("\r\n");
            csvFileWriter.createFile("AliParserOutput.csv", outputForCSVArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
