package com.timpead.parser;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
public class controller {
    final String[] CSV_HEADER = { "ID", "ime", "Tax Status"};
    @PostMapping("parse")
    public String parse(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "prazan fajl";
        } else {

            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                CSVReader csvReader = new CSVReader(reader);

                // read one record at a time
                String[] record;
                CSVWriter writer = new CSVWriter(new FileWriter("./object-list-sample.csv"));

                while ((record = csvReader.readNext()) != null) {
                    if(record[1].toString().equals("sample"))
                    {
                        record[1]="variable";
                        record[25]="";
                        writer.writeNext(record);

                    }
                    System.out.println("ID: " + record[0]);
                    System.out.println("Name: " + record[1]);
                    System.out.println("Email: " + record[2]);
                    System.out.println("Country: " + record[3]);
                }

                // close readersx

                csvReader.close();
                writer.close();

                reader.close();
                // create csv bean reader
//                CsvToBean<Row> csvToBean = new CsvToBeanBuilder(reader)
//                        .withType(Row.class)
//                        .withIgnoreLeadingWhiteSpace(true)
//                        .withThrowExceptions(false)
//                        .build();
//
//                List<Row> rowList = csvToBean.parse();
//                List<RowOut> rowOutList = new ArrayList<>();
//
//                for (Row row : rowList) {
//                    System.out.println("id: " + row.getID());
//                    System.out.println("name: " + row.getName());
//                    System.out.println("tax: " + row.getTaxStatus());
//                    System.out.println("***************************");
//                    rowOutList.add(new RowOut(row));
//                }
//
//                Writer writer = Files.newBufferedWriter(Paths.get("./object-list-sample.csv"));
//                StatefulBeanToCsv<RowOut> beanToCsv = new StatefulBeanToCsvBuilder(writer)
//                        .withThrowExceptions(false)
////                        .withQuotechar(CSVWriter.DEFAULT_SEPARATOR)
//                        .build();
//                beanToCsv.write(rowOutList);
            } catch (Exception ex) {
                return "greska";
            }
            return "ok";
        }


    }
}