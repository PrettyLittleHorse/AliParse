package dev.dariaanagni.aliexpressparser.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public interface ConverterStringListToCSV {

    default void saveInCSV(List<String> resultList, String fileName) {
        File file = new File(fileName);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            resultList.forEach(printWriter::println);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
