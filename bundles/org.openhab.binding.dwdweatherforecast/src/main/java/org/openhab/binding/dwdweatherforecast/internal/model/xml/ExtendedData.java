package org.openhab.binding.dwdweatherforecast.internal.model.xml;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

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
