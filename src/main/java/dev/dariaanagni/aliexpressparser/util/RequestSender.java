package dev.dariaanagni.aliexpressparser.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public interface RequestSender {

    default String getPageFromRequest(String httpGet) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(new HttpGet(httpGet))) {

            HttpEntity entity = response.getEntity();

            if (entity == null) {
                return "";
            }
            return EntityUtils.toString(entity);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
