package org.openhab.binding.dwdweatherforecast.internal.model.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

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

    private class Placemark {

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

    private class Point {

        @XStreamAlias("coordinates")
        private String coordinates;

        public String getCoordinates() {
            return this.coordinates;
        }

    }

}
