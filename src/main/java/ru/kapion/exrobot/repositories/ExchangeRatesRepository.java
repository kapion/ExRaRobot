package ru.kapion.exrobot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kapion.exrobot.models.ExchangeRates;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExchangeRatesRepository extends JpaRepository<ExchangeRates,Long>{

    @Query("select e from ExchangeRates e where e.cdate = ?1")
    List<ExchangeRates> findByDate(LocalDate date);

    @Query("select e from ExchangeRates e where e.cdate = ?1 and e.chCode = ?2")
    List<ExchangeRates> findByDateAndChCode(LocalDate date, String chCode);

}