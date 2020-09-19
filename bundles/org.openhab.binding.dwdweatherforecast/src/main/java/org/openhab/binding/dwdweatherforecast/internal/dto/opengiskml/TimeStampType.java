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
 * <p>Java class for TimeStampType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="TimeStampType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractTimePrimitiveType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}when" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}TimeStampSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}TimeStampObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeStampType", propOrder = {
    "when",
    "timeStampSimpleExtensionGroup",
    "timeStampObjectExtensionGroup"
})
public class TimeStampType
    extends AbstractTimePrimitiveType
{

    protected String when;
    @XmlElement(name = "TimeStampSimpleExtensionGroup")
    protected List<Object> timeStampSimpleExtensionGroup;
    @XmlElement(name = "TimeStampObjectExtensionGroup")
    protected List<AbstractObjectType> timeStampObjectExtensionGroup;

    /**
     * Gets the value of the when property.
     */
    public String getWhen() {
        return when;
    }

    /**
     * Sets the value of the when property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setWhen(String value) {
        this.when = value;
    }

    /**
     * Gets the value of the timeStampSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timeStampSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimeStampSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getTimeStampSimpleExtensionGroup() {
        if (timeStampSimpleExtensionGroup == null) {
            timeStampSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.timeStampSimpleExtensionGroup;
    }

    /**
     * Gets the value of the timeStampObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the timeStampObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTimeStampObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getTimeStampObjectExtensionGroup() {
        if (timeStampObjectExtensionGroup == null) {
            timeStampObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.timeStampObjectExtensionGroup;
    }

}
