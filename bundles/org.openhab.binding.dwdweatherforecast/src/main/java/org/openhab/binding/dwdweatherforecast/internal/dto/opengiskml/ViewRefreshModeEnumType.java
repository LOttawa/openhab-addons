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
 * <p>Java class for viewRefreshModeEnumType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="viewRefreshModeEnumType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="never"/&gt;
 *     &lt;enumeration value="onRequest"/&gt;
 *     &lt;enumeration value="onStop"/&gt;
 *     &lt;enumeration value="onRegion"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlType(name = "viewRefreshModeEnumType")
@XmlEnum
public enum ViewRefreshModeEnumType {

    @XmlEnumValue("never")
    NEVER("never"),
    @XmlEnumValue("onRequest")
    ON_REQUEST("onRequest"),
    @XmlEnumValue("onStop")
    ON_STOP("onStop"),
    @XmlEnumValue("onRegion")
    ON_REGION("onRegion");
    private final String value;

    ViewRefreshModeEnumType(String v) {
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
    public static ViewRefreshModeEnumType fromValue(String v) {
        for (ViewRefreshModeEnumType c: ViewRefreshModeEnumType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
