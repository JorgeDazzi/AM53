package br.dazzi.AM53.repository;

import br.dazzi.AM53.domain.entity.Logs;

import java.time.ZonedDateTime;
import java.util.Set;

public interface LogRepository extends Repository<Logs> {

    Set<Logs> listByIpAndDateBetweenStartAndEnd(ZonedDateTime startDate, ZonedDateTime endDate, String ip);

}
