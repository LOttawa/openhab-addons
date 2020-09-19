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
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LineStringType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LineStringType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractGeometryType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}extrude" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}tessellate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}altitudeModeGroup" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}coordinates" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LineStringSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LineStringObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LineStringType", propOrder = {
    "extrude",
    "tessellate",
    "altitudeModeGroup",
    "coordinates",
    "lineStringSimpleExtensionGroup",
    "lineStringObjectExtensionGroup"
})
public class LineStringType
    extends AbstractGeometryType
{

    @XmlElement(defaultValue = "0")
    protected Boolean extrude;
    @XmlElement(defaultValue = "0")
    protected Boolean tessellate;
    @XmlElementRef(name = "altitudeModeGroup", namespace = "http://www.opengis.net/kml/2.2", type = JAXBElement.class, required = false)
    protected JAXBElement<?> altitudeModeGroup;
    @XmlList
    protected List<String> coordinates;
    @XmlElement(name = "LineStringSimpleExtensionGroup")
    protected List<Object> lineStringSimpleExtensionGroup;
    @XmlElement(name = "LineStringObjectExtensionGroup")
    protected List<AbstractObjectType> lineStringObjectExtensionGroup;

    /**
     * Gets the value of the extrude property.
     */
    public Boolean isExtrude() {
        return extrude;
    }

    /**
     * Sets the value of the extrude property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     */
    public void setExtrude(Boolean value) {
        this.extrude = value;
    }

    /**
     * Gets the value of the tessellate property.
     */
    public Boolean isTessellate() {
        return tessellate;
    }

    /**
     * Sets the value of the tessellate property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     */
    public void setTessellate(Boolean value) {
        this.tessellate = value;
    }

    /**
     * Gets the value of the altitudeModeGroup property.
     */
    public JAXBElement<?> getAltitudeModeGroup() {
        return altitudeModeGroup;
    }

    /**
     * Sets the value of the altitudeModeGroup property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link AltitudeModeEnumType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    public void setAltitudeModeGroup(JAXBElement<?> value) {
        this.altitudeModeGroup = value;
    }

    /**
     * Gets the value of the coordinates property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the coordinates property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCoordinates().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     */
    public List<String> getCoordinates() {
        if (coordinates == null) {
            coordinates = new ArrayList<String>();
        }
        return this.coordinates;
    }

    /**
     * Gets the value of the lineStringSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineStringSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineStringSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getLineStringSimpleExtensionGroup() {
        if (lineStringSimpleExtensionGroup == null) {
            lineStringSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.lineStringSimpleExtensionGroup;
    }

    /**
     * Gets the value of the lineStringObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lineStringObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLineStringObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getLineStringObjectExtensionGroup() {
        if (lineStringObjectExtensionGroup == null) {
            lineStringObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.lineStringObjectExtensionGroup;
    }

}
