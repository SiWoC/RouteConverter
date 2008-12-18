//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.10.07 at 09:27:46 PM CEST 
//


package slash.navigation.kml.binding20;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{http://earth.google.com/kml/2.0}Icon"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.0}drawOrder" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.0}description" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.0}name" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.0}overlayXY" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.0}screenXY" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.0}size" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.0}visibility" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.0}rotation" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.0}refreshInterval" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.0}color" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
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
@XmlRootElement(name = "ScreenOverlay")
public class ScreenOverlay {

    @XmlElement(name = "Icon", required = true)
    protected Icon icon;
    protected Integer drawOrder;
    protected String description;
    protected String name;
    protected OverlayXY overlayXY;
    protected ScreenXY screenXY;
    protected Size size;
    protected Boolean visibility;
    protected BigDecimal rotation;
    protected Integer refreshInterval;
    @XmlElement(type = String.class)
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    protected byte[] color;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;

    /**
     * Gets the value of the icon property.
     * 
     * @return
     *     possible object is
     *     {@link Icon }
     *     
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     * 
     * @param value
     *     allowed object is
     *     {@link Icon }
     *     
     */
    public void setIcon(Icon value) {
        this.icon = value;
    }

    /**
     * Gets the value of the drawOrder property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDrawOrder() {
        return drawOrder;
    }

    /**
     * Sets the value of the drawOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDrawOrder(Integer value) {
        this.drawOrder = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the overlayXY property.
     * 
     * @return
     *     possible object is
     *     {@link OverlayXY }
     *     
     */
    public OverlayXY getOverlayXY() {
        return overlayXY;
    }

    /**
     * Sets the value of the overlayXY property.
     * 
     * @param value
     *     allowed object is
     *     {@link OverlayXY }
     *     
     */
    public void setOverlayXY(OverlayXY value) {
        this.overlayXY = value;
    }

    /**
     * Gets the value of the screenXY property.
     * 
     * @return
     *     possible object is
     *     {@link ScreenXY }
     *     
     */
    public ScreenXY getScreenXY() {
        return screenXY;
    }

    /**
     * Sets the value of the screenXY property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScreenXY }
     *     
     */
    public void setScreenXY(ScreenXY value) {
        this.screenXY = value;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link Size }
     *     
     */
    public Size getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link Size }
     *     
     */
    public void setSize(Size value) {
        this.size = value;
    }

    /**
     * Gets the value of the visibility property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVisibility() {
        return visibility;
    }

    /**
     * Sets the value of the visibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVisibility(Boolean value) {
        this.visibility = value;
    }

    /**
     * Gets the value of the rotation property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRotation() {
        return rotation;
    }

    /**
     * Sets the value of the rotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRotation(BigDecimal value) {
        this.rotation = value;
    }

    /**
     * Gets the value of the refreshInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRefreshInterval() {
        return refreshInterval;
    }

    /**
     * Sets the value of the refreshInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRefreshInterval(Integer value) {
        this.refreshInterval = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public byte[] getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColor(byte[] value) {
        this.color = ((byte[]) value);
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
