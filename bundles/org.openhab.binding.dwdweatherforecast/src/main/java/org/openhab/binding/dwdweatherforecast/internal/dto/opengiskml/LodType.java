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
 * <p>Java class for LodType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LodType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}minLodPixels" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}maxLodPixels" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}minFadeExtent" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}maxFadeExtent" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LodSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LodObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LodType", propOrder = {
    "minLodPixels",
    "maxLodPixels",
    "minFadeExtent",
    "maxFadeExtent",
    "lodSimpleExtensionGroup",
    "lodObjectExtensionGroup"
})
public class LodType
    extends AbstractObjectType
{

    @XmlElement(defaultValue = "0.0")
    protected Double minLodPixels;
    @XmlElement(defaultValue = "-1.0")
    protected Double maxLodPixels;
    @XmlElement(defaultValue = "0.0")
    protected Double minFadeExtent;
    @XmlElement(defaultValue = "0.0")
    protected Double maxFadeExtent;
    @XmlElement(name = "LodSimpleExtensionGroup")
    protected List<Object> lodSimpleExtensionGroup;
    @XmlElement(name = "LodObjectExtensionGroup")
    protected List<AbstractObjectType> lodObjectExtensionGroup;

    /**
     * Gets the value of the minLodPixels property.
     */
    public Double getMinLodPixels() {
        return minLodPixels;
    }

    /**
     * Sets the value of the minLodPixels property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setMinLodPixels(Double value) {
        this.minLodPixels = value;
    }

    /**
     * Gets the value of the maxLodPixels property.
     */
    public Double getMaxLodPixels() {
        return maxLodPixels;
    }

    /**
     * Sets the value of the maxLodPixels property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setMaxLodPixels(Double value) {
        this.maxLodPixels = value;
    }

    /**
     * Gets the value of the minFadeExtent property.
     */
    public Double getMinFadeExtent() {
        return minFadeExtent;
    }

    /**
     * Sets the value of the minFadeExtent property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setMinFadeExtent(Double value) {
        this.minFadeExtent = value;
    }

    /**
     * Gets the value of the maxFadeExtent property.
     */
    public Double getMaxFadeExtent() {
        return maxFadeExtent;
    }

    /**
     * Sets the value of the maxFadeExtent property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setMaxFadeExtent(Double value) {
        this.maxFadeExtent = value;
    }

    /**
     * Gets the value of the lodSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lodSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLodSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getLodSimpleExtensionGroup() {
        if (lodSimpleExtensionGroup == null) {
            lodSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.lodSimpleExtensionGroup;
    }

    /**
     * Gets the value of the lodObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lodObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLodObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getLodObjectExtensionGroup() {
        if (lodObjectExtensionGroup == null) {
            lodObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.lodObjectExtensionGroup;
    }

}
