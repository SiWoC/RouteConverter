//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.10.07 at 09:27:50 PM CEST 
//


package slash.navigation.kml.binding21;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for unitsEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="unitsEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="fraction"/>
 *     &lt;enumeration value="pixels"/>
 *     &lt;enumeration value="insetPixels"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum
public enum UnitsEnum {

    @XmlEnumValue("fraction")
    FRACTION("fraction"),
    @XmlEnumValue("pixels")
    PIXELS("pixels"),
    @XmlEnumValue("insetPixels")
    INSET_PIXELS("insetPixels");
    private final String value;

    UnitsEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UnitsEnum fromValue(String v) {
        for (UnitsEnum c: UnitsEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v.toString());
    }

}
