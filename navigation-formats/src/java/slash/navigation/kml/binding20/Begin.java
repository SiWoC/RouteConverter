//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.10.07 at 09:27:46 PM CEST 
//


package slash.navigation.kml.binding20;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element ref="{http://earth.google.com/kml/2.0}TimeInstant" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "begin")
public class Begin {

    @XmlElement(name = "TimeInstant")
    protected TimeInstant timeInstant;

    /**
     * Gets the value of the timeInstant property.
     * 
     * @return
     *     possible object is
     *     {@link TimeInstant }
     *     
     */
    public TimeInstant getTimeInstant() {
        return timeInstant;
    }

    /**
     * Sets the value of the timeInstant property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeInstant }
     *     
     */
    public void setTimeInstant(TimeInstant value) {
        this.timeInstant = value;
    }

}
