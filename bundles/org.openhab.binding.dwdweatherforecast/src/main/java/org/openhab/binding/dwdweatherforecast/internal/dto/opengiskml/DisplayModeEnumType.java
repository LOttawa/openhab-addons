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

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for displayModeEnumType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="displayModeEnumType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="default"/&gt;
 *     &lt;enumeration value="hide"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlType(name = "displayModeEnumType")
@XmlEnum
public enum DisplayModeEnumType {

    @XmlEnumValue("default")
    DEFAULT("default"),
    @XmlEnumValue("hide")
    HIDE("hide");
    private final String value;

    DisplayModeEnumType(String v) {
        value = v;
    }

    /**
     * <p>value.</p>
     */
    public String value() {
        return value;
    }

    /**
     * <p>fromValue.</p>
     */
    public static DisplayModeEnumType fromValue(String v) {
        for (DisplayModeEnumType c: DisplayModeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
