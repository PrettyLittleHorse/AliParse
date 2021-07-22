package dev.dariaanagni.aliexpressparser.config;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Result {
    private static final Pattern pattern = Pattern.compile(Constants.DELETE_JQUERY_FRONT_STATEMENT);
    private static final Gson gson = new Gson();

    @SerializedName("contextId")
    @Expose
    private String contextId;
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("code")
    @Expose
    private Long code;
    @SerializedName("results")
    @Expose
    private List<Product> results;
    @SerializedName("finished")
    @Expose
    private Boolean finished;
    @SerializedName("page")
    @Expose
    private Long page;
    @SerializedName("pageSize")
    @Expose
    private Long pageSize;
    @SerializedName("postback")
    @Expose
    private String postback;
    @SerializedName("pin")
    @Expose
    private String pin;

    public List<Product> getResults() {
        return results;
    }

    public static Result cleanJson(String onePage) {
        StringBuilder sb = new StringBuilder(onePage);
        sb.setLength(sb.length() - 2);
        final Matcher matcher = pattern.matcher(onePage);
        if (matcher.find()) {
            sb.replace(matcher.start(), matcher.end(), "");
            return gson.fromJson(sb.toString(), Result.class);
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return "MainModel{" +
                "contextId='" + contextId + '\'' +
                ", success=" + success +
                ", code=" + code +
                ", results=" + results +
                ", finished=" + finished +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", postback='" + postback + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }
}



