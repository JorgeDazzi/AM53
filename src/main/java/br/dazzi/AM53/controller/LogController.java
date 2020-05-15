package br.dazzi.AM53.controller;

import br.dazzi.AM53.domain.entity.Logs;
import br.dazzi.AM53.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("logs/")
@CrossOrigin(value = "*")
public class LogController {

    @Autowired
    LogService logService;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Set<Logs>> findAll(){
        return new ResponseEntity<>(logService.findAll(), HttpStatus.OK);
    }


    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<Logs> add(@RequestBody @Validated Logs log){
        return new ResponseEntity<>(logService.add(log), HttpStatus.CREATED);
    }

}
