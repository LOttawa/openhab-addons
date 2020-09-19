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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LabelStyleType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LabelStyleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractColorStyleType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}scale" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LabelStyleSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LabelStyleObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LabelStyleType", propOrder = {
    "scale",
    "labelStyleSimpleExtensionGroup",
    "labelStyleObjectExtensionGroup"
})
public class LabelStyleType
    extends AbstractColorStyleType
{

    @XmlElementRef(name = "scale", namespace = "http://www.opengis.net/kml/2.2", type = Scaleliteral.class, required = false)
    protected Scaleliteral scale;
    @XmlElement(name = "LabelStyleSimpleExtensionGroup")
    protected List<Object> labelStyleSimpleExtensionGroup;
    @XmlElement(name = "LabelStyleObjectExtensionGroup")
    protected List<AbstractObjectType> labelStyleObjectExtensionGroup;

    /**
     * Gets the value of the scale property.
     */
    public Scaleliteral getScale() {
        return scale;
    }

    /**
     * Sets the value of the scale property.
     *
     * @param value
     *     allowed object is
     *     {@link Scaleliteral }
     */
    public void setScale(Scaleliteral value) {
        this.scale = value;
    }

    /**
     * Gets the value of the labelStyleSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the labelStyleSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLabelStyleSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getLabelStyleSimpleExtensionGroup() {
        if (labelStyleSimpleExtensionGroup == null) {
            labelStyleSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.labelStyleSimpleExtensionGroup;
    }

    /**
     * Gets the value of the labelStyleObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the labelStyleObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLabelStyleObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getLabelStyleObjectExtensionGroup() {
        if (labelStyleObjectExtensionGroup == null) {
            labelStyleObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.labelStyleObjectExtensionGroup;
    }

}
