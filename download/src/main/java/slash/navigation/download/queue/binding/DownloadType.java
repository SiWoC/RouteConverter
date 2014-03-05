//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1.16-hudson-jaxb-ri-2.1-pushtomaven-250--SNAPSHOT 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.02.28 at 09:19:18 PM MEZ 
//


package slash.navigation.download.queue.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 *                 a download contains a description, an url, optionally size and checksum,
 *                 plus data to perform the download upon restart.
 *             
 * 
 * <p>Java class for downloadType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="downloadType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="description" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="url" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="size" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *       &lt;attribute name="checksum" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="action" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="lastSync" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="state" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="tempFile" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="lastModified" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="contentLength" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "downloadType")
public class DownloadType {

    @XmlAttribute(name = "description", required = true)
    protected String description;
    @XmlAttribute(name = "url", required = true)
    protected String url;
    @XmlAttribute(name = "size", required = true)
    protected long size;
    @XmlAttribute(name = "checksum", required = true)
    protected String checksum;
    @XmlAttribute(name = "action", required = true)
    protected String action;
    @XmlAttribute(name = "target", required = true)
    protected String target;
    @XmlAttribute(name = "lastSync", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastSync;
    @XmlAttribute(name = "state", required = true)
    protected String state;
    @XmlAttribute(name = "tempFile", required = true)
    protected String tempFile;
    @XmlAttribute(name = "lastModified", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastModified;
    @XmlAttribute(name = "contentLength", required = true)
    protected long contentLength;

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
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the size property.
     * 
     */
    public long getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     */
    public void setSize(long value) {
        this.size = value;
    }

    /**
     * Gets the value of the checksum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChecksum() {
        return checksum;
    }

    /**
     * Sets the value of the checksum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChecksum(String value) {
        this.checksum = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Gets the value of the target property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTarget(String value) {
        this.target = value;
    }

    /**
     * Gets the value of the lastSync property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastSync() {
        return lastSync;
    }

    /**
     * Sets the value of the lastSync property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastSync(XMLGregorianCalendar value) {
        this.lastSync = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the tempFile property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTempFile() {
        return tempFile;
    }

    /**
     * Sets the value of the tempFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTempFile(String value) {
        this.tempFile = value;
    }

    /**
     * Gets the value of the lastModified property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastModified() {
        return lastModified;
    }

    /**
     * Sets the value of the lastModified property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastModified(XMLGregorianCalendar value) {
        this.lastModified = value;
    }

    /**
     * Gets the value of the contentLength property.
     * 
     */
    public long getContentLength() {
        return contentLength;
    }

    /**
     * Sets the value of the contentLength property.
     * 
     */
    public void setContentLength(long value) {
        this.contentLength = value;
    }

}
