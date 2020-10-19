package org.openhab.binding.dwdweatherforecast.internal.model;

import java.util.Vector;

public class MosmixStationsList {
    int stationsCounter = 0;
    Vector<StationDetails> stations = new Vector<StationDetails>();

    public void addStationDetail(StationDetails station) {
        this.stations.add(station);
    }
    public Vector<StationDetails> getStationDetails() {
        return this.stations;
    }
    public void increaseStationsCounter() {
        this.stationsCounter++;
    }
    public int getMosmixStationsCounter() {
        return this.stationsCounter;
    }

    public class StationDetails {
        int clu;
        String cofX;
        String id;
        String iCAO;
        String name;
        double nb;
        double el;
        int elev;
        String hmod_h;
        String type;

        public void setClu(int clu) {
            this.clu = clu;
        }
        public int getClu() {
            return this.clu;
        }
        public void setCofX(String cofX) {
            this.cofX = cofX;
        }
        public String getCofX() {
            return this.cofX;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getId() {
            return this.id;
        }
        public void setICAO(String iCAO) {
            this.iCAO = iCAO;
        }
        public String getICAO() {
            return this.iCAO;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public void setNb(double nb) {
            this.nb = nb;
        }
        public double getNb() {
            return this.nb;
        }
        public void setEl(double el) {
            this.el = el;
        }
        public double getEl() {
            return this.el;
        }
        public void setElev(int elev) {
            this.elev = elev;
        }
        public int getElev() {
            return this.elev;
        }
        public void setHmod_h(String hmod_h) {
            this.hmod_h = hmod_h;
        }
        public String getHmod_h() {
            return this.hmod_h;
        }
        public void setType(String type) {
            this.type = type;
        }
        public String getType() {
            return this.type;
        }
    }

}
