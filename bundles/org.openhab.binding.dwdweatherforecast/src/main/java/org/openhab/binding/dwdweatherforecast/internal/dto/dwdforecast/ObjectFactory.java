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

package org.openhab.binding.dwdweatherforecast.internal.dto.dwdforecast;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the org.openhab.binding.dwdweatherforecast.internal.dto.dwdforecast package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.openhab.binding.dwdweatherforecast.internal.dto.dwdforecast
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProductDefinition }
     */
    public ProductDefinition createProductDefinition() {
        return new ProductDefinition();
    }

    /**
     * Create an instance of {@link Forecast }
     */
    public Forecast createForecast() {
        return new Forecast();
    }

    /**
     * Create an instance of {@link ProductDefinition.ReferencedModel }
     */
    public ProductDefinition.ReferencedModel createProductDefinitionReferencedModel() {
        return new ProductDefinition.ReferencedModel();
    }

    /**
     * Create an instance of {@link ProductDefinition.ForecastTimeSteps }
     */
    public ProductDefinition.ForecastTimeSteps createProductDefinitionForecastTimeSteps() {
        return new ProductDefinition.ForecastTimeSteps();
    }

    /**
     * Create an instance of {@link ProductDefinition.FormatCfg }
     */
    public ProductDefinition.FormatCfg createProductDefinitionFormatCfg() {
        return new ProductDefinition.FormatCfg();
    }

    /**
     * Create an instance of {@link Forecast.Value }
     */
    public Forecast.Value createForecastValue() {
        return new Forecast.Value();
    }

    /**
     * Create an instance of {@link ProductDefinition.ReferencedModel.Model }
     */
    public ProductDefinition.ReferencedModel.Model createProductDefinitionReferencedModelModel() {
        return new ProductDefinition.ReferencedModel.Model();
    }

}
