//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.10.07 at 10:14:37 PM CEST 
//


package slash.navigation.gpx.garmin3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *     This type contains data fields available in Garmin GDB tracks that cannot
 *     be represented in routes in GPX 1.1 instances.
 *     
 * 
 * <p>Java class for TrackExtension_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TrackExtension_t">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DisplayColor" type="{http://www.garmin.com/xmlschemas/GpxExtensions/v3}DisplayColor_t" minOccurs="0"/>
 *         &lt;element name="Extensions" type="{http://www.garmin.com/xmlschemas/GpxExtensions/v3}Extensions_t" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrackExtension_t", propOrder = {
    "displayColor",
    "extensions"
})
public class TrackExtensionT {

    @XmlElement(name = "DisplayColor")
    protected DisplayColorT displayColor;
    @XmlElement(name = "Extensions")
    protected ExtensionsT extensions;

    /**
     * Gets the value of the displayColor property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayColorT }
     *     
     */
    public DisplayColorT getDisplayColor() {
        return displayColor;
    }

    /**
     * Sets the value of the displayColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayColorT }
     *     
     */
    public void setDisplayColor(DisplayColorT value) {
        this.displayColor = value;
    }

    /**
     * Gets the value of the extensions property.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionsT }
     *     
     */
    public ExtensionsT getExtensions() {
        return extensions;
    }

    /**
     * Sets the value of the extensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionsT }
     *     
     */
    public void setExtensions(ExtensionsT value) {
        this.extensions = value;
    }

}
