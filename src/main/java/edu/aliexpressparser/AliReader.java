package edu.aliexpressparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class AliReader {
    private final List<String> results = new ArrayList<>();
    private final URLConnection urlConnection;

    public AliReader(URLConnection urlConnection) {
        this.urlConnection = urlConnection;
    }

    protected List<String> results() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        results.add(line);
        return results;
    }

}
