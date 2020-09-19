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
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for ListStyleType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ListStyleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractSubStyleType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}listItemType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}bgColor" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}ItemIcon" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}maxSnippetLines" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}ListStyleSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}ListStyleObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ListStyleType", propOrder = {
    "listItemType",
    "bgColor",
    "itemIcon",
    "maxSnippetLines",
    "listStyleSimpleExtensionGroup",
    "listStyleObjectExtensionGroup"
})
public class ListStyleType
    extends AbstractSubStyleType
{

    @XmlElement(defaultValue = "check")
    @XmlSchemaType(name = "string")
    protected ListItemTypeEnumType listItemType;
    @XmlElement(type = String.class, defaultValue = "ffffffff")
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] bgColor;
    @XmlElement(name = "ItemIcon")
    protected List<ItemIconType> itemIcon;
    @XmlElement(defaultValue = "2")
    protected Integer maxSnippetLines;
    @XmlElement(name = "ListStyleSimpleExtensionGroup")
    protected List<Object> listStyleSimpleExtensionGroup;
    @XmlElement(name = "ListStyleObjectExtensionGroup")
    protected List<AbstractObjectType> listStyleObjectExtensionGroup;

    /**
     * Gets the value of the listItemType property.
     */
    public ListItemTypeEnumType getListItemType() {
        return listItemType;
    }

    /**
     * Sets the value of the listItemType property.
     *
     * @param value
     *     allowed object is
     *     {@link ListItemTypeEnumType }
     */
    public void setListItemType(ListItemTypeEnumType value) {
        this.listItemType = value;
    }

    /**
     * Gets the value of the bgColor property.
     */
    public byte[] getBgColor() {
        return bgColor;
    }

    /**
     * Sets the value of the bgColor property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setBgColor(byte[] value) {
        this.bgColor = value;
    }

    /**
     * Gets the value of the itemIcon property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemIcon property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemIcon().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemIconType }
     */
    public List<ItemIconType> getItemIcon() {
        if (itemIcon == null) {
            itemIcon = new ArrayList<ItemIconType>();
        }
        return this.itemIcon;
    }

    /**
     * Gets the value of the maxSnippetLines property.
     */
    public Integer getMaxSnippetLines() {
        return maxSnippetLines;
    }

    /**
     * Sets the value of the maxSnippetLines property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     */
    public void setMaxSnippetLines(Integer value) {
        this.maxSnippetLines = value;
    }

    /**
     * Gets the value of the listStyleSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listStyleSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListStyleSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getListStyleSimpleExtensionGroup() {
        if (listStyleSimpleExtensionGroup == null) {
            listStyleSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.listStyleSimpleExtensionGroup;
    }

    /**
     * Gets the value of the listStyleObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listStyleObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListStyleObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getListStyleObjectExtensionGroup() {
        if (listStyleObjectExtensionGroup == null) {
            listStyleObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.listStyleObjectExtensionGroup;
    }

}
