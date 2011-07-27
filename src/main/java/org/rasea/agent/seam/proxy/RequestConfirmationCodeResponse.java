
package org.rasea.agent.seam.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestConfirmationCodeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestConfirmationCodeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="requested" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestConfirmationCodeResponse", propOrder = {
    "requested"
})
public class RequestConfirmationCodeResponse {

    protected boolean requested;

    /**
     * Gets the value of the requested property.
     * 
     */
    public boolean isRequested() {
        return requested;
    }

    /**
     * Sets the value of the requested property.
     * 
     */
    public void setRequested(boolean value) {
        this.requested = value;
    }

}
