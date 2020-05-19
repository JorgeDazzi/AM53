package br.dazzi.AM53.controller;

import br.dazzi.AM53.controller.batch.LogBatch;
import br.dazzi.AM53.domain.entity.Logs;
import br.dazzi.AM53.service.LogService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/batch/")
@CrossOrigin(value = "*")
public class BatchController {

    @Autowired
    LogService logService;

    @PostMapping(path = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiResponse(responseCode = "201")
    public @ResponseBody
    ResponseEntity<Object> batch(@RequestParam("file") MultipartFile filedate) throws IOException {

        List<Logs> logsList = new LogBatch(filedate.getInputStream()).getLogsList();
        logService.add(logsList);

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

}
