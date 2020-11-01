package org.openhab.binding.dwdweatherforecast.internal.model.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class Kml {
    
    @XStreamAlias("Document")
    private Document document;

    public Document getDocument() {
        return this.document;
    }
}
