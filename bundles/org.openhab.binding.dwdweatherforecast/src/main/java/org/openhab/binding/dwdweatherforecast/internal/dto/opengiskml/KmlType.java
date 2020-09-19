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
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for KmlType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="KmlType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}NetworkLinkControl" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractFeatureGroup" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}KmlSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}KmlObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="hint" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KmlType", propOrder = {
    "networkLinkControl",
    "abstractFeatureGroup",
    "kmlSimpleExtensionGroup",
    "kmlObjectExtensionGroup"
})
public class KmlType {

    @XmlElement(name = "NetworkLinkControl")
    protected NetworkLinkControlType networkLinkControl;
    @XmlElementRef(name = "AbstractFeatureGroup", namespace = "http://www.opengis.net/kml/2.2", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends AbstractFeatureType> abstractFeatureGroup;
    @XmlElement(name = "KmlSimpleExtensionGroup")
    protected List<Object> kmlSimpleExtensionGroup;
    @XmlElement(name = "KmlObjectExtensionGroup")
    protected List<AbstractObjectType> kmlObjectExtensionGroup;
    @XmlAttribute(name = "hint")
    protected String hint;

    /**
     * Gets the value of the networkLinkControl property.
     */
    public NetworkLinkControlType getNetworkLinkControl() {
        return networkLinkControl;
    }

    /**
     * Sets the value of the networkLinkControl property.
     *
     * @param value
     *     allowed object is
     *     {@link NetworkLinkControlType }
     */
    public void setNetworkLinkControl(NetworkLinkControlType value) {
        this.networkLinkControl = value;
    }

    /**
     * Gets the value of the abstractFeatureGroup property.
     */
    public JAXBElement<? extends AbstractFeatureType> getAbstractFeatureGroup() {
        return abstractFeatureGroup;
    }

    /**
     * Sets the value of the abstractFeatureGroup property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link PhotoOverlayType }{@code >}
     *     {@link JAXBElement }{@code <}{@link GroundOverlayType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ScreenOverlayType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractOverlayType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NetworkLinkType }{@code >}
     *     {@link JAXBElement }{@code <}{@link PlacemarkType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FolderType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractContainerType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractFeatureType }{@code >}
     */
    public void setAbstractFeatureGroup(JAXBElement<? extends AbstractFeatureType> value) {
        this.abstractFeatureGroup = value;
    }

    /**
     * Gets the value of the kmlSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kmlSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKmlSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getKmlSimpleExtensionGroup() {
        if (kmlSimpleExtensionGroup == null) {
            kmlSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.kmlSimpleExtensionGroup;
    }

    /**
     * Gets the value of the kmlObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the kmlObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKmlObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getKmlObjectExtensionGroup() {
        if (kmlObjectExtensionGroup == null) {
            kmlObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.kmlObjectExtensionGroup;
    }

    /**
     * Gets the value of the hint property.
     */
    public String getHint() {
        return hint;
    }

    /**
     * Sets the value of the hint property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setHint(String value) {
        this.hint = value;
    }

}
