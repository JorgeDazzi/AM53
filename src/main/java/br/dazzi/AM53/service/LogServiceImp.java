package br.dazzi.AM53.service;

import br.dazzi.AM53.domain.entity.Logs;
import br.dazzi.AM53.domain.exception.NotFoundException;
import br.dazzi.AM53.repository.jpa.LogJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Service
public class LogServiceImp implements  LogService{

    @Autowired
    private LogJpaRepository logJpaRepository;

    @Override
    public Set<Logs> findAll() {
        return logJpaRepository.findAll();
    }

    @Override
    public Logs find(Long id) {
        Logs entity = logJpaRepository.find(id);
        if(entity == null){
            throw new NotFoundException("Log was not found");
        }
        return entity;
    }

    @Override
    public void update(Logs log) {
        Logs entity = logJpaRepository.find(log.getId());
        if(entity == null){
            throw new NotFoundException("Log was not found");
        }

        logJpaRepository.update(log);
    }

    @Override
    public void remove(Logs log) {
        if( logJpaRepository.find(log.getId()) == null){
            throw new NotFoundException("Log was not found or already gone");
        }
        logJpaRepository.remove(log);
    }

    @Override
    public Logs add(Logs log) {
        return logJpaRepository.add(log);
    }

    @Override
    public void add(List<Logs> logs) {
        logJpaRepository.add(logs);
    }

    @Override
    public Set<Logs> listByIpAndDateBetweenStartAndEnd(ZonedDateTime startDate, ZonedDateTime endDate, String ip) {
        return logJpaRepository.listByIpAndDateBetweenStartAndEnd(startDate, endDate, ip);
    }
}
