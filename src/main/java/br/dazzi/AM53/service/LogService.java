package br.dazzi.AM53.service;

import br.dazzi.AM53.domain.entity.Logs;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

public interface LogService {

    public Set<Logs> findAll();

    public Logs find(Long id);

    public void update(Logs log);

    public void remove(Logs id);

    public Logs add(Logs log);

    public void add(List<Logs> log);

    Set<Logs> listByIpAndDateBetweenStartAndEnd(ZonedDateTime startDate, ZonedDateTime endDate, String ip);
}
