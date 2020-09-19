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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AliasType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AliasType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}targetHref" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}sourceHref" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AliasSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AliasObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AliasType", propOrder = {
    "targetHref",
    "sourceHref",
    "aliasSimpleExtensionGroup",
    "aliasObjectExtensionGroup"
})
public class AliasType
    extends AbstractObjectType
{

    @XmlSchemaType(name = "anyURI")
    protected String targetHref;
    @XmlSchemaType(name = "anyURI")
    protected String sourceHref;
    @XmlElement(name = "AliasSimpleExtensionGroup")
    protected List<Object> aliasSimpleExtensionGroup;
    @XmlElement(name = "AliasObjectExtensionGroup")
    protected List<AbstractObjectType> aliasObjectExtensionGroup;

    /**
     * Gets the value of the targetHref property.
     */
    public String getTargetHref() {
        return targetHref;
    }

    /**
     * Sets the value of the targetHref property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setTargetHref(String value) {
        this.targetHref = value;
    }

    /**
     * Gets the value of the sourceHref property.
     */
    public String getSourceHref() {
        return sourceHref;
    }

    /**
     * Sets the value of the sourceHref property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setSourceHref(String value) {
        this.sourceHref = value;
    }

    /**
     * Gets the value of the aliasSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aliasSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAliasSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getAliasSimpleExtensionGroup() {
        if (aliasSimpleExtensionGroup == null) {
            aliasSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.aliasSimpleExtensionGroup;
    }

    /**
     * Gets the value of the aliasObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aliasObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAliasObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getAliasObjectExtensionGroup() {
        if (aliasObjectExtensionGroup == null) {
            aliasObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.aliasObjectExtensionGroup;
    }

}
