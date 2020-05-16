package br.dazzi.AM53.controller;

import br.dazzi.AM53.controller.request.LogRequest;
import br.dazzi.AM53.controller.request.converter.LogRequestToLogEntity;
import br.dazzi.AM53.controller.response.LogResponse;
import br.dazzi.AM53.controller.response.converter.LogEntityToResponse;
import br.dazzi.AM53.domain.entity.Logs;
import br.dazzi.AM53.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("logs/")
@CrossOrigin(value = "*")
public class LogController {

    @Autowired
    LogService logService;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<LogResponse>> findAll(){

        return new ResponseEntity<>(
                new LogEntityToResponse()
                        .converter(
                                List.copyOf(logService.findAll())
                        ),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<LogResponse> find(@PathVariable Long id){

        return new ResponseEntity<>(
                new LogEntityToResponse().converter(logService.find(id)),
                HttpStatus.OK
        );
    }


    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<LogResponse> add(@RequestBody @Validated LogRequest logRequest){

        return new ResponseEntity<>(
                new LogEntityToResponse()
                        .converter(logService.add(new LogRequestToLogEntity().converter(logRequest))),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/{id}" )
    public @ResponseBody ResponseEntity<Object> remove(@PathVariable Long id){
        logService.remove(logService.find(id));
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> update(@RequestBody @Validated LogRequest logRequest){
        logService.update(new LogRequestToLogEntity().converter(logRequest));
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
