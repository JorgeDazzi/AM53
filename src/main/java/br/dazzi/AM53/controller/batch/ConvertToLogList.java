package br.dazzi.AM53.controller.batch;


import br.dazzi.AM53.domain.entity.Logs;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ConvertToLogList {

    private String[] columns;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private String delimiter = "\\|";

    public ZonedDateTime getDate(){
        LocalDate d = LocalDate.parse(columns[0],formatter);
        return d.atStartOfDay(ZoneId.systemDefault());
    }

    public String getIp(){
        return columns[1];
    }

    public String getRequest(){
        return columns[2];
    }

    public int getStatus(){
        return Integer.parseInt(columns[3]);
    }

    public String getUserAgent(){
        return columns[4];
    }

    public Logs getLog(){
        return new Logs(
                this.getDate(),
                this.getIp(),
                this.getRequest(),
                this.getStatus(),
                this.getUserAgent()
        );
    }

    public boolean basicCheckUp(){
        return this.columns.length == 5;
    }

    public ConvertToLogList(String line) {
        this.columns = line.split(this.delimiter);
    }
}
