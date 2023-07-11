package pl.kurs.exchangerateapponspringboot.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.kurs.exchangerateapponspringboot.exceptions.ConnectionProblemException;
import pl.kurs.exchangerateapponspringboot.exceptions.InvalidInputDataException;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Optional;

@Service
public class FastForexRateService implements IRateService {

    private final IUrlStringBuilder urlStringBuilder;
    private ObjectMapper objectMapper;

    public FastForexRateService(IUrlStringBuilder urlStringBuilder, ObjectMapper objectMapper) {
        this.urlStringBuilder = urlStringBuilder;
        this.objectMapper = objectMapper;
    }

    @Override
    public BigDecimal getRate(String fromCurrencyMark, String toCurrencyMark) throws InvalidInputDataException, ConnectionProblemException {
        String preparedUrl = urlStringBuilder.buildUrl(fromCurrencyMark);

        JsonNode mainNode = null;
        try {
            mainNode = objectMapper.readTree(new URL(preparedUrl));
        } catch (UnknownHostException e) {
            throw new ConnectionProblemException("Nie można połączyć się z serwerem", e);
        } catch (IOException e) {
            throw new InvalidInputDataException("Podano błędne dane", e);
        }
        JsonNode results = mainNode.get("results");
//        JsonNode rateNode = results.get(toCurrencyMark);
        JsonNode rateNode = Optional.ofNullable(results.get(toCurrencyMark)).orElseThrow(() -> new InvalidInputDataException("Nierozpoznana waluta!"));


        return rateNode.decimalValue();
    }
}
