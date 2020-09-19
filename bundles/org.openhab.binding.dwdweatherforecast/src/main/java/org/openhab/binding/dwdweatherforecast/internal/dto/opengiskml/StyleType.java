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
 * <p>Java class for StyleType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StyleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractStyleSelectorType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}IconStyle" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LabelStyle" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}LineStyle" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}PolyStyle" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}BalloonStyle" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}ListStyle" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}StyleSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}StyleObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StyleType", propOrder = {
    "iconStyle",
    "labelStyle",
    "lineStyle",
    "polyStyle",
    "balloonStyle",
    "listStyle",
    "styleSimpleExtensionGroup",
    "styleObjectExtensionGroup"
})
public class StyleType
    extends AbstractStyleSelectorType
{

    @XmlElement(name = "IconStyle")
    protected IconStyleType iconStyle;
    @XmlElement(name = "LabelStyle")
    protected LabelStyleType labelStyle;
    @XmlElement(name = "LineStyle")
    protected LineStyleType lineStyle;
    @XmlElement(name = "PolyStyle")
    protected PolyStyleType polyStyle;
    @XmlElement(name = "BalloonStyle")
    protected BalloonStyleType balloonStyle;
    @XmlElement(name = "ListStyle")
    protected ListStyleType listStyle;
    @XmlElement(name = "StyleSimpleExtensionGroup")
    protected List<Object> styleSimpleExtensionGroup;
    @XmlElement(name = "StyleObjectExtensionGroup")
    protected List<AbstractObjectType> styleObjectExtensionGroup;

    /**
     * Gets the value of the iconStyle property.
     */
    public IconStyleType getIconStyle() {
        return iconStyle;
    }

    /**
     * Sets the value of the iconStyle property.
     *
     * @param value
     *     allowed object is
     *     {@link IconStyleType }
     */
    public void setIconStyle(IconStyleType value) {
        this.iconStyle = value;
    }

    /**
     * Gets the value of the labelStyle property.
     */
    public LabelStyleType getLabelStyle() {
        return labelStyle;
    }

    /**
     * Sets the value of the labelStyle property.
     *
     * @param value
     *     allowed object is
     *     {@link LabelStyleType }
     */
    public void setLabelStyle(LabelStyleType value) {
        this.labelStyle = value;
    }

    /**
     * Gets the value of the lineStyle property.
     */
    public LineStyleType getLineStyle() {
        return lineStyle;
    }

    /**
     * Sets the value of the lineStyle property.
     *
     * @param value
     *     allowed object is
     *     {@link LineStyleType }
     */
    public void setLineStyle(LineStyleType value) {
        this.lineStyle = value;
    }

    /**
     * Gets the value of the polyStyle property.
     */
    public PolyStyleType getPolyStyle() {
        return polyStyle;
    }

    /**
     * Sets the value of the polyStyle property.
     *
     * @param value
     *     allowed object is
     *     {@link PolyStyleType }
     */
    public void setPolyStyle(PolyStyleType value) {
        this.polyStyle = value;
    }

    /**
     * Gets the value of the balloonStyle property.
     */
    public BalloonStyleType getBalloonStyle() {
        return balloonStyle;
    }

    /**
     * Sets the value of the balloonStyle property.
     *
     * @param value
     *     allowed object is
     *     {@link BalloonStyleType }
     */
    public void setBalloonStyle(BalloonStyleType value) {
        this.balloonStyle = value;
    }

    /**
     * Gets the value of the listStyle property.
     */
    public ListStyleType getListStyle() {
        return listStyle;
    }

    /**
     * Sets the value of the listStyle property.
     *
     * @param value
     *     allowed object is
     *     {@link ListStyleType }
     */
    public void setListStyle(ListStyleType value) {
        this.listStyle = value;
    }

    /**
     * Gets the value of the styleSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the styleSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStyleSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getStyleSimpleExtensionGroup() {
        if (styleSimpleExtensionGroup == null) {
            styleSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.styleSimpleExtensionGroup;
    }

    /**
     * Gets the value of the styleObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the styleObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStyleObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getStyleObjectExtensionGroup() {
        if (styleObjectExtensionGroup == null) {
            styleObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.styleObjectExtensionGroup;
    }

}
