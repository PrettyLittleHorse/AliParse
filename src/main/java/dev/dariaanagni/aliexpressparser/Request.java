package dev.dariaanagni.aliexpressparser;

import dev.dariaanagni.aliexpressparser.config.Constants;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class Request {
    public static String sendRequest(int numberOfPage) throws IOException {
        HttpGet request = new HttpGet(
                "https://gpsfront.aliexpress.com/getRecommendingResults.do?callback=jQuery18308863947305113146_1626186346841&widget_id=5547572&platform=pc&limit="
                        + Constants.LIMIT_FOR_PAGE_ELEMENTS
                        + "&offset="
                        + (numberOfPage * Constants.TEN_ELEMENTS_FROM_PAGE)
                        + "&phase=1&productIds2Top=&postback=41463c65-d80e-430e-9df9-41610cacd6f4&_=1626186"
        );
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            return EntityUtils.toString(entity);
        }
        return " ";
    }
}
