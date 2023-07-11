package pl.kurs.exchangerateapponspringboot.services;

import org.springframework.stereotype.Service;
import pl.kurs.exchangerateapponspringboot.config.AppConfig;

@Service
public class FastForexUrlStringBuilder implements IUrlStringBuilder {

    @Override
    public String buildUrl(String fromCurrencyMark) {
        StringBuffer sb = new StringBuffer();
        sb.append(AppConfig.FASTFOREX_API_PAGE);
        sb.append(AppConfig.ENDPOINT);
        sb.append(fromCurrencyMark);
        sb.append(AppConfig.API_KEY);

        return sb.toString();
    }
}
