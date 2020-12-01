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

import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 *
 * @author Lars Ottawa - Initial contribution
 */
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
     
        public List<Date> getTimeStep() {
            return this.timeStep;
        }

    }

    public class ReferencedModel {

        @XStreamImplicit(itemFieldName = "Model")
        private List<Model> models;
    
        public List<Model> getModels() {
            return this.models;
        }  
        
    }

    public class Model {
    
        private String name;

        private Date referenceTime;

        public String getName() {
            return this.name;
        }
        public Date getReferenceTime() {
            return this.referenceTime;
        }

    }
    
    public class FormatCfg {

        @XStreamAlias("DefaultUndefSign")
        private String defaultUndefSign;

        public String getDefaultUndefSign() {
            return this.defaultUndefSign;
        }   

    }

}
