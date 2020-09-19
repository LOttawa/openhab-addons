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
 * <p>Java class for NetworkLinkType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NetworkLinkType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractFeatureType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}refreshVisibility" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}flyToView" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.opengis.net/kml/2.2}Url" minOccurs="0"/&gt;
 *           &lt;element ref="{http://www.opengis.net/kml/2.2}Link" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}NetworkLinkSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}NetworkLinkObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NetworkLinkType", propOrder = {
    "refreshVisibility",
    "flyToView",
    "url",
    "link",
    "networkLinkSimpleExtensionGroup",
    "networkLinkObjectExtensionGroup"
})
public class NetworkLinkType
    extends AbstractFeatureType
{

    @XmlElement(defaultValue = "0")
    protected Boolean refreshVisibility;
    @XmlElement(defaultValue = "0")
    protected Boolean flyToView;
    @XmlElement(name = "Url")
    protected LinkType url;
    @XmlElement(name = "Link")
    protected LinkType link;
    @XmlElement(name = "NetworkLinkSimpleExtensionGroup")
    protected List<Object> networkLinkSimpleExtensionGroup;
    @XmlElement(name = "NetworkLinkObjectExtensionGroup")
    protected List<AbstractObjectType> networkLinkObjectExtensionGroup;

    /**
     * Gets the value of the refreshVisibility property.
     */
    public Boolean isRefreshVisibility() {
        return refreshVisibility;
    }

    /**
     * Sets the value of the refreshVisibility property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     */
    public void setRefreshVisibility(Boolean value) {
        this.refreshVisibility = value;
    }

    /**
     * Gets the value of the flyToView property.
     */
    public Boolean isFlyToView() {
        return flyToView;
    }

    /**
     * Sets the value of the flyToView property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     */
    public void setFlyToView(Boolean value) {
        this.flyToView = value;
    }

    /**
     * Gets the value of the url property.
     */
    public LinkType getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     *
     * @param value
     *     allowed object is
     *     {@link LinkType }
     */
    public void setUrl(LinkType value) {
        this.url = value;
    }

    /**
     * Gets the value of the link property.
     */
    public LinkType getLink() {
        return link;
    }

    /**
     * Sets the value of the link property.
     *
     * @param value
     *     allowed object is
     *     {@link LinkType }
     */
    public void setLink(LinkType value) {
        this.link = value;
    }

    /**
     * Gets the value of the networkLinkSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the networkLinkSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetworkLinkSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getNetworkLinkSimpleExtensionGroup() {
        if (networkLinkSimpleExtensionGroup == null) {
            networkLinkSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.networkLinkSimpleExtensionGroup;
    }

    /**
     * Gets the value of the networkLinkObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the networkLinkObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNetworkLinkObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getNetworkLinkObjectExtensionGroup() {
        if (networkLinkObjectExtensionGroup == null) {
            networkLinkObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.networkLinkObjectExtensionGroup;
    }

}
