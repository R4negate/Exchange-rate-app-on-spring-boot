package pl.kurs.exchangerateapponspringboot.services;

import pl.kurs.exchangerateapponspringboot.exceptions.ConnectionProblemException;
import pl.kurs.exchangerateapponspringboot.exceptions.InvalidInputDataException;

import java.math.BigDecimal;

public interface ICurrencyService {

    BigDecimal exchange(String currencyFrom, String currencyTo, BigDecimal amount) throws InvalidInputDataException, ConnectionProblemException;
}
