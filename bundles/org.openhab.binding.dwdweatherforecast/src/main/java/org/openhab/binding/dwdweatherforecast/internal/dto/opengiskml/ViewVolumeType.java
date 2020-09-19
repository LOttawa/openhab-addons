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
 * <p>Java class for ViewVolumeType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ViewVolumeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}leftFov" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}rightFov" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}bottomFov" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}topFov" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}near" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}ViewVolumeSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}ViewVolumeObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewVolumeType", propOrder = {
    "leftFov",
    "rightFov",
    "bottomFov",
    "topFov",
    "near",
    "viewVolumeSimpleExtensionGroup",
    "viewVolumeObjectExtensionGroup"
})
public class ViewVolumeType
    extends AbstractObjectType
{

    @XmlElement(defaultValue = "0.0")
    protected Double leftFov;
    @XmlElement(defaultValue = "0.0")
    protected Double rightFov;
    @XmlElement(defaultValue = "0.0")
    protected Double bottomFov;
    @XmlElement(defaultValue = "0.0")
    protected Double topFov;
    @XmlElement(defaultValue = "0.0")
    protected Double near;
    @XmlElement(name = "ViewVolumeSimpleExtensionGroup")
    protected List<Object> viewVolumeSimpleExtensionGroup;
    @XmlElement(name = "ViewVolumeObjectExtensionGroup")
    protected List<AbstractObjectType> viewVolumeObjectExtensionGroup;

    /**
     * Gets the value of the leftFov property.
     */
    public Double getLeftFov() {
        return leftFov;
    }

    /**
     * Sets the value of the leftFov property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setLeftFov(Double value) {
        this.leftFov = value;
    }

    /**
     * Gets the value of the rightFov property.
     */
    public Double getRightFov() {
        return rightFov;
    }

    /**
     * Sets the value of the rightFov property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setRightFov(Double value) {
        this.rightFov = value;
    }

    /**
     * Gets the value of the bottomFov property.
     */
    public Double getBottomFov() {
        return bottomFov;
    }

    /**
     * Sets the value of the bottomFov property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setBottomFov(Double value) {
        this.bottomFov = value;
    }

    /**
     * Gets the value of the topFov property.
     */
    public Double getTopFov() {
        return topFov;
    }

    /**
     * Sets the value of the topFov property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setTopFov(Double value) {
        this.topFov = value;
    }

    /**
     * Gets the value of the near property.
     */
    public Double getNear() {
        return near;
    }

    /**
     * Sets the value of the near property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setNear(Double value) {
        this.near = value;
    }

    /**
     * Gets the value of the viewVolumeSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the viewVolumeSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getViewVolumeSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getViewVolumeSimpleExtensionGroup() {
        if (viewVolumeSimpleExtensionGroup == null) {
            viewVolumeSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.viewVolumeSimpleExtensionGroup;
    }

    /**
     * Gets the value of the viewVolumeObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the viewVolumeObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getViewVolumeObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getViewVolumeObjectExtensionGroup() {
        if (viewVolumeObjectExtensionGroup == null) {
            viewVolumeObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.viewVolumeObjectExtensionGroup;
    }

}
