package br.dazzi.AM53.controller.request.converter;

import br.dazzi.AM53.controller.request.LogRequest;
import br.dazzi.AM53.domain.entity.Logs;
import br.dazzi.AM53.settings.DateFomatter;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class LogRequestToLogEntity {
    public Logs converter(LogRequest logRequest){
        return new Logs(
                logRequest.id(),
                logRequest.date() == null ? null : LocalDateTime.parse(logRequest.date(), DateFomatter.AM53_FORMATTER).atZone(ZoneId.systemDefault()),
                logRequest.ip(),
                logRequest.request(),
                logRequest.status(),
                logRequest.userAgent()
        );
    }
}
