
package ru.cbr;

import ru.cbr.custom_model.EnumValuteData;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EnumValutesResult" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "enumValutesResult"
})
@XmlRootElement(name = "EnumValutesResponse")
public class EnumValutesResponse {

    @XmlElement(name = "EnumValutesResult")
    protected EnumValutesResponse.EnumValutesResult enumValutesResult;

    /**
     * Gets the value of the enumValutesResult property.
     * 
     * @return
     *     possible object is
     *     {@link EnumValutesResponse.EnumValutesResult }
     *     
     */
    public EnumValutesResponse.EnumValutesResult getEnumValutesResult() {
        return enumValutesResult;
    }

    /**
     * Sets the value of the enumValutesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumValutesResponse.EnumValutesResult }
     *     
     */
    public void setEnumValutesResult(EnumValutesResponse.EnumValutesResult value) {
        this.enumValutesResult = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class EnumValutesResult {

        @XmlElement(name="diffgram",namespace="urn:schemas-microsoft-com:xml-diffgram-v1")
        protected EnumValuteData any;
        public EnumValuteData getAny() {
            return any;
        }
        public void setAny(EnumValuteData any) {
            this.any = any;
        }

    }

}
