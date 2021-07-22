package dev.dariaanagni.aliexpressparser.config;

public final class Constants {
    public static final String CSV_OUTPUT_FILE_NAME = "AliParserOutput.csv";
    public static String DELETE_JQUERY_FRONT_STATEMENT = "/\\*\\*/jQuery.*\\w\\(";

    public static final int TEN_ELEMENTS_FROM_PAGE = 10;
    public static final int LIMIT_FOR_PAGE_ELEMENTS = 10;
    public static final int PAGE_NUMBER = 10;

    public static String CSV_HEADER =
            "\"Minimal price\"," +
                    "\"Original minimal price\"," +
                    "\"Product title\"," +
                    "\"Average stars\"," +
                    "\"Orders\"," +
                    "\"Image URL\"," +
                    "\"Product URL\"," +
                    "\"Product ID\"," +
                    "\"Seller ID\",";
}
