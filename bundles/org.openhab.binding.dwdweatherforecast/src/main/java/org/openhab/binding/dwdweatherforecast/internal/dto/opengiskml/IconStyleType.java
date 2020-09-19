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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IconStyleType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="IconStyleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractColorStyleType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}scale" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}heading" minOccurs="0"/&gt;
 *         &lt;element name="Icon" type="{http://www.opengis.net/kml/2.2}BasicLinkType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}hotSpot" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}IconStyleSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}IconStyleObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IconStyleType", propOrder = {
    "scale",
    "heading",
    "icon",
    "hotSpot",
    "iconStyleSimpleExtensionGroup",
    "iconStyleObjectExtensionGroup"
})
public class IconStyleType
    extends AbstractColorStyleType
{

    @XmlElementRef(name = "scale", namespace = "http://www.opengis.net/kml/2.2", type = Scaleliteral.class, required = false)
    protected Scaleliteral scale;
    @XmlElement(defaultValue = "0.0")
    protected Double heading;
    @XmlElement(name = "Icon")
    protected BasicLinkType icon;
    protected Vec2Type hotSpot;
    @XmlElement(name = "IconStyleSimpleExtensionGroup")
    protected List<Object> iconStyleSimpleExtensionGroup;
    @XmlElement(name = "IconStyleObjectExtensionGroup")
    protected List<AbstractObjectType> iconStyleObjectExtensionGroup;

    /**
     * Gets the value of the scale property.
     */
    public Scaleliteral getScale() {
        return scale;
    }

    /**
     * Sets the value of the scale property.
     *
     * @param value
     *     allowed object is
     *     {@link Scaleliteral }
     */
    public void setScale(Scaleliteral value) {
        this.scale = value;
    }

    /**
     * Gets the value of the heading property.
     */
    public Double getHeading() {
        return heading;
    }

    /**
     * Sets the value of the heading property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setHeading(Double value) {
        this.heading = value;
    }

    /**
     * Gets the value of the icon property.
     */
    public BasicLinkType getIcon() {
        return icon;
    }

    /**
     * Sets the value of the icon property.
     *
     * @param value
     *     allowed object is
     *     {@link BasicLinkType }
     */
    public void setIcon(BasicLinkType value) {
        this.icon = value;
    }

    /**
     * Gets the value of the hotSpot property.
     */
    public Vec2Type getHotSpot() {
        return hotSpot;
    }

    /**
     * Sets the value of the hotSpot property.
     *
     * @param value
     *     allowed object is
     *     {@link Vec2Type }
     */
    public void setHotSpot(Vec2Type value) {
        this.hotSpot = value;
    }

    /**
     * Gets the value of the iconStyleSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iconStyleSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIconStyleSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getIconStyleSimpleExtensionGroup() {
        if (iconStyleSimpleExtensionGroup == null) {
            iconStyleSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.iconStyleSimpleExtensionGroup;
    }

    /**
     * Gets the value of the iconStyleObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the iconStyleObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIconStyleObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getIconStyleObjectExtensionGroup() {
        if (iconStyleObjectExtensionGroup == null) {
            iconStyleObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.iconStyleObjectExtensionGroup;
    }

}
