package pl.kurs.exchangerateapponspringboot.services;

import org.springframework.stereotype.Service;
import pl.kurs.exchangerateapponspringboot.exceptions.ConnectionProblemException;
import pl.kurs.exchangerateapponspringboot.exceptions.InvalidInputDataException;
import pl.kurs.exchangerateapponspringboot.models.ExchangeEvent;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;

@Service
public class CurrencyService implements ICurrencyService {

    private final IRateService rateService;
    private final IExchangeEventService exchangeEventService;

    public CurrencyService(IRateService rateService, IExchangeEventService exchangeEventService) {
        this.rateService = rateService;
        this.exchangeEventService = exchangeEventService;
    }

    @Override
    public BigDecimal exchange(String currencyFrom, String currencyTo, BigDecimal amount) throws InvalidInputDataException, ConnectionProblemException {
        if (amount.doubleValue() <= 0)
            throw new InvalidInputDataException("Ilosc powinna byc wieksza od 0");

        BigDecimal rate = rateService.getRate(currencyFrom, currencyTo);

        BigDecimal exchangeResult = rate.multiply(amount);


        exchangeEventService.saveEvent(
                new ExchangeEvent(
                        Timestamp.from(Instant.now()),
                        currencyFrom,
                        amount,
                        currencyTo,
                        exchangeResult,
                        rate
                )
        );
        return exchangeResult;
    }
}
