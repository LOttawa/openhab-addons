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
 * <p>Java class for AbstractOverlayType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AbstractOverlayType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}color" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}drawOrder" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}Icon" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractOverlaySimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractOverlayObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractOverlayType", propOrder = {
    "color",
    "drawOrder",
    "icon",
    "abstractOverlaySimpleExtensionGroup",
    "abstractOverlayObjectExtensionGroup"
})
@XmlSeeAlso({
    GroundOverlayType.class,
    ScreenOverlayType.class,
    PhotoOverlayType.class
})
public abstract class AbstractOverlayType
    extends AbstractFeatureType
{

    @XmlElement(type = String.class, defaultValue = "ffffffff")
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] color;
    @XmlElement(defaultValue = "0")
    protected Integer drawOrder;
    @XmlElement(name = "Icon")
    protected LinkType icon;
    @XmlElement(name = "AbstractOverlaySimpleExtensionGroup")
    protected List<Object> abstractOverlaySimpleExtensionGroup;
    @XmlElement(name = "AbstractOverlayObjectExtensionGroup")
    protected List<AbstractObjectType> abstractOverlayObjectExtensionGroup;

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
     * Gets the value of the drawOrder property.
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
     */
    public void setDrawOrder(Integer value) {
        this.drawOrder = value;
    }

    /**
     * Gets the value of the icon property.
     */
    public LinkType getIcon() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     *
     * @param value
     *     allowed object is
     *     {@link LinkType }
     */
    public void setIcon(LinkType value) {
        this.icon = value;
    }

    /**
     * Gets the value of the abstractOverlaySimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractOverlaySimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractOverlaySimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getAbstractOverlaySimpleExtensionGroup() {
        if (abstractOverlaySimpleExtensionGroup == null) {
            abstractOverlaySimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.abstractOverlaySimpleExtensionGroup;
    }

    /**
     * Gets the value of the abstractOverlayObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractOverlayObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractOverlayObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getAbstractOverlayObjectExtensionGroup() {
        if (abstractOverlayObjectExtensionGroup == null) {
            abstractOverlayObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.abstractOverlayObjectExtensionGroup;
    }

}
