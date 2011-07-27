
package org.rasea.agent.seam.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for resetPasswordResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resetPasswordResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="reseted" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resetPasswordResponse", propOrder = {
    "reseted"
})
public class ResetPasswordResponse {

    protected boolean reseted;

    /**
     * Gets the value of the reseted property.
     * 
     */
    public boolean isReseted() {
        return reseted;
    }

    /**
     * Sets the value of the reseted property.
     * 
     */
    public void setReseted(boolean value) {
        this.reseted = value;
    }

}
