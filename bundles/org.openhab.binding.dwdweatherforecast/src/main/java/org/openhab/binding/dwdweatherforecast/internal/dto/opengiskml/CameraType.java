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
 * <p>Java class for CameraType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CameraType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractViewType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}longitude" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}latitude" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}altitude" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}heading" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}tilt" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}roll" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}altitudeModeGroup" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}CameraSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}CameraObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CameraType", propOrder = {
    "longitude",
    "latitude",
    "altitude",
    "heading",
    "tilt",
    "roll",
    "altitudeModeGroup",
    "cameraSimpleExtensionGroup",
    "cameraObjectExtensionGroup"
})
public class CameraType
    extends AbstractViewType
{

    @XmlElement(defaultValue = "0.0")
    protected Double longitude;
    @XmlElement(defaultValue = "0.0")
    protected Double latitude;
    @XmlElement(defaultValue = "0.0")
    protected Double altitude;
    @XmlElement(defaultValue = "0.0")
    protected Double heading;
    @XmlElement(defaultValue = "0.0")
    protected Double tilt;
    @XmlElement(defaultValue = "0.0")
    protected Double roll;
    @XmlElementRef(name = "altitudeModeGroup", namespace = "http://www.opengis.net/kml/2.2", type = JAXBElement.class, required = false)
    protected JAXBElement<?> altitudeModeGroup;
    @XmlElement(name = "CameraSimpleExtensionGroup")
    protected List<Object> cameraSimpleExtensionGroup;
    @XmlElement(name = "CameraObjectExtensionGroup")
    protected List<AbstractObjectType> cameraObjectExtensionGroup;

    /**
     * Gets the value of the longitude property.
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * Sets the value of the longitude property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setLongitude(Double value) {
        this.longitude = value;
    }

    /**
     * Gets the value of the latitude property.
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * Sets the value of the latitude property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setLatitude(Double value) {
        this.latitude = value;
    }

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
     * Gets the value of the tilt property.
     */
    public Double getTilt() {
        return tilt;
    }

    /**
     * Sets the value of the tilt property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setTilt(Double value) {
        this.tilt = value;
    }

    /**
     * Gets the value of the roll property.
     */
    public Double getRoll() {
        return roll;
    }

    /**
     * Sets the value of the roll property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setRoll(Double value) {
        this.roll = value;
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
     * Gets the value of the cameraSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cameraSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCameraSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getCameraSimpleExtensionGroup() {
        if (cameraSimpleExtensionGroup == null) {
            cameraSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.cameraSimpleExtensionGroup;
    }

    /**
     * Gets the value of the cameraObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cameraObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCameraObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getCameraObjectExtensionGroup() {
        if (cameraObjectExtensionGroup == null) {
            cameraObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.cameraObjectExtensionGroup;
    }

}
