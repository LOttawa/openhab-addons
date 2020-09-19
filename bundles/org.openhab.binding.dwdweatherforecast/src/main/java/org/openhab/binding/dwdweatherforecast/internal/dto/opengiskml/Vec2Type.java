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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for vec2Type complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="vec2Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}double" default="1.0" /&gt;
 *       &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}double" default="1.0" /&gt;
 *       &lt;attribute name="xunits" type="{http://www.opengis.net/kml/2.2}unitsEnumType" default="fraction" /&gt;
 *       &lt;attribute name="yunits" type="{http://www.opengis.net/kml/2.2}unitsEnumType" default="fraction" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vec2Type")
public class Vec2Type {

    @XmlAttribute(name = "x")
    protected Double x;
    @XmlAttribute(name = "y")
    protected Double y;
    @XmlAttribute(name = "xunits")
    protected UnitsEnumType xunits;
    @XmlAttribute(name = "yunits")
    protected UnitsEnumType yunits;

    /**
     * Gets the value of the x property.
     */
    public double getX() {
        if (x == null) {
            return  1.0D;
        } else {
            return x;
        }
    }

    /**
     * Sets the value of the x property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setX(Double value) {
        this.x = value;
    }

    /**
     * Gets the value of the y property.
     */
    public double getY() {
        if (y == null) {
            return  1.0D;
        } else {
            return y;
        }
    }

    /**
     * Sets the value of the y property.
     *
     * @param value
     *     allowed object is
     *     {@link Double }
     */
    public void setY(Double value) {
        this.y = value;
    }

    /**
     * Gets the value of the xunits property.
     */
    public UnitsEnumType getXunits() {
        if (xunits == null) {
            return UnitsEnumType.FRACTION;
        } else {
            return xunits;
        }
    }

    /**
     * Sets the value of the xunits property.
     *
     * @param value
     *     allowed object is
     *     {@link UnitsEnumType }
     */
    public void setXunits(UnitsEnumType value) {
        this.xunits = value;
    }

    /**
     * Gets the value of the yunits property.
     */
    public UnitsEnumType getYunits() {
        if (yunits == null) {
            return UnitsEnumType.FRACTION;
        } else {
            return yunits;
        }
    }

    /**
     * Sets the value of the yunits property.
     *
     * @param value
     *     allowed object is
     *     {@link UnitsEnumType }
     */
    public void setYunits(UnitsEnumType value) {
        this.yunits = value;
    }

}
