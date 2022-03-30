package dev.dariaanagni.aliexpressparser.util;

import com.google.gson.Gson;
import dev.dariaanagni.aliexpressparser.entity.Result;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface JsonResultCleaner {

    String JQUERY_FRONT_STATEMENT = "/\\*\\*/jQuery.*\\w\\(";
    int JQUERY_BACK_STATEMENT_INDENT = 2;

    Pattern pattern = Pattern.compile(JQUERY_FRONT_STATEMENT);
    Gson gson = new Gson();

    default Result cleanJson(String page) {
        StringBuilder stringBuilder = new StringBuilder(page);
        stringBuilder.setLength(stringBuilder.length() - JQUERY_BACK_STATEMENT_INDENT);
        final Matcher matcher = pattern.matcher(page);

        if (matcher.find()) {
            stringBuilder.replace(matcher.start(), matcher.end(), "");
            return gson.fromJson(stringBuilder.toString(), Result.class);
        } else {
            return null;
        }
    }


}
