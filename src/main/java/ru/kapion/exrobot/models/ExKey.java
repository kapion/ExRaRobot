package ru.kapion.exrobot.models;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ExKey implements Serializable {

    static final long serialVersionUID = 1L;

    @Getter@Setter
    private String chCode;

    @Getter@Setter
    private LocalDate cdate;



}
