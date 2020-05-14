package br.dazzi.AM53.repository;

import br.dazzi.AM53.domain.entity.EntityDefault;

public interface Repository<E extends EntityDefault> {
    E add(E entity);

    void update(E entity);

    void remove(E entity);

    E find(Long id);

}
