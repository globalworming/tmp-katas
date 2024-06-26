package org.example.transaction;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToCsvTransformer {
    public static void write(String sourceFile, Path targetPath) throws IOException {
        assert sourceFile != null;


        FileInputStream file;
        try {
            file = new FileInputStream(sourceFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        List<List<Object>> values = new ArrayList<>();
        for (Row row: sheet) {
            List<Object> valueRow = new ArrayList<>();
            values.add(valueRow);

            for (Cell cell : row) {
                try {
                    valueRow.add(cell.getStringCellValue());
                } catch (IllegalStateException e) {
                    valueRow.add(cell.getNumericCellValue());
                }
            }
        }
        byte[] strToBytes = values.stream().map(row -> row.stream().map(it -> it.toString()).collect(Collectors.joining(","))).collect(Collectors.joining("\n")).getBytes();

        Files.write(targetPath, strToBytes);
    }
}
