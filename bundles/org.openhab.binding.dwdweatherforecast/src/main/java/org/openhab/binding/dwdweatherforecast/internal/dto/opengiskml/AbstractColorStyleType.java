/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.openhab.binding.dwdweatherforecast.internal.dto.opengiskml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for AbstractColorStyleType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AbstractColorStyleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractSubStyleType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}color" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}colorMode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractColorStyleSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractColorStyleObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractColorStyleType", propOrder = {
    "color",
    "colorMode",
    "abstractColorStyleSimpleExtensionGroup",
    "abstractColorStyleObjectExtensionGroup"
})
@XmlSeeAlso({
    IconStyleType.class,
    LabelStyleType.class,
    LineStyleType.class,
    PolyStyleType.class
})
public abstract class AbstractColorStyleType
    extends AbstractSubStyleType
{

    @XmlElement(type = String.class, defaultValue = "ffffffff")
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] color;
    @XmlElement(defaultValue = "normal")
    @XmlSchemaType(name = "string")
    protected ColorModeEnumType colorMode;
    @XmlElement(name = "AbstractColorStyleSimpleExtensionGroup")
    protected List<Object> abstractColorStyleSimpleExtensionGroup;
    @XmlElement(name = "AbstractColorStyleObjectExtensionGroup")
    protected List<AbstractObjectType> abstractColorStyleObjectExtensionGroup;

    /**
     * Gets the value of the color property.
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
     */
    public void setColor(byte[] value) {
        this.color = value;
    }

    /**
     * Gets the value of the colorMode property.
     */
    public ColorModeEnumType getColorMode() {
        return colorMode;
    }

    /**
     * Sets the value of the colorMode property.
     *
     * @param value
     *     allowed object is
     *     {@link ColorModeEnumType }
     */
    public void setColorMode(ColorModeEnumType value) {
        this.colorMode = value;
    }

    /**
     * Gets the value of the abstractColorStyleSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractColorStyleSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractColorStyleSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getAbstractColorStyleSimpleExtensionGroup() {
        if (abstractColorStyleSimpleExtensionGroup == null) {
            abstractColorStyleSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.abstractColorStyleSimpleExtensionGroup;
    }

    /**
     * Gets the value of the abstractColorStyleObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractColorStyleObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractColorStyleObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getAbstractColorStyleObjectExtensionGroup() {
        if (abstractColorStyleObjectExtensionGroup == null) {
            abstractColorStyleObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.abstractColorStyleObjectExtensionGroup;
    }

}
