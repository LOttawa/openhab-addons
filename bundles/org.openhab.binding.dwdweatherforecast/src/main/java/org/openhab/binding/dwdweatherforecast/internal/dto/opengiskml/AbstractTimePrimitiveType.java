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
 * <p>Java class for AbstractTimePrimitiveType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AbstractTimePrimitiveType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractTimePrimitiveSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractTimePrimitiveObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractTimePrimitiveType", propOrder = {
    "abstractTimePrimitiveSimpleExtensionGroup",
    "abstractTimePrimitiveObjectExtensionGroup"
})
@XmlSeeAlso({
    TimeStampType.class,
    TimeSpanType.class
})
public abstract class AbstractTimePrimitiveType
    extends AbstractObjectType
{

    @XmlElement(name = "AbstractTimePrimitiveSimpleExtensionGroup")
    protected List<Object> abstractTimePrimitiveSimpleExtensionGroup;
    @XmlElement(name = "AbstractTimePrimitiveObjectExtensionGroup")
    protected List<AbstractObjectType> abstractTimePrimitiveObjectExtensionGroup;

    /**
     * Gets the value of the abstractTimePrimitiveSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractTimePrimitiveSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractTimePrimitiveSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getAbstractTimePrimitiveSimpleExtensionGroup() {
        if (abstractTimePrimitiveSimpleExtensionGroup == null) {
            abstractTimePrimitiveSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.abstractTimePrimitiveSimpleExtensionGroup;
    }

    /**
     * Gets the value of the abstractTimePrimitiveObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractTimePrimitiveObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractTimePrimitiveObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getAbstractTimePrimitiveObjectExtensionGroup() {
        if (abstractTimePrimitiveObjectExtensionGroup == null) {
            abstractTimePrimitiveObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.abstractTimePrimitiveObjectExtensionGroup;
    }

}
