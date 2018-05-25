package ru.kapion.exrobot.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.kapion.exrobot.services.ExchangeRatesService;

import java.time.LocalDate;

@Component
public class Scheduler {
    @Autowired
    private ExchangeRatesService service;

    @Scheduled(cron = "0 0 10 ? * MON,TUE,WED,THU,FRI *")
    public void doRequest(){
        service.getListRatesByDate(LocalDate.now(),true);
    }
}
