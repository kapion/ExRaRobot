package ru.kapion.exrobot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.cbr.custom_model.EnumValuteData;
import ru.kapion.exrobot.models.ExchangeRates;
import ru.kapion.exrobot.services.ExchangeRatesService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class ExchangeRatesController {

    @Autowired
    private ExchangeRatesService service;

    @GetMapping("/all")
    public List<ExchangeRates> getAll() {
        return service.getAll();
    }

    @GetMapping("/now")
    public List<ExchangeRates> getNow() {
        return service.getListRatesByDate(LocalDate.now(),true);
    }

    @GetMapping("/fromdb")
    public List<ExchangeRates> getFromDB() {
        return service.getListRatesFromDB(LocalDate.now());
    }

    @GetMapping("/valutes")
    public List<EnumValuteData.EnumValutes> getSortedValutes() {
        return service.getSortedEnumValutes();
    }

    @GetMapping("/raw")
    public List<EnumValuteData.EnumValutes> getRaw() {
        return service.getEnumValutes();
    }
    ///valutes/dyn?from=2018-05-23&to=2018-05-25&code=USD
    @GetMapping("/valutes/dyn")
    public List<?> getDynamicCurs(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("code") String  chCode) {
        String error = null;
        try {
            LocalDate dateFrom = LocalDate.parse(from);
            LocalDate dateTo = LocalDate.parse(to);
            String code = service.getVcommonCodeFromVchCode(chCode);
            return service.getDynValuteCurs(dateFrom, dateTo, code);
        }catch (Exception e) {
            error = e.getMessage();
        }
        return Arrays.asList(error);
    }

    //valutes/2018/05/24?list=UAH,USD
    @GetMapping("/valutes/{year}/{month}/{day}")
    public List<?> getValutes(
            @PathVariable("year") String year,
            @PathVariable("month") String month,
            @PathVariable("day") String day,
            @RequestParam("list") String valutes ) {
        String error = null;
        try {
            LocalDate date = LocalDate.of(Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(day));

            List<ExchangeRates> result = service.getListRatesByDate(date, true);
            //фильтруем список
            if (valutes!=null && !valutes.isEmpty()){
                List<ExchangeRates> newResult = new ArrayList<>();
                result.forEach(r->{
                    if (valutes.contains(r.getChCode())) {
                        newResult.add(r);
                    }
                });
                result = newResult;
            }
            return result;
        }catch (Exception e) {
            error = e.getMessage();
        }
        return Arrays.asList(error);
    }
}
