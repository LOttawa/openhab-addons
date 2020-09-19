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
 * <p>Java class for GroundOverlayType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GroundOverlayType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractOverlayType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}altitude" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}altitudeModeGroup" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LatLonBox" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}GroundOverlaySimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}GroundOverlayObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroundOverlayType", propOrder = {
    "altitude",
    "altitudeModeGroup",
    "latLonBox",
    "groundOverlaySimpleExtensionGroup",
    "groundOverlayObjectExtensionGroup"
})
public class GroundOverlayType
    extends AbstractOverlayType
{

    @XmlElement(defaultValue = "0.0")
    protected Double altitude;
    @XmlElementRef(name = "altitudeModeGroup", namespace = "http://www.opengis.net/kml/2.2", type = JAXBElement.class, required = false)
    protected JAXBElement<?> altitudeModeGroup;
    @XmlElement(name = "LatLonBox")
    protected LatLonBoxType latLonBox;
    @XmlElement(name = "GroundOverlaySimpleExtensionGroup")
    protected List<Object> groundOverlaySimpleExtensionGroup;
    @XmlElement(name = "GroundOverlayObjectExtensionGroup")
    protected List<AbstractObjectType> groundOverlayObjectExtensionGroup;

    /**
     * Gets the value of the altitude property.
     */
    public Double getAltitude() {
        return altitude;
    }

    /**
     * Sets the value of the altitude property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setAltitude(Double value) {
        this.altitude = value;
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
     * Gets the value of the latLonBox property.
     */
    public LatLonBoxType getLatLonBox() {
        return latLonBox;
    }

    /**
     * Sets the value of the latLonBox property.
     *
     * @param value
     *     allowed object is
     *     {@link LatLonBoxType }
     */
    public void setLatLonBox(LatLonBoxType value) {
        this.latLonBox = value;
    }

    /**
     * Gets the value of the groundOverlaySimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groundOverlaySimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroundOverlaySimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getGroundOverlaySimpleExtensionGroup() {
        if (groundOverlaySimpleExtensionGroup == null) {
            groundOverlaySimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.groundOverlaySimpleExtensionGroup;
    }

    /**
     * Gets the value of the groundOverlayObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groundOverlayObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroundOverlayObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getGroundOverlayObjectExtensionGroup() {
        if (groundOverlayObjectExtensionGroup == null) {
            groundOverlayObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.groundOverlayObjectExtensionGroup;
    }

}
