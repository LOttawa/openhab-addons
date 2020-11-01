package org.openhab.binding.dwdweatherforecast.internal.model.xml;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

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
