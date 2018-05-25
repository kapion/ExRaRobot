package ru.cbr.custom_model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@Getter@Setter
public class ValuteData {
    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter@Setter
    public static class ValuteCursOnDate {
        @XmlElement(name="Vname")
        private String name;
        @XmlElement(name="Vnom")
        private BigDecimal nom;
        @XmlElement(name="Vcurs")
        private BigDecimal curs;
        @XmlElement(name="Vcode")
        private int code;
        @XmlElement(name="VchCode")
        private String chCode;
    }

    @XmlElementWrapper(name="ValuteData")
    @XmlElement(name="ValuteCursOnDate")
    private List<ValuteCursOnDate> rows = new ArrayList<ValuteCursOnDate>();
    public List<ValuteCursOnDate> getRows() {
        return rows;
    }
    public void setRows(List<ValuteCursOnDate> rows) {
        this.rows = rows;
    }
}
