package ru.cbr.custom_model;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@Getter@Setter
public class DynValuteData {
    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter@Setter
    public static class ValuteCursDynamic {
        @XmlElement(name="CursDate")
        private XMLGregorianCalendar cursDate;
        @XmlElement(name="Vcode")
        private String code;
        @XmlElement(name="Vnom")
        private BigDecimal nom;
        @XmlElement(name="Vcurs")
        private BigDecimal curs;

    }

    @XmlElementWrapper(name="ValuteData")
    @XmlElement(name="ValuteCursDynamic")
    private List<ValuteCursDynamic> rows = new ArrayList<ValuteCursDynamic>();
    public List<ValuteCursDynamic> getRows() {
        return rows;
    }
    public void setRows(List<ValuteCursDynamic> rows) {
        this.rows = rows;
    }
}
