package br.dazzi.AM53.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class LogRequest {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "date")
    @Pattern(regexp = "(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}(?:.\\d{3}\\b)?)$", message = "Field date must be a date in format yyyy-MM-dd HH:mm:ss.SSS")
    private String date;

    @JsonProperty(value = "ip")
    @Pattern(regexp = "^((25[0-5]|(2[0-4]|1[0-9]|[1-9]|)[0-9])(\\.(?!$)|$)){4}$", message = "Field ip must be a Ipv4 format")
    private String ip;

    @JsonProperty(value = "request")
    private String request;

    @JsonProperty(value = "status")
    private int status;

    @JsonProperty(value = "user_agent")
    @Size(max = 255, message = "Field user_agent must have between 1 and 255 characters.")
    private String userAgent;

}
