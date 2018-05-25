
package ru.cbr;

import ru.cbr.custom_model.ValuteData;

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
 *         &lt;element name="GetCursOnDateResult" minOccurs="0">
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
    "getCursOnDateResult"
})
@XmlRootElement(name = "GetCursOnDateResponse")
public class GetCursOnDateResponse {

    @XmlElement(name = "GetCursOnDateResult")
    protected GetCursOnDateResponse.GetCursOnDateResult getCursOnDateResult;


    public GetCursOnDateResponse.GetCursOnDateResult getGetCursOnDateResult() {
        return getCursOnDateResult;
    }


    public void setGetCursOnDateResult(GetCursOnDateResponse.GetCursOnDateResult value) {
        this.getCursOnDateResult = value;
    }



    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"any"})
    public static class GetCursOnDateResult {

//        @XmlAnyElement(lax = true)
//        protected Object any;
//
//        public Object getAny() {
//            return any;
//        }
//
//        public void setAny(Object value) {
//            this.any = value;
//        }


        @XmlElement(name="diffgram",namespace="urn:schemas-microsoft-com:xml-diffgram-v1")
        protected ValuteData any;
        public ValuteData getAny() {
            return any;
        }
        public void setAny(ValuteData any) {
            this.any = any;
        }

    }

}
