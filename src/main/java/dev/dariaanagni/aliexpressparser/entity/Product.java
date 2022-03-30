package dev.dariaanagni.aliexpressparser.entity;

public class Product {

    private String minPrice;
    private String oriMinPrice;
    private String productTitle;
    private String productAverageStar;
    private String orders;
    private String productImage;
    private String productDetailUrl;
    private Long productId;
    private Long sellerId;

    public Long getProductId() {
        return productId;
    }

    @Override
    public String toString() {

        return
                "\"" + minPrice + "\"," +
                        "\"" + oriMinPrice + "\"," +
                        "\"" + productTitle + "\"," +
                        "\"" + productAverageStar + "\"," +
                        "\"" + orders + "\"," +
                        "\"" + productImage + "\"," +
                        "\"" + productDetailUrl + "\"," +
                        "\"" + productId + "\"," +
                        "\"" + sellerId + "\",";
    }
}
