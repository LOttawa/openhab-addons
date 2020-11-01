package org.openhab.binding.dwdweatherforecast.internal.model.xml;

import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class ProductDefinition {
    
    @XStreamAlias("Issuer")
    private String issuer;
    @XStreamAlias("ProductID")
    private String productID;
    @XStreamAlias("GeneratingProcess")
    private String generatingProcess;
    @XStreamAlias("IssueTime")
    private Date issueTime;
    @XStreamAlias("ReferencedModel")
    private ReferencedModel referencedModel;
    @XStreamAlias("ForecastTimeSteps")
    private ForecastTimeSteps forecastTimeSteps;
    @XStreamAlias("FormatCfg")
    private FormatCfg formatCfg;

    public String getIssuer() {
        return this.issuer;
    }
    public String getProductID() {
        return this.productID;
    }
    public String getGeneratingProcess() {
        return this.generatingProcess;
    }
    public Date getIssueTime() {
        return this.issueTime;
    }
    public ReferencedModel getReferencedModel() {
        return this.referencedModel;
    }
    public ForecastTimeSteps getForecastTimeSteps() {
        return this.forecastTimeSteps;
    }
    public FormatCfg getFormatCfg() {
        return this.formatCfg;
    }

    public class ForecastTimeSteps {

        @XStreamImplicit(itemFieldName = "TimeStep")
        private List<Date> timeStep;
        
    }

    private class ReferencedModel {

        @XStreamImplicit(itemFieldName = "Model")
        private List<Model> models;
    
        public List<Model> getModels() {
            return this.models;
        }  
        
    }

    private class Model {
    
        private String name;

        private Date referenceTime;

        public String getName() {
            return this.name;
        }
        public Date getReferenceTime() {
            return this.referenceTime;
        }

    }
    
    private class FormatCfg {

        @XStreamAlias("DefaultUndefSign")
        private String defaultUndefSign;

        public String getDefaultUndefSign() {
            return this.defaultUndefSign;
        }   

    }

}
