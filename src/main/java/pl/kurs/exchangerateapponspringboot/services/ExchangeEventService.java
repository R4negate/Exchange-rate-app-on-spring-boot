package pl.kurs.exchangerateapponspringboot.services;

import org.springframework.stereotype.Service;
import pl.kurs.exchangerateapponspringboot.dao.IExchangeEventDao;
import pl.kurs.exchangerateapponspringboot.models.ExchangeEvent;

import java.util.Objects;
import java.util.Optional;

@Service
public class ExchangeEventService implements IExchangeEventService{

    private IExchangeEventDao dao;

    public ExchangeEventService(IExchangeEventDao dao) {
        this.dao = dao;
    }

    @Override
    public ExchangeEvent saveEvent(ExchangeEvent event) {
        return dao.insert(
                Optional.ofNullable(event)
                        .filter(x -> Objects.isNull(x.getId()))
                .orElseThrow(() -> new RuntimeException("Bad object for save!"))
        );
    }
}
