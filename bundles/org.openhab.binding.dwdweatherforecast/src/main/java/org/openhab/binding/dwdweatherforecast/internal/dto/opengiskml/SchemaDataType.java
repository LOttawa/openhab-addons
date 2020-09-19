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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SchemaDataType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SchemaDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}SimpleData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}SchemaDataExtension" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="schemaUrl" type="{http://www.w3.org/2001/XMLSchema}anyURI" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SchemaDataType", propOrder = {
    "simpleData",
    "schemaDataExtension"
})
public class SchemaDataType
    extends AbstractObjectType
{

    @XmlElement(name = "SimpleData")
    protected List<SimpleDataType> simpleData;
    @XmlElement(name = "SchemaDataExtension")
    protected List<Object> schemaDataExtension;
    @XmlAttribute(name = "schemaUrl")
    @XmlSchemaType(name = "anyURI")
    protected String schemaUrl;

    /**
     * Gets the value of the simpleData property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the simpleData property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSimpleData().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SimpleDataType }
     */
    public List<SimpleDataType> getSimpleData() {
        if (simpleData == null) {
            simpleData = new ArrayList<SimpleDataType>();
        }
        return this.simpleData;
    }

    /**
     * Gets the value of the schemaDataExtension property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the schemaDataExtension property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSchemaDataExtension().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getSchemaDataExtension() {
        if (schemaDataExtension == null) {
            schemaDataExtension = new ArrayList<Object>();
        }
        return this.schemaDataExtension;
    }

    /**
     * Gets the value of the schemaUrl property.
     */
    public String getSchemaUrl() {
        return schemaUrl;
    }

    /**
     * Sets the value of the schemaUrl property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setSchemaUrl(String value) {
        this.schemaUrl = value;
    }

}
