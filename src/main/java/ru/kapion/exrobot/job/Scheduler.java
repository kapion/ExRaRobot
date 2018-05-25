package ru.kapion.exrobot.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    @Scheduled(cron = "0 0 10 ? * MON,TUE,WED,THU,FRI *")
    public void doRequest(){

    }
}
