package ru.kapion.exrobot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import ru.cbr.custom_model.EnumValuteData;
import ru.cbr.custom_model.ValuteData;
import ru.kapion.exrobot.models.ExchangeRates;
import ru.kapion.exrobot.repositories.ExchangeRatesRepository;
import ru.kapion.exrobot.utils.ws.CbrWrapper;

import javax.xml.datatype.DatatypeConfigurationException;
import java.time.LocalDate;
import java.util.*;

@Service
@PropertySource("classpath:/static/config.properties")
public class ExchangeRatesService {

    @Autowired
    private ExchangeRatesRepository exchangeRatesRepository;

    @Autowired
    private CbrWrapper cbrWrapper;

    private @Value("${orderValutes}") String orderValutes;

    public List<ExchangeRates> getAll() {
        return exchangeRatesRepository.findAll();
    }

    public List<ExchangeRates> getListRatesFromDB(LocalDate date){
        return exchangeRatesRepository.findByDate(date);
    }

    public List<ExchangeRates> getListRatesFromDB(LocalDate date, String chCode){
        return exchangeRatesRepository.findByDateAndChCode(date,chCode);
    }

    public List<ExchangeRates> getListRatesByDate(LocalDate date, boolean save) {
        // Запрос курсов перечня валют, который выполняет запрос к БД, и если не находит в БД на требуемую дату,
        // делает запрос к центробанку- возвращает клиенту json (и сохраняет в бд если не было)

        List<ExchangeRates> result = getListRatesFromDB(date);
        if (result == null || result.isEmpty()) {
            result = getListRatesByDate(date);
            if (result!= null && save) {
                exchangeRatesRepository.saveAll(result);
            }
        }

        if (result == null) {
            return Collections.emptyList();
        }

        return new ArrayList<ExchangeRates>(result);
    }

    public List<ExchangeRates> getListRatesByDate(LocalDate date) {
        try {
           List<ValuteData.ValuteCursOnDate> listValutes = cbrWrapper.getListRates(date);
            List<ExchangeRates> listExchangeRates = new ArrayList<>();

            //мапим в наш репозиторий
            listValutes.forEach(v -> {
                    ExchangeRates exRa = new ExchangeRates();
                    exRa.setCdate(date);
                    exRa.setChCode(v.getChCode());
                    exRa.setCode(v.getCode());
                    exRa.setCurs(v.getCurs());
                    exRa.setName(v.getName());
                    exRa.setNom(v.getNom());
                    listExchangeRates.add(exRa);
            });

            return listExchangeRates;
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();

    }

    public List<EnumValuteData.EnumValutes> getEnumValutes() {
       return cbrWrapper.getListValutes();
    }

    public List<EnumValuteData.EnumValutes> getSortedEnumValutes() {
        // Запрос справочника валют к центробанку и вывод его клиенту в формате json,
        // со следующей сортировкой: по VcharCode валюты в следующем порядке:
        // RUB, USD, EUR, CNY, потом все остальные, которые не указаны явно в алфавитном порядке .
        List<EnumValuteData.EnumValutes> enumValutesList = cbrWrapper.getListValutes();
        Map<String,EnumValuteData.EnumValutes> valutesMap = new HashMap<>();
        Map<String,EnumValuteData.EnumValutes> lostValutesMap = new HashMap<>();

        //String[] orderVal = new String[]{"RUB", "USD", "EUR"," CNY"};
        String[] orderVal = orderValutes.split(",");
        enumValutesList.forEach(e -> {
            if (e.getCharCode() != null) {
                valutesMap.put(e.getCharCode(), e);
            }
        });

        lostValutesMap.putAll(valutesMap);

        Set<String> sortedVal = new LinkedHashSet<>();
        for (String val: orderVal) {
            EnumValuteData.EnumValutes element = valutesMap.get(val);
            if (element != null) {
                sortedVal.add(val);
                //удаляем из списка отсортированные
                lostValutesMap.remove(val,element);
            }
        }

        //оставшиеся сортируем
        Set<String> sortedOtherEnum = new TreeSet<>();
        lostValutesMap.forEach((k,v)->sortedOtherEnum.add(k));

        //и ключи добавляем в конец
        sortedOtherEnum.forEach(s -> sortedVal.add(s));

        //список формируем заново
        enumValutesList.clear();
        sortedVal.forEach( v ->  enumValutesList.add(valutesMap.get(v)));

        return enumValutesList;
    }

}
