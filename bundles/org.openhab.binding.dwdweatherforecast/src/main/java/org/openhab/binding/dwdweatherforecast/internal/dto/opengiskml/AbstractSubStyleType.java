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
 * <p>Java class for AbstractSubStyleType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AbstractSubStyleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractSubStyleSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractSubStyleObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractSubStyleType", propOrder = {
    "abstractSubStyleSimpleExtensionGroup",
    "abstractSubStyleObjectExtensionGroup"
})
@XmlSeeAlso({
    AbstractColorStyleType.class,
    BalloonStyleType.class,
    ListStyleType.class
})
public abstract class AbstractSubStyleType
    extends AbstractObjectType
{

    @XmlElement(name = "AbstractSubStyleSimpleExtensionGroup")
    protected List<Object> abstractSubStyleSimpleExtensionGroup;
    @XmlElement(name = "AbstractSubStyleObjectExtensionGroup")
    protected List<AbstractObjectType> abstractSubStyleObjectExtensionGroup;

    /**
     * Gets the value of the abstractSubStyleSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractSubStyleSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractSubStyleSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getAbstractSubStyleSimpleExtensionGroup() {
        if (abstractSubStyleSimpleExtensionGroup == null) {
            abstractSubStyleSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.abstractSubStyleSimpleExtensionGroup;
    }

    /**
     * Gets the value of the abstractSubStyleObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractSubStyleObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractSubStyleObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getAbstractSubStyleObjectExtensionGroup() {
        if (abstractSubStyleObjectExtensionGroup == null) {
            abstractSubStyleObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.abstractSubStyleObjectExtensionGroup;
    }

}
