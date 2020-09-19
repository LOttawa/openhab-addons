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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Issuer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ProductID"&gt;
 *           &lt;simpleType&gt;
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *               &lt;enumeration value="EZ_MOS"/&gt;
 *               &lt;enumeration value="ICON_MOS"/&gt;
 *               &lt;enumeration value="MOSMIX"/&gt;
 *               &lt;enumeration value="COSMO_DE_EPS_EMOS"/&gt;
 *               &lt;enumeration value="MODELMIX"/&gt;
 *               &lt;enumeration value="GPTMOS"/&gt;
 *               &lt;enumeration value="ICON_DMO"/&gt;
 *               &lt;enumeration value="ICON_NEST_DMO"/&gt;
 *             &lt;/restriction&gt;
 *           &lt;/simpleType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="GeneratingProcess" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="IssueTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="ReferencedModel"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Model" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *                           &lt;attribute name="referenceTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="ForecastTimeSteps"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="TimeStep" type="{http://www.w3.org/2001/XMLSchema}dateTime" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="FormatCfg"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="DefaultUndefSign" type="{https://opendata.dwd.de/weather/lib/pointforecast_dwd_extension_V1_0.xsd}UndefChar"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="MetElementDefinition" type="{http://www.w3.org/2001/XMLSchema}anyURI"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "issuer",
    "productID",
    "generatingProcess",
    "issueTime",
    "referencedModel",
    "forecastTimeSteps",
    "formatCfg",
    "metElementDefinition"
})
@XmlRootElement(name = "ProductDefinition")
public class ProductDefinition {

    @XmlElement(name = "Issuer", required = true)
    protected String issuer;
    @XmlElement(name = "ProductID", required = true)
    protected String productID;
    @XmlElement(name = "GeneratingProcess", required = true)
    protected String generatingProcess;
    @XmlElement(name = "IssueTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar issueTime;
    @XmlElement(name = "ReferencedModel", required = true)
    protected ProductDefinition.ReferencedModel referencedModel;
    @XmlElement(name = "ForecastTimeSteps", required = true)
    protected ProductDefinition.ForecastTimeSteps forecastTimeSteps;
    @XmlElement(name = "FormatCfg", required = true)
    protected ProductDefinition.FormatCfg formatCfg;
    @XmlElement(name = "MetElementDefinition", required = true, defaultValue = "https://opendata.dwd.de/weather/lib/MetElementDefinition.xml")
    @XmlSchemaType(name = "anyURI")
    protected String metElementDefinition;

    /**
     * Gets the value of the issuer property.
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * Sets the value of the issuer property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setIssuer(String value) {
        this.issuer = value;
    }

    /**
     * Gets the value of the productID property.
     */
    public String getProductID() {
        return productID;
    }

    /**
     * Sets the value of the productID property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setProductID(String value) {
        this.productID = value;
    }

    /**
     * Gets the value of the generatingProcess property.
     */
    public String getGeneratingProcess() {
        return generatingProcess;
    }

    /**
     * Sets the value of the generatingProcess property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setGeneratingProcess(String value) {
        this.generatingProcess = value;
    }

    /**
     * Gets the value of the issueTime property.
     */
    public XMLGregorianCalendar getIssueTime() {
        return issueTime;
    }

    /**
     * Sets the value of the issueTime property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     */
    public void setIssueTime(XMLGregorianCalendar value) {
        this.issueTime = value;
    }

    /**
     * Gets the value of the referencedModel property.
     */
    public ProductDefinition.ReferencedModel getReferencedModel() {
        return referencedModel;
    }

    /**
     * Sets the value of the referencedModel property.
     *
     * @param value
     *     allowed object is
     *     {@link ProductDefinition.ReferencedModel }
     */
    public void setReferencedModel(ProductDefinition.ReferencedModel value) {
        this.referencedModel = value;
    }

    /**
     * Gets the value of the forecastTimeSteps property.
     */
    public ProductDefinition.ForecastTimeSteps getForecastTimeSteps() {
        return forecastTimeSteps;
    }

    /**
     * Sets the value of the forecastTimeSteps property.
     *
     * @param value
     *     allowed object is
     *     {@link ProductDefinition.ForecastTimeSteps }
     */
    public void setForecastTimeSteps(ProductDefinition.ForecastTimeSteps value) {
        this.forecastTimeSteps = value;
    }

    /**
     * Gets the value of the formatCfg property.
     */
    public ProductDefinition.FormatCfg getFormatCfg() {
        return formatCfg;
    }

    /**
     * Sets the value of the formatCfg property.
     *
     * @param value
     *     allowed object is
     *     {@link ProductDefinition.FormatCfg }
     */
    public void setFormatCfg(ProductDefinition.FormatCfg value) {
        this.formatCfg = value;
    }

    /**
     * Gets the value of the metElementDefinition property.
     */
    public String getMetElementDefinition() {
        return metElementDefinition;
    }

    /**
     * Sets the value of the metElementDefinition property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setMetElementDefinition(String value) {
        this.metElementDefinition = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="TimeStep" type="{http://www.w3.org/2001/XMLSchema}dateTime" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "timeStep"
    })
    public static class ForecastTimeSteps {

        @XmlElement(name = "TimeStep")
        @XmlSchemaType(name = "dateTime")
        protected List<XMLGregorianCalendar> timeStep;

        /**
         * Gets the value of the timeStep property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the timeStep property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTimeStep().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link XMLGregorianCalendar }
         * 
         * 
         */
        public List<XMLGregorianCalendar> getTimeStep() {
            if (timeStep == null) {
                timeStep = new ArrayList<XMLGregorianCalendar>();
            }
            return this.timeStep;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="DefaultUndefSign" type="{https://opendata.dwd.de/weather/lib/pointforecast_dwd_extension_V1_0.xsd}UndefChar"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "defaultUndefSign"
    })
    public static class FormatCfg {

        @XmlElement(name = "DefaultUndefSign", required = true, defaultValue = "-")
        protected String defaultUndefSign;

        /**
         * Gets the value of the defaultUndefSign property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDefaultUndefSign() {
            return defaultUndefSign;
        }

        /**
         * Sets the value of the defaultUndefSign property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDefaultUndefSign(String value) {
            this.defaultUndefSign = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Model" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
     *                 &lt;attribute name="referenceTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "model"
    })
    public static class ReferencedModel {

        @XmlElement(name = "Model")
        protected List<ProductDefinition.ReferencedModel.Model> model;

        /**
         * Gets the value of the model property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the model property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getModel().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ProductDefinition.ReferencedModel.Model }
         * 
         * 
         */
        public List<ProductDefinition.ReferencedModel.Model> getModel() {
            if (model == null) {
                model = new ArrayList<ProductDefinition.ReferencedModel.Model>();
            }
            return this.model;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
         *       &lt;attribute name="referenceTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Model {

            @XmlAttribute(name = "name", namespace = "https://opendata.dwd.de/weather/lib/pointforecast_dwd_extension_V1_0.xsd", required = true)
            protected String name;
            @XmlAttribute(name = "referenceTime", namespace = "https://opendata.dwd.de/weather/lib/pointforecast_dwd_extension_V1_0.xsd", required = true)
            @XmlSchemaType(name = "dateTime")
            protected XMLGregorianCalendar referenceTime;

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the referenceTime property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getReferenceTime() {
                return referenceTime;
            }

            /**
             * Sets the value of the referenceTime property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setReferenceTime(XMLGregorianCalendar value) {
                this.referenceTime = value;
            }

        }

    }

}
