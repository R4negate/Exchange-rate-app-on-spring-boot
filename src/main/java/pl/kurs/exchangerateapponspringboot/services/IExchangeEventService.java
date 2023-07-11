package pl.kurs.exchangerateapponspringboot.services;

import pl.kurs.exchangerateapponspringboot.models.ExchangeEvent;

public interface IExchangeEventService {

    ExchangeEvent saveEvent(ExchangeEvent event);
}
