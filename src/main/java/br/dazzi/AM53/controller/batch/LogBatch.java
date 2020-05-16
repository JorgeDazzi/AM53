package br.dazzi.AM53.controller.batch;

import br.dazzi.AM53.domain.entity.Logs;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogBatch {

    private List<Logs> logsList = new ArrayList<>();
    private Scanner scanner;

    public List<Logs> getLogsList(){
        while(this.scanner.hasNext()){
            this.logsList.add(
                    new ConvertToLogList(this.scanner.nextLine())
                            .getLog()
            );
        }
        return this.logsList;
    }


    public LogBatch(InputStream file) {
        this.scanner = new Scanner(file);//Verificar fileReader
    }
}
