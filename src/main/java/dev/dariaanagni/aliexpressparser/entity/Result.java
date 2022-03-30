package dev.dariaanagni.aliexpressparser.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    private String contextId;
    private Boolean success;
    private Long code;

    @SerializedName("results")
    private List<Product> products;

    private Boolean finished;
    private Long page;
    private Long pageSize;
    private String postback;
    private String pin;

    public List<Product> getProductList() {
        return products;
    }

    @Override
    public String toString() {
        return "MainModel{" +
                "contextId='" + contextId + '\'' +
                ", success=" + success +
                ", code=" + code +
                ", results=" + products +
                ", finished=" + finished +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", postback='" + postback + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}



