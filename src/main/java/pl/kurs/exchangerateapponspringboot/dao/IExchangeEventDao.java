package pl.kurs.exchangerateapponspringboot.dao;

import pl.kurs.exchangerateapponspringboot.models.ExchangeEvent;

public interface IExchangeEventDao {

    ExchangeEvent insert(ExchangeEvent event);

}
