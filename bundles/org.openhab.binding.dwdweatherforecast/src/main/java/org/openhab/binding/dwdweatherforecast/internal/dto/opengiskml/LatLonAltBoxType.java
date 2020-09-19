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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LatLonAltBoxType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LatLonAltBoxType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractLatLonBoxType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}minAltitude" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}maxAltitude" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}altitudeModeGroup" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LatLonAltBoxSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LatLonAltBoxObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LatLonAltBoxType", propOrder = {
    "minAltitude",
    "maxAltitude",
    "altitudeModeGroup",
    "latLonAltBoxSimpleExtensionGroup",
    "latLonAltBoxObjectExtensionGroup"
})
public class LatLonAltBoxType
    extends AbstractLatLonBoxType
{

    @XmlElement(defaultValue = "0.0")
    protected Double minAltitude;
    @XmlElement(defaultValue = "0.0")
    protected Double maxAltitude;
    @XmlElementRef(name = "altitudeModeGroup", namespace = "http://www.opengis.net/kml/2.2", type = JAXBElement.class, required = false)
    protected JAXBElement<?> altitudeModeGroup;
    @XmlElement(name = "LatLonAltBoxSimpleExtensionGroup")
    protected List<Object> latLonAltBoxSimpleExtensionGroup;
    @XmlElement(name = "LatLonAltBoxObjectExtensionGroup")
    protected List<AbstractObjectType> latLonAltBoxObjectExtensionGroup;

    /**
     * Gets the value of the minAltitude property.
     */
    public Double getMinAltitude() {
        return minAltitude;
    }

    /**
     * Sets the value of the minAltitude property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setMinAltitude(Double value) {
        this.minAltitude = value;
    }

    /**
     * Gets the value of the maxAltitude property.
     */
    public Double getMaxAltitude() {
        return maxAltitude;
    }

    /**
     * Sets the value of the maxAltitude property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setMaxAltitude(Double value) {
        this.maxAltitude = value;
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
     * Gets the value of the latLonAltBoxSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the latLonAltBoxSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLatLonAltBoxSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getLatLonAltBoxSimpleExtensionGroup() {
        if (latLonAltBoxSimpleExtensionGroup == null) {
            latLonAltBoxSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.latLonAltBoxSimpleExtensionGroup;
    }

    /**
     * Gets the value of the latLonAltBoxObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the latLonAltBoxObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLatLonAltBoxObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getLatLonAltBoxObjectExtensionGroup() {
        if (latLonAltBoxObjectExtensionGroup == null) {
            latLonAltBoxObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.latLonAltBoxObjectExtensionGroup;
    }

}
