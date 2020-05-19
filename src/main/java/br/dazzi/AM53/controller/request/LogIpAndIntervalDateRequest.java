package br.dazzi.AM53.controller.request;

import br.dazzi.AM53.settings.DateFomatter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class LogIpAndIntervalDateRequest {


    @JsonProperty(value = "start_date")
    @Pattern(regexp = "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}(?:.\\d{3}\\b)?)$", message = "Field start_date must be a date in format yyyy-MM-dd HH:mm:ss.SSS")
    private String start_date;

    @JsonProperty(value = "end_date")
    @Pattern(regexp = "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}(?:.\\d{3}\\b)?)$", message = "Field end_date must be a date in format yyyy-MM-dd HH:mm:ss.SSS")
    private String end_date;

    @JsonProperty(value = "ip")
    @Pattern(regexp = "^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$", message = "Field ip must be a Ipv4 format")
    private String ip;

    public ZonedDateTime getStartDate(){
        return LocalDateTime.parse(this.start_date(), DateFomatter.AM53_FORMATTER).atZone(ZoneId.systemDefault());
    }

    public ZonedDateTime getEndDate(){
        return LocalDateTime.parse(this.end_date(), DateFomatter.AM53_FORMATTER).atZone(ZoneId.systemDefault());
    }

}
