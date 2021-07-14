package edu.aliexpressparser;

import java.io.FileWriter;
import au.com.bytecode.opencsv.CSVWriter;

class CSVFileWriter {
    public  void createFile(String fileName, String[] data) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter(fileName,true));
        writer.writeNext(data);
        writer.close();
    }
}
