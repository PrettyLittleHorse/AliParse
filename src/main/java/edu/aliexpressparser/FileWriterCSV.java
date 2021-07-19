package edu.aliexpressparser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterCSV {
    private final String fileName;
    private final List<String> results;

    public FileWriterCSV(String fileName, List<String> results){
        this.fileName = fileName;
        this.results = results;
    }

    protected void write() throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        for (String str : results) {
            writer.append(str);
        }
        writer.close();
    }




}
