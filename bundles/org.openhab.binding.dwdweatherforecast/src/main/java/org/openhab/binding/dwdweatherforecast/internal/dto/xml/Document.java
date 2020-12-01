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

/**
 *
 * @author Lars Ottawa - Initial contribution
 */
public class Document {
    
    @XStreamAlias("ExtendedData")
    private ExtendedData extendedData;
    @XStreamAlias("Placemark")
    private Placemark placemark;

    public ExtendedData getExtendedData() {
        return this.extendedData;
    }
    public Placemark getPlacemark() {
        return this.placemark;
    }

    public class Placemark {

        @XStreamAlias("name")
        private String name;
        @XStreamAlias("description")
        private String description;
        @XStreamAlias("ExtendedData")
        private ExtendedData extendedData;
        @XStreamAlias("Point")
        private Point point;

        public String getName() {
            return this.name;
        }
        public String getDescription() {
            return this.description;
        }
        public ExtendedData getExtendedData() {
            return this.extendedData;
        }
        public Point getPoint() {
            return this.point;
        }
    }

    public class Point {

        @XStreamAlias("coordinates")
        private String coordinates;

        public String getCoordinates() {
            return this.coordinates;
        }

    }

}
