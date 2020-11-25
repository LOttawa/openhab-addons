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

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 *
 * @author Lars Ottawa - Initial contribution
 */
public class ExtendedData {
    
    @XStreamAlias("ProductDefinition")
    private ProductDefinition productDefinition;
    @XStreamImplicit(itemFieldName = "Forecast")
    private List<Forecast> forecast;

    public ProductDefinition getProductDefinition() {
        return this.productDefinition;
    }
    public List<Forecast> getForecast() {
        return this.forecast;
    }

}
