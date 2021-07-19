package edu.aliexpressparser;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnection {
    private final String urlString;

    public UrlConnection(String urlString) {
        this.urlString = urlString;
    }

    protected URLConnection Openurl() throws IOException {
        URL url1 = new URL(urlString);
        return url1.openConnection();
    }
}
