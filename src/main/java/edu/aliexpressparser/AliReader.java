package edu.aliexpressparser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.util.List;

public class AliReader {
    private final List<String> resultList;
    private final URLConnection urlConnection;

    public AliReader(URLConnection urlConnection, List<String> resultList) {
        this.urlConnection = urlConnection;
        this.resultList = resultList;
    }

    protected List<String> results() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line = bufferedReader.readLine();
        resultList.add(line);
        return resultList;
    }

}
