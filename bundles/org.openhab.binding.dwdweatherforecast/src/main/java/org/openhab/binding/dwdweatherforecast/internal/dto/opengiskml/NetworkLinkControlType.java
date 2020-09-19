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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NetworkLinkControlType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NetworkLinkControlType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}minRefreshPeriod" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}maxSessionLength" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}cookie" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}message" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}linkName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}linkDescription" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}linkSnippet" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}expires" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}Update" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractViewGroup" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}NetworkLinkControlSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}NetworkLinkControlObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkLinkControlType", propOrder = {
    "minRefreshPeriod",
    "maxSessionLength",
    "cookie",
    "message",
    "linkName",
    "linkDescription",
    "linkSnippet",
    "expires",
    "update",
    "abstractViewGroup",
    "networkLinkControlSimpleExtensionGroup",
    "networkLinkControlObjectExtensionGroup"
})
public class NetworkLinkControlType {

    @XmlElement(defaultValue = "0.0")
    protected Double minRefreshPeriod;
    @XmlElement(defaultValue = "-1.0")
    protected Double maxSessionLength;
    protected String cookie;
    protected String message;
    protected String linkName;
    protected String linkDescription;
    protected SnippetType linkSnippet;
    protected String expires;
    @XmlElement(name = "Update")
    protected UpdateType update;
    @XmlElementRef(name = "AbstractViewGroup", namespace = "http://www.opengis.net/kml/2.2", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends AbstractViewType> abstractViewGroup;
    @XmlElement(name = "NetworkLinkControlSimpleExtensionGroup")
    protected List<Object> networkLinkControlSimpleExtensionGroup;
    @XmlElement(name = "NetworkLinkControlObjectExtensionGroup")
    protected List<AbstractObjectType> networkLinkControlObjectExtensionGroup;

    /**
     * Gets the value of the minRefreshPeriod property.
     */
    public Double getMinRefreshPeriod() {
        return minRefreshPeriod;
    }

    /**
     * Sets the value of the minRefreshPeriod property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setMinRefreshPeriod(Double value) {
        this.minRefreshPeriod = value;
    }

    /**
     * Gets the value of the maxSessionLength property.
     */
    public Double getMaxSessionLength() {
        return maxSessionLength;
    }

    /**
     * Sets the value of the maxSessionLength property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setMaxSessionLength(Double value) {
        this.maxSessionLength = value;
    }

    /**
     * Gets the value of the cookie property.
     */
    public String getCookie() {
        return cookie;
    }

    /**
     * Sets the value of the cookie property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setCookie(String value) {
        this.cookie = value;
    }

    /**
     * Gets the value of the message property.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the linkName property.
     */
    public String getLinkName() {
        return linkName;
    }

    /**
     * Sets the value of the linkName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setLinkName(String value) {
        this.linkName = value;
    }

    /**
     * Gets the value of the linkDescription property.
     */
    public String getLinkDescription() {
        return linkDescription;
    }

    /**
     * Sets the value of the linkDescription property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setLinkDescription(String value) {
        this.linkDescription = value;
    }

    /**
     * Gets the value of the linkSnippet property.
     */
    public SnippetType getLinkSnippet() {
        return linkSnippet;
    }

    /**
     * Sets the value of the linkSnippet property.
     *
     * @param value
     *     allowed object is
     *     {@link SnippetType }
     */
    public void setLinkSnippet(SnippetType value) {
        this.linkSnippet = value;
    }

    /**
     * Gets the value of the expires property.
     */
    public String getExpires() {
        return expires;
    }

    /**
     * Sets the value of the expires property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setExpires(String value) {
        this.expires = value;
    }

    /**
     * Gets the value of the update property.
     */
    public UpdateType getUpdate() {
        return update;
    }

    /**
     * Sets the value of the update property.
     *
     * @param value
     *     allowed object is
     *     {@link UpdateType }
     */
    public void setUpdate(UpdateType value) {
        this.update = value;
    }

    /**
     * Gets the value of the abstractViewGroup property.
     */
    public JAXBElement<? extends AbstractViewType> getAbstractViewGroup() {
        return abstractViewGroup;
    }

    /**
     * Sets the value of the abstractViewGroup property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CameraType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LookAtType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractViewType }{@code >}
     */
    public void setAbstractViewGroup(JAXBElement<? extends AbstractViewType> value) {
        this.abstractViewGroup = value;
    }

    /**
     * Gets the value of the networkLinkControlSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the networkLinkControlSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetworkLinkControlSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getNetworkLinkControlSimpleExtensionGroup() {
        if (networkLinkControlSimpleExtensionGroup == null) {
            networkLinkControlSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.networkLinkControlSimpleExtensionGroup;
    }

    /**
     * Gets the value of the networkLinkControlObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the networkLinkControlObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetworkLinkControlObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getNetworkLinkControlObjectExtensionGroup() {
        if (networkLinkControlObjectExtensionGroup == null) {
            networkLinkControlObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.networkLinkControlObjectExtensionGroup;
    }

}
