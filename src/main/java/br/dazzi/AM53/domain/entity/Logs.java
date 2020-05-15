package br.dazzi.AM53.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Logs extends EntityDefault{

    @NotNull
    private String ip;

    private String request;

    @NotNull
    private int status;

    @Column(name = "user_agent")
    private String userAgent;

    public Logs(ZonedDateTime date, @NotNull String ip, String request, @NotNull int status, String userAgent) {
        this.setDate(date);
        this.ip = ip;
        this.request = request;
        this.status = status;
        this.userAgent = userAgent;
    }

    public Logs(@NotNull String ip, String request, @NotNull int status, String userAgent) {
        this.setDate(null);
        this.ip = ip;
        this.request = request;
        this.status = status;
        this.userAgent = userAgent;
        //https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/format/DateTimeFormatter.html
    }
}
