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
 * <p>Java class for LatLonBoxType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LatLonBoxType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractLatLonBoxType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}rotation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LatLonBoxSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LatLonBoxObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LatLonBoxType", propOrder = {
    "rotation",
    "latLonBoxSimpleExtensionGroup",
    "latLonBoxObjectExtensionGroup"
})
public class LatLonBoxType
    extends AbstractLatLonBoxType
{

    @XmlElement(defaultValue = "0.0")
    protected Double rotation;
    @XmlElement(name = "LatLonBoxSimpleExtensionGroup")
    protected List<Object> latLonBoxSimpleExtensionGroup;
    @XmlElement(name = "LatLonBoxObjectExtensionGroup")
    protected List<AbstractObjectType> latLonBoxObjectExtensionGroup;

    /**
     * Gets the value of the rotation property.
     */
    public Double getRotation() {
        return rotation;
    }

    /**
     * Sets the value of the rotation property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setRotation(Double value) {
        this.rotation = value;
    }

    /**
     * Gets the value of the latLonBoxSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the latLonBoxSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLatLonBoxSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getLatLonBoxSimpleExtensionGroup() {
        if (latLonBoxSimpleExtensionGroup == null) {
            latLonBoxSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.latLonBoxSimpleExtensionGroup;
    }

    /**
     * Gets the value of the latLonBoxObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the latLonBoxObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLatLonBoxObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getLatLonBoxObjectExtensionGroup() {
        if (latLonBoxObjectExtensionGroup == null) {
            latLonBoxObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.latLonBoxObjectExtensionGroup;
    }

}
