package dev.dariaanagni.aliexpressparser.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class Product {
    @SerializedName("minPrice")
    @Expose
    private String minPrice;

    @SerializedName("oriMinPrice")
    @Expose
    private String oriMinPrice;

    @SerializedName("productTitle")
    @Expose
    private String productTitle;

    @SerializedName("productAverageStar")
    @Expose
    private String productAverageStar;

    @SerializedName("orders")
    @Expose
    private String orders;

    @SerializedName("productImage")
    @Expose
    private String productImage;

    @SerializedName("productDetailUrl")
    @Expose
    private String productDetailUrl;

    @SerializedName("productId")
    @Expose
    private Long productId;

    @SerializedName("sellerId")
    @Expose
    private Long sellerId;

    @Override
    public String toString() {

        return
                "\""+minPrice + "\"," +
                        "\""+ oriMinPrice + "\"," +
                        "\""+ productTitle + "\"," +
                        "\""+ productAverageStar + "\"," +
                        "\""+ orders + "\"," +
                        "\""+ productImage + "\"," +
                        "\""+ productDetailUrl + "\"," +
                        "\""+ productId + "\"," +
                        "\""+ sellerId + "\",";
    }

    public static void saveInCSV(List<String> resultList) {
        File csvOutputFile = new File(Constants.CSV_OUTPUT_FILE_NAME);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            resultList.forEach(pw::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
