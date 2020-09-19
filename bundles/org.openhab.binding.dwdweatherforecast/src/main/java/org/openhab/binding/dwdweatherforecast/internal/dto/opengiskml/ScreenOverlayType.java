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
 * <p>Java class for ScreenOverlayType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ScreenOverlayType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractOverlayType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}overlayXY" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}screenXY" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}rotationXY" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}size" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}rotation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}ScreenOverlaySimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}ScreenOverlayObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScreenOverlayType", propOrder = {
    "overlayXY",
    "screenXY",
    "rotationXY",
    "size",
    "rotation",
    "screenOverlaySimpleExtensionGroup",
    "screenOverlayObjectExtensionGroup"
})
public class ScreenOverlayType
    extends AbstractOverlayType
{

    protected Vec2Type overlayXY;
    protected Vec2Type screenXY;
    protected Vec2Type rotationXY;
    protected Vec2Type size;
    @XmlElement(defaultValue = "0.0")
    protected Double rotation;
    @XmlElement(name = "ScreenOverlaySimpleExtensionGroup")
    protected List<Object> screenOverlaySimpleExtensionGroup;
    @XmlElement(name = "ScreenOverlayObjectExtensionGroup")
    protected List<AbstractObjectType> screenOverlayObjectExtensionGroup;

    /**
     * Gets the value of the overlayXY property.
     */
    public Vec2Type getOverlayXY() {
        return overlayXY;
    }

    /**
     * Sets the value of the overlayXY property.
     *
     * @param value
     *     allowed object is
     *     {@link Vec2Type }
     */
    public void setOverlayXY(Vec2Type value) {
        this.overlayXY = value;
    }

    /**
     * Gets the value of the screenXY property.
     */
    public Vec2Type getScreenXY() {
        return screenXY;
    }

    /**
     * Sets the value of the screenXY property.
     *
     * @param value
     *     allowed object is
     *     {@link Vec2Type }
     */
    public void setScreenXY(Vec2Type value) {
        this.screenXY = value;
    }

    /**
     * Gets the value of the rotationXY property.
     */
    public Vec2Type getRotationXY() {
        return rotationXY;
    }

    /**
     * Sets the value of the rotationXY property.
     *
     * @param value
     *     allowed object is
     *     {@link Vec2Type }
     */
    public void setRotationXY(Vec2Type value) {
        this.rotationXY = value;
    }

    /**
     * Gets the value of the size property.
     */
    public Vec2Type getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     *
     * @param value
     *     allowed object is
     *     {@link Vec2Type }
     */
    public void setSize(Vec2Type value) {
        this.size = value;
    }

    /**
     * Gets the value of the rotation property.
     */
    public Double getRotation() {
        return rotation;
    }

    /**
     * Sets the value of the rotation property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setRotation(Double value) {
        this.rotation = value;
    }

    /**
     * Gets the value of the screenOverlaySimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the screenOverlaySimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScreenOverlaySimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getScreenOverlaySimpleExtensionGroup() {
        if (screenOverlaySimpleExtensionGroup == null) {
            screenOverlaySimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.screenOverlaySimpleExtensionGroup;
    }

    /**
     * Gets the value of the screenOverlayObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the screenOverlayObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScreenOverlayObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getScreenOverlayObjectExtensionGroup() {
        if (screenOverlayObjectExtensionGroup == null) {
            screenOverlayObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.screenOverlayObjectExtensionGroup;
    }

}
