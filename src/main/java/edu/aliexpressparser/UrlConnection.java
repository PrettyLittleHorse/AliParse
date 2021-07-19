package edu.aliexpressparser;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnection {
    private final String url;

    public UrlConnection(String url) {
        this.url = url;
    }

    protected URLConnection Openurl() throws IOException {
        URL url1 = new URL(url);
        return url1.openConnection();
    }
}
