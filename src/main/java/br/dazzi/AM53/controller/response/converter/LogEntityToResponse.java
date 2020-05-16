package br.dazzi.AM53.controller.response.converter;

import br.dazzi.AM53.controller.response.LogResponse;
import br.dazzi.AM53.domain.entity.Logs;
import br.dazzi.AM53.settings.DateFomatter;

import java.util.ArrayList;
import java.util.List;

public class LogEntityToResponse {
    public LogResponse converter(Logs log){
        return new LogResponse()
                .id(log.getId())
                .date(log.getDate().format(DateFomatter.AM53_FORMATTER))
                .ip(log.getIp())
                .request(log.getRequest())
                .status(log.getStatus())
                .userAgent(log.getUserAgent());
    }

    public List<LogResponse> converter(List<Logs> logs){
        List<LogResponse> logResponses = new ArrayList<>();
        logs.forEach(log -> logResponses.add(
                new LogResponse()
                        .id(log.getId())
                        .date(log.getDate().format(DateFomatter.AM53_FORMATTER))
                        .ip(log.getIp())
                        .request(log.getRequest())
                        .status(log.getStatus())
                        .userAgent(log.getUserAgent())
        ));

        return logResponses;
    }
}
