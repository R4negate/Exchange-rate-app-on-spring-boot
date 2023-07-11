package pl.kurs.exchangerateapponspringboot.dao;

import org.springframework.stereotype.Repository;
import pl.kurs.exchangerateapponspringboot.models.ExchangeEvent;

import javax.persistence.*;
import javax.transaction.Transactional;

@Repository
@Transactional
public class JpaHibernateExchangeEventDao implements IExchangeEventDao {

    @PersistenceContext
    public EntityManager manager;

    @Override
    public ExchangeEvent insert(ExchangeEvent event) {
        manager.persist(event);
        return event;
    }
}
