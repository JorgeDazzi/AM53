package br.dazzi.AM53.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@MappedSuperclass
public class EntityDefault {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private ZonedDateTime date;

    @PostPersist
    public void PostPersistDate(){
        if(this.date == null) this.setDate(ZonedDateTime.now(ZoneId.systemDefault()));
    }
}
