package br.dazzi.AM53.repository.jpa;

import br.dazzi.AM53.domain.entity.Logs;
import br.dazzi.AM53.repository.LogRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Repository
public class LogJpaRepository implements LogRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Set<Logs> listByIpAndDateBetweenStartAndEnd(ZonedDateTime startDate, ZonedDateTime endDate, String ip) {
        return Set.copyOf(
                entityManager.createQuery("select l from Logs l where l.ip = :ip and l.date between :start_date and :end_date", Logs.class)
                        .setParameter("ip", ip)
                        .setParameter("start_date", startDate)
                        .setParameter("end_date", endDate)
                .getResultList()
        );
    }

    @Override
    @Transactional
    public void add(List<Logs> logs) {
        logs.forEach(log -> entityManager.persist(log));
    }

    @Override
    @Transactional
    public Logs add(Logs entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public void update(Logs entity) {
        entityManager.merge(entity);
    }

    @Override
    @Transactional
    public void remove(Logs entity) {
        if (!entityManager.contains(entity)) {
            entity = entityManager.find(Logs.class, entity.getId());
        }
        entityManager.remove(entity);
    }

    @Override
    public Logs find(Long id) {
        return entityManager.find(Logs.class, id);
    }

    @Override
    public Set<Logs> findAll() {
        return Set.copyOf(
                entityManager
                        .createQuery("select l from Logs l where 1=1", Logs.class)
                        .getResultList()
        );
    }
}
