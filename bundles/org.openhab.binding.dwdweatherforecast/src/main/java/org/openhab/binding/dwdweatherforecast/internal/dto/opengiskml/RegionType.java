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
 * <p>Java class for RegionType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RegionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LatLonAltBox" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}Lod" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}RegionSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}RegionObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegionType", propOrder = {
    "latLonAltBox",
    "lod",
    "regionSimpleExtensionGroup",
    "regionObjectExtensionGroup"
})
public class RegionType
    extends AbstractObjectType
{

    @XmlElement(name = "LatLonAltBox")
    protected LatLonAltBoxType latLonAltBox;
    @XmlElement(name = "Lod")
    protected LodType lod;
    @XmlElement(name = "RegionSimpleExtensionGroup")
    protected List<Object> regionSimpleExtensionGroup;
    @XmlElement(name = "RegionObjectExtensionGroup")
    protected List<AbstractObjectType> regionObjectExtensionGroup;

    /**
     * Gets the value of the latLonAltBox property.
     */
    public LatLonAltBoxType getLatLonAltBox() {
        return latLonAltBox;
    }

    /**
     * Sets the value of the latLonAltBox property.
     *
     * @param value
     *     allowed object is
     *     {@link LatLonAltBoxType }
     */
    public void setLatLonAltBox(LatLonAltBoxType value) {
        this.latLonAltBox = value;
    }

    /**
     * Gets the value of the lod property.
     */
    public LodType getLod() {
        return lod;
    }

    /**
     * Sets the value of the lod property.
     *
     * @param value
     *     allowed object is
     *     {@link LodType }
     */
    public void setLod(LodType value) {
        this.lod = value;
    }

    /**
     * Gets the value of the regionSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regionSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegionSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getRegionSimpleExtensionGroup() {
        if (regionSimpleExtensionGroup == null) {
            regionSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.regionSimpleExtensionGroup;
    }

    /**
     * Gets the value of the regionObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the regionObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegionObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getRegionObjectExtensionGroup() {
        if (regionObjectExtensionGroup == null) {
            regionObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.regionObjectExtensionGroup;
    }

}
