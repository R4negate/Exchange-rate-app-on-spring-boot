package pl.kurs.exchangerateapponspringboot.services;



import pl.kurs.exchangerateapponspringboot.exceptions.ConnectionProblemException;
import pl.kurs.exchangerateapponspringboot.exceptions.InvalidInputDataException;

import java.math.BigDecimal;

public interface IRateService {

    BigDecimal getRate(String fromCurrencyMark, String toCurrencyMark) throws InvalidInputDataException, ConnectionProblemException;

}
