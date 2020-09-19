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

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

/**
 * <p>Kmlname class.</p>
 *
 * @author Lars Ottawa - Initial contribution
 */
public class Kmlname
    extends JAXBElement<String>
{

    /** Constant <code>NAME</code> */
    protected final static QName NAME = new QName("http://www.opengis.net/kml/2.2", "name");

    /**
     * <p>Constructor for Kmlname.</p>
     */
    public Kmlname(String value) {
        super(NAME, ((Class) String.class), null, value);
    }

    /**
     * <p>Constructor for Kmlname.</p>
     */
    public Kmlname() {
        super(NAME, ((Class) String.class), null, null);
    }

}
