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
public class EnumValuteData {
    @XmlAccessorType(XmlAccessType.FIELD)
    @Getter@Setter
    public static class EnumValutes {
        @XmlElement(name="Vcode")
        private int code;
        @XmlElement(name="Vname")
        private String name;
        @XmlElement(name="VEngname")
        private String engName;
        @XmlElement(name="Vnom")
        private BigDecimal nom;
        @XmlElement(name="VcommonCode")
        private String commonCode;
        @XmlElement(name="VnumCode")
        private Integer numCode;
        @XmlElement(name="VcharCode")
        private String charCode;
    }


    @XmlElementWrapper(name="ValuteData")
    @XmlElement(name="EnumValutes")
    private List<EnumValutes> rows = new ArrayList<EnumValutes>();
    public List<EnumValutes> getRows() {
        return rows;
    }
    public void setRows(List<EnumValutes> rows) {
        this.rows = rows;
    }
}
