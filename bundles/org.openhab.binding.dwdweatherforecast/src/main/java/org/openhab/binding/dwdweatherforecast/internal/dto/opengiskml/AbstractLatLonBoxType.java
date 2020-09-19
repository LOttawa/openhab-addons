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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AbstractLatLonBoxType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AbstractLatLonBoxType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}north" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}south" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}east" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}west" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractLatLonBoxSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractLatLonBoxObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractLatLonBoxType", propOrder = {
    "north",
    "south",
    "east",
    "west",
    "abstractLatLonBoxSimpleExtensionGroup",
    "abstractLatLonBoxObjectExtensionGroup"
})
@XmlSeeAlso({
    LatLonAltBoxType.class,
    LatLonBoxType.class
})
public abstract class AbstractLatLonBoxType
    extends AbstractObjectType
{

    @XmlElement(defaultValue = "180.0")
    protected Double north;
    @XmlElement(defaultValue = "-180.0")
    protected Double south;
    @XmlElement(defaultValue = "180.0")
    protected Double east;
    @XmlElement(defaultValue = "-180.0")
    protected Double west;
    @XmlElement(name = "AbstractLatLonBoxSimpleExtensionGroup")
    protected List<Object> abstractLatLonBoxSimpleExtensionGroup;
    @XmlElement(name = "AbstractLatLonBoxObjectExtensionGroup")
    protected List<AbstractObjectType> abstractLatLonBoxObjectExtensionGroup;

    /**
     * Gets the value of the north property.
     */
    public Double getNorth() {
        return north;
    }

    /**
     * Sets the value of the north property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setNorth(Double value) {
        this.north = value;
    }

    /**
     * Gets the value of the south property.
     */
    public Double getSouth() {
        return south;
    }

    /**
     * Sets the value of the south property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setSouth(Double value) {
        this.south = value;
    }

    /**
     * Gets the value of the east property.
     */
    public Double getEast() {
        return east;
    }

    /**
     * Sets the value of the east property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setEast(Double value) {
        this.east = value;
    }

    /**
     * Gets the value of the west property.
     */
    public Double getWest() {
        return west;
    }

    /**
     * Sets the value of the west property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setWest(Double value) {
        this.west = value;
    }

    /**
     * Gets the value of the abstractLatLonBoxSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractLatLonBoxSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractLatLonBoxSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getAbstractLatLonBoxSimpleExtensionGroup() {
        if (abstractLatLonBoxSimpleExtensionGroup == null) {
            abstractLatLonBoxSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.abstractLatLonBoxSimpleExtensionGroup;
    }

    /**
     * Gets the value of the abstractLatLonBoxObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractLatLonBoxObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractLatLonBoxObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getAbstractLatLonBoxObjectExtensionGroup() {
        if (abstractLatLonBoxObjectExtensionGroup == null) {
            abstractLatLonBoxObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.abstractLatLonBoxObjectExtensionGroup;
    }

}
