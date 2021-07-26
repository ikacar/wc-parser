package com.timpead.parser;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class RowOut {

    @CsvBindByName(column = "ID")
    @CsvBindByPosition(position = 0)
    private String ID;

    @CsvBindByName(column = "Name")
    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByName(column = "Tax status")
    @CsvBindByPosition(position = 2)
    private String taxStatus;

    public RowOut() {
    }
    public RowOut(Row row) {
        this.ID = row.getID();
        this.name = row.getName();
        this.taxStatus = row.getTaxStatus();
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxStatus() {
        return taxStatus;
    }

    public void setTaxStatus(String taxStatus) {
        this.taxStatus = taxStatus;
    }
}