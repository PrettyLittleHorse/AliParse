package dev.dariaanagni.aliexpressparser;

import dev.dariaanagni.aliexpressparser.entity.Product;
import dev.dariaanagni.aliexpressparser.entity.Result;
import dev.dariaanagni.aliexpressparser.util.ConverterStringListToCSV;
import dev.dariaanagni.aliexpressparser.util.JsonResultCleaner;
import dev.dariaanagni.aliexpressparser.util.RequestSender;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main implements ConverterStringListToCSV, RequestSender, JsonResultCleaner {

    private static final String CSV_OUTPUT_FILE_NAME = "AliParserOutput.csv";
    private static final String CSV_HEADER =
            "\"Minimal price\"," +
                    "\"Original minimal price\"," +
                    "\"Product title\"," +
                    "\"Average stars\"," +
                    "\"Orders\"," +
                    "\"Image URL\"," +
                    "\"Product URL\"," +
                    "\"Product ID\"," +
                    "\"Seller ID\",";

    private static final int LIMIT_FOR_PAGE_ELEMENTS = 10;
    private static final int ELEMENTS_FROM_PAGE = 10;

    private List<String> outputList;
    private Set<Long> additional;

    public static void main(String[] args) {
        Main main = new Main();
        main.parseAndSave();
    }

    private void parseAndSave() {
        outputList = new ArrayList<>();
        additional = new HashSet<>();
        outputList.add(CSV_HEADER);

        for (int j = 0; j < LIMIT_FOR_PAGE_ELEMENTS * ELEMENTS_FROM_PAGE; j++) {
            parse(j);
        }

        saveInCSV(outputList, CSV_OUTPUT_FILE_NAME);
    }

    private void parse(int step) {
        String line = getPageFromRequest(constructLink(step));
        Result result = cleanJson(line);

        if (result != null) {
            List<Product> products = result.getProductList();
            filter(products);
        }
    }

    private void filter(List<Product> elements) {
        for (Product product : elements) {
            if (!additional.contains(product.getProductId())) {
                outputList.add(product.toString());
                additional.add(product.getProductId());
            }

        }
    }

    private String constructLink(int pageNumber) {
        return "https://gpsfront.aliexpress.com/getRecommendingResults.do?callback=jQuery18308863947305113146_1626186346841&widget_id=5547572&platform=pc&limit="
                + LIMIT_FOR_PAGE_ELEMENTS
                + "&offset=" + (pageNumber * ELEMENTS_FROM_PAGE)
                + "&phase=1&productIds2Top=&postback=41463c65-d80e-430e-9df9-41610cacd6f4&_=1626186";
    }
}


