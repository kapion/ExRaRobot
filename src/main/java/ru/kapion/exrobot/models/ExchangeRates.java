package ru.kapion.exrobot.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@IdClass(ExKey.class)
@NoArgsConstructor
public class ExchangeRates implements Serializable, Comparable<ExchangeRates> {

    @Id
    private String chCode;
    @Id
    private LocalDate cdate;
    @Column
    private int code;
    @Column
    private String name;
    @Column
    private BigDecimal nom;
    @Column
    private BigDecimal curs;

    @Override
    public int compareTo(ru.kapion.exrobot.models.ExchangeRates o) {
        return  this.getCdate().compareTo(o.getCdate()) +
                (this.getChCode().compareTo(o.getChCode()));

    }

}
