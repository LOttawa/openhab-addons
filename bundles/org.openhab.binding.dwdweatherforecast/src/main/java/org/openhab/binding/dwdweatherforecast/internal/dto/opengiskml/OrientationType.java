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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrientationType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OrientationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}heading" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}tilt" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}roll" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}OrientationSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}OrientationObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrientationType", propOrder = {
    "heading",
    "tilt",
    "roll",
    "orientationSimpleExtensionGroup",
    "orientationObjectExtensionGroup"
})
public class OrientationType
    extends AbstractObjectType
{

    @XmlElement(defaultValue = "0.0")
    protected Double heading;
    @XmlElement(defaultValue = "0.0")
    protected Double tilt;
    @XmlElement(defaultValue = "0.0")
    protected Double roll;
    @XmlElement(name = "OrientationSimpleExtensionGroup")
    protected List<Object> orientationSimpleExtensionGroup;
    @XmlElement(name = "OrientationObjectExtensionGroup")
    protected List<AbstractObjectType> orientationObjectExtensionGroup;

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
     * Gets the value of the orientationSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orientationSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrientationSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getOrientationSimpleExtensionGroup() {
        if (orientationSimpleExtensionGroup == null) {
            orientationSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.orientationSimpleExtensionGroup;
    }

    /**
     * Gets the value of the orientationObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the orientationObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrientationObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getOrientationObjectExtensionGroup() {
        if (orientationObjectExtensionGroup == null) {
            orientationObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.orientationObjectExtensionGroup;
    }

}
