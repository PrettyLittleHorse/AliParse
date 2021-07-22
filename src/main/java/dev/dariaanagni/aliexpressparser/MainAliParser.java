package dev.dariaanagni.aliexpressparser;

import dev.dariaanagni.aliexpressparser.config.Constants;
import dev.dariaanagni.aliexpressparser.config.Product;
import dev.dariaanagni.aliexpressparser.config.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainAliParser {
    private static final List<String> resultList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        MainAliParser.startParsing();
        Product.saveInCSV(resultList);
    }

    private static void startParsing() throws IOException {
        resultList.add(Constants.CSV_HEADER);

        for (int i = 0; i < Constants.PAGE_NUMBER; i++) {

            final String line = UrlConnection.sendRequest(i);
            final Result result = Result.cleanJson(line);

            if (result != null) {
                final List<Product> products = result.getResults();

                for (Product product : products) {
                    resultList.add(product.toString());
                }
            }
        }
    }
}
