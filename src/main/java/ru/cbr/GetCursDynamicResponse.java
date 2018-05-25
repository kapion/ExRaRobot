
package ru.cbr;

import ru.cbr.custom_model.DynValuteData;

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
 *         &lt;element name="GetCursDynamicResult" minOccurs="0">
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
    "getCursDynamicResult"
})
@XmlRootElement(name = "GetCursDynamicResponse")
public class GetCursDynamicResponse {

    @XmlElement(name = "GetCursDynamicResult")
    protected GetCursDynamicResponse.GetCursDynamicResult getCursDynamicResult;

    /**
     * Gets the value of the getCursDynamicResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetCursDynamicResponse.GetCursDynamicResult }
     *     
     */
    public GetCursDynamicResponse.GetCursDynamicResult getGetCursDynamicResult() {
        return getCursDynamicResult;
    }

    /**
     * Sets the value of the getCursDynamicResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCursDynamicResponse.GetCursDynamicResult }
     *     
     */
    public void setGetCursDynamicResult(GetCursDynamicResponse.GetCursDynamicResult value) {
        this.getCursDynamicResult = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class GetCursDynamicResult {
            @XmlElement(name="diffgram",namespace="urn:schemas-microsoft-com:xml-diffgram-v1")
            protected DynValuteData any;
            public DynValuteData getAny() {
                return any;
            }
            public void setAny(DynValuteData any) {
                this.any = any;
            }
    }

}
