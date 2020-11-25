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
package org.openhab.binding.dwdweatherforecast.internal.dto.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 *
 * @author Lars Ottawa - Initial contribution
 */
public class Forecast {
  
    @XStreamAlias("elementName")
    @XStreamAsAttribute
    private String elementName;
    @XStreamAlias("value")
    private String value;

    public String getElementName() {
        return this.elementName;
    }
    public String getValue() {
        return this.value;
    }

}
