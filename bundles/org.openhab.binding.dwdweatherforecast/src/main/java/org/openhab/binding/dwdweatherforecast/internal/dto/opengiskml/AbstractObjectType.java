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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for AbstractObjectType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AbstractObjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}ObjectSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{http://www.opengis.net/kml/2.2}idAttributes"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractObjectType", propOrder = {
    "objectSimpleExtensionGroup"
})
@XmlSeeAlso({
    AbstractViewType.class,
    SchemaDataType.class,
    DataType.class,
    RegionType.class,
    LodType.class,
    AbstractGeometryType.class,
    LocationType.class,
    OrientationType.class,
    ScaleType.class,
    ResourceMapType.class,
    AliasType.class,
    AbstractFeatureType.class,
    ViewVolumeType.class,
    ImagePyramidType.class,
    AbstractStyleSelectorType.class,
    PairType.class,
    AbstractSubStyleType.class,
    ItemIconType.class,
    AbstractTimePrimitiveType.class,
    AbstractLatLonBoxType.class,
    BasicLinkType.class
})
public abstract class AbstractObjectType {

    @XmlElement(name = "ObjectSimpleExtensionGroup")
    protected List<Object> objectSimpleExtensionGroup;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "targetId")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String targetId;

    /**
     * Gets the value of the objectSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the objectSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getObjectSimpleExtensionGroup() {
        if (objectSimpleExtensionGroup == null) {
            objectSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.objectSimpleExtensionGroup;
    }

    /**
     * Gets the value of the id property.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the targetId property.
     */
    public String getTargetId() {
        return targetId;
    }

    /**
     * Sets the value of the targetId property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setTargetId(String value) {
        this.targetId = value;
    }

}
