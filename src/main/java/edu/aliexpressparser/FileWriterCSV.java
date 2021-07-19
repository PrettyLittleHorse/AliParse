package edu.aliexpressparser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterCSV {
    private final String fileName;
    private final List<String> resultList;

    public FileWriterCSV(String fileName, List<String> resultList) {
        this.fileName = fileName;
        this.resultList = resultList;
    }

    protected void writeToFile(int stringLimit) throws IOException {
        FileWriter writer = new FileWriter(fileName, true);
        for (int i = 0; i < stringLimit; i++) {
            writer.append(resultList.get(i));
        }
        writer.close();
    }
}
