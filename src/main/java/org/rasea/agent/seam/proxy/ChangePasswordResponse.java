
package org.rasea.agent.seam.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for changePasswordResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="changePasswordResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="changed" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "changePasswordResponse", propOrder = {
    "changed"
})
public class ChangePasswordResponse {

    protected boolean changed;

    /**
     * Gets the value of the changed property.
     * 
     */
    public boolean isChanged() {
        return changed;
    }

    /**
     * Sets the value of the changed property.
     * 
     */
    public void setChanged(boolean value) {
        this.changed = value;
    }

}
