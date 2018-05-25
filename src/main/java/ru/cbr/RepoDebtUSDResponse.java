
package ru.cbr;

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
 *         &lt;element name="RepoDebtUSDResult" minOccurs="0">
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
    "repoDebtUSDResult"
})
@XmlRootElement(name = "RepoDebtUSDResponse")
public class RepoDebtUSDResponse {

    @XmlElement(name = "RepoDebtUSDResult")
    protected RepoDebtUSDResponse.RepoDebtUSDResult repoDebtUSDResult;

    /**
     * Gets the value of the repoDebtUSDResult property.
     * 
     * @return
     *     possible object is
     *     {@link RepoDebtUSDResponse.RepoDebtUSDResult }
     *     
     */
    public RepoDebtUSDResponse.RepoDebtUSDResult getRepoDebtUSDResult() {
        return repoDebtUSDResult;
    }

    /**
     * Sets the value of the repoDebtUSDResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link RepoDebtUSDResponse.RepoDebtUSDResult }
     *     
     */
    public void setRepoDebtUSDResult(RepoDebtUSDResponse.RepoDebtUSDResult value) {
        this.repoDebtUSDResult = value;
    }


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
     *         &lt;any/>
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
        "any"
    })
    public static class RepoDebtUSDResult {

        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * Gets the value of the any property.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getAny() {
            return any;
        }

        /**
         * Sets the value of the any property.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }

}
