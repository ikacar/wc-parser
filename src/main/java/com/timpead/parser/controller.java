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
    @PostMapping("parse")
    public String parse(@RequestParam("file") MultipartFile file) {
        int number = 13800;
        if (file.isEmpty()) {
            return "prazan fajl";
        } else {

            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                CSVReader csvReader = new CSVReader(reader);

                // read one record at a time
                String[] record;
                CSVWriter writer = new CSVWriter(new FileWriter("./object-list-sample.csv"),CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.NO_ESCAPE_CHARACTER);

                while ((record = csvReader.readNext()) != null) {
                    String[] record2 = new String[47];

                    for(int i = 0; i<42;i++){
                        if(i==1){
                            record2[1]="variable";
                        }
                            record2[i]=record[i];
                    }

                        if(record[3].contains("ženska majica")){
                            record2[3]="\""+record[3]+"\"";
                            record2[26]="\""+record[26]+"\"";
                            record2[27]="\""+record[27]+"\"";
                            record2[43]="Veličina";
                            record2[44]="\"XS, S, M, L, XL\"";
                            record2[45]="1";
                            record2[46]="1";
                            if(record[29].contains(",")){
                                record2[29]="\""+record[29]+"\"";
                            }
                            writer.writeNext(record2);

                            String[] record3 = {String.valueOf(number++),"variation","","\""+record[3]+ " - XS\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","1","","","","","Veličina","XS","","1"};
                            String[] record4 = {String.valueOf(number++),"variation","","\""+record[3]+ " - S\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","2","","","","","Veličina","S","","1"};
                            String[] record5 = {String.valueOf(number++),"variation","","\""+record[3]+ " - M\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","3","","","","","Veličina","M","","1"};
                            String[] record6 = {String.valueOf(number++),"variation","","\""+record[3]+ " - L\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","4","","","","","Veličina","L","","1"};
                            String[] record7 = {String.valueOf(number++),"variation","","\""+record[3]+ " - XL\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","5","","","","","Veličina","XL","","1"};
                            writer.writeNext(record3);
                            writer.writeNext(record4);
                            writer.writeNext(record5);
                            writer.writeNext(record6);
                            writer.writeNext(record7);


                        }
                        else if(record[3].contains("duks")){
                            record2[43]="Veličina";
                            record2[44]="\"S, M, L, XL, XXL, XXXL\"";
                            record2[45]="1";
                            record2[46]="1";
                            record2[3]="\""+record[3]+"\"";
                            record2[26]="\""+record[26]+"\"";
                            record2[27]="\""+record[27]+"\"";
                            if(record[29].contains(",")){
                                record2[29]="\""+record[29]+"\"";
                            }
                            writer.writeNext(record2);

                            String[] record3 = {String.valueOf(number++),"variation","","\""+record[3]+ " - S\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","1","","","","","Veličina","S","","1"};
                            String[] record4 = {String.valueOf(number++),"variation","","\""+record[3]+ " - M\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","2","","","","","Veličina","M","","1"};
                            String[] record5 = {String.valueOf(number++),"variation","","\""+record[3]+ " - L\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","3","","","","","Veličina","L","","1"};
                            String[] record6 = {String.valueOf(number++),"variation","","\""+record[3]+ " - XL\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","4","","","","","Veličina","XL","","1"};
                            String[] record7 = {String.valueOf(number++),"variation","","\""+record[3]+ " - XXL\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","5","","","","","Veličina","XXL","","1"};
                            String[] record8 = {String.valueOf(number++),"variation","","\""+record[3]+ " - XXXL\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","6","","","","","Veličina","XXXL","","1"};
                            writer.writeNext(record3);
                            writer.writeNext(record4);
                            writer.writeNext(record5);
                            writer.writeNext(record6);
                            writer.writeNext(record7);
                            writer.writeNext(record8);
                        }
                        else{
                            record2[43]="Veličina";
                            record2[44]="\"S, M, L, XL, XXL, XXXL\"";
                            record2[45]="1";
                            record2[46]="1";
                            record2[3]="\""+record[3]+"\"";
                            record2[26]="\""+record[26]+"\"";
                            record2[27]="\""+record[27]+"\"";
                            if(record[29].contains(",")){
                                record2[29]="\""+record[29]+"\"";
                            }
                            writer.writeNext(record2);
                            String[] record3 = {String.valueOf(number++),"variation","","\""+record[3]+ " - S\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","1","","","","","Veličina","S","","1"};
                            String[] record4 = {String.valueOf(number++),"variation","","\""+record[3]+ " - M\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","2","","","","","Veličina","M","","1"};
                            String[] record5 = {String.valueOf(number++),"variation","","\""+record[3]+ " - L\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","3","","","","","Veličina","L","","1"};
                            String[] record6 = {String.valueOf(number++),"variation","","\""+record[3]+ " - XL\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","4","","","","","Veličina","XL","","1"};
                            String[] record7 = {String.valueOf(number++),"variation","","\""+record[3]+ " - XXL\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","5","","","","","Veličina","XXL","","1"};
                            String[] record8 = {String.valueOf(number++),"variation","","\""+record[3]+ " - XXXL\"","1","0","visible","","","","","taxable","parent","1","","","0","0","","","","","0","","",record[25],"","","","","","","id:"+record[0],"","","","","","6","","","","","Veličina","XXXL","","1"};
                            writer.writeNext(record3);
                            writer.writeNext(record4);
                            writer.writeNext(record5);
                            writer.writeNext(record6);
                            writer.writeNext(record7);
                            writer.writeNext(record8);
                        }




//                    if(record[3].contains("ženska majica"))
//                    {
//
//                        record[25]="";
//                        writer.writeNext(record);
//
//                    }
//                    System.out.println("ID: " + record[0]);
//                    System.out.println("Name: " + record[1]);
//                    System.out.println("Email: " + record[2]);
//                    System.out.println("Country: " + record[3]);
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
                ex.printStackTrace();
                return "greska";
            }
            return "ok";
        }


    }
}