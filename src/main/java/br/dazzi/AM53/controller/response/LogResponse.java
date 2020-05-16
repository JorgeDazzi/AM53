package br.dazzi.AM53.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
@NoArgsConstructor
public class LogResponse {

    @JsonProperty(value = "id")
    private Long id;
    @JsonProperty(value = "date")
    private String date;
    @JsonProperty(value = "ip")
    private String ip;
    @JsonProperty(value = "request")
    private String request;
    @JsonProperty(value = "status")
    private int status;
    @JsonProperty(value = "user_agent")
    private String userAgent;

}
