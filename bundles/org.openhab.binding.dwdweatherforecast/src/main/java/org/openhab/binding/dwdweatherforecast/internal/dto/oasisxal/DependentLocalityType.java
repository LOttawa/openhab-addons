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

package org.openhab.binding.dwdweatherforecast.internal.dto.oasisxal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * <p>Java class for DependentLocalityType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DependentLocalityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="DependentLocalityName" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
 *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                 &lt;anyAttribute namespace='##other'/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="DependentLocalityNumber" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
 *                 &lt;attribute name="NameNumberOccurrence"&gt;
 *                   &lt;simpleType&gt;
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *                       &lt;enumeration value="Before"/&gt;
 *                       &lt;enumeration value="After"/&gt;
 *                     &lt;/restriction&gt;
 *                   &lt;/simpleType&gt;
 *                 &lt;/attribute&gt;
 *                 &lt;anyAttribute namespace='##other'/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PostBox"/&gt;
 *           &lt;element name="LargeMailUser" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}LargeMailUserType"/&gt;
 *           &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PostOffice"/&gt;
 *           &lt;element name="PostalRoute" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PostalRouteType"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}Thoroughfare" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}Premise" minOccurs="0"/&gt;
 *         &lt;element name="DependentLocality" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}DependentLocalityType" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PostalCode" minOccurs="0"/&gt;
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="UsageType" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="Connector" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="Indicator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;anyAttribute namespace='##other'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DependentLocalityType", propOrder = {
    "addressLine",
    "dependentLocalityName",
    "dependentLocalityNumber",
    "postBox",
    "largeMailUser",
    "postOffice",
    "postalRoute",
    "thoroughfare",
    "premise",
    "dependentLocality",
    "postalCode",
    "any"
})
public class DependentLocalityType {

    @XmlElement(name = "AddressLine")
    protected List<AddressLine> addressLine;
    @XmlElement(name = "DependentLocalityName")
    protected List<DependentLocalityType.DependentLocalityName> dependentLocalityName;
    @XmlElement(name = "DependentLocalityNumber")
    protected DependentLocalityType.DependentLocalityNumber dependentLocalityNumber;
    @XmlElement(name = "PostBox")
    protected PostBox postBox;
    @XmlElement(name = "LargeMailUser")
    protected LargeMailUserType largeMailUser;
    @XmlElement(name = "PostOffice")
    protected PostOffice postOffice;
    @XmlElement(name = "PostalRoute")
    protected PostalRouteType postalRoute;
    @XmlElement(name = "Thoroughfare")
    protected Thoroughfare thoroughfare;
    @XmlElement(name = "Premise")
    protected Premise premise;
    @XmlElement(name = "DependentLocality")
    protected DependentLocalityType dependentLocality;
    @XmlElement(name = "PostalCode")
    protected PostalCode postalCode;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "Type")
    @XmlSchemaType(name = "anySimpleType")
    protected String type;
    @XmlAttribute(name = "UsageType")
    @XmlSchemaType(name = "anySimpleType")
    protected String usageType;
    @XmlAttribute(name = "Connector")
    @XmlSchemaType(name = "anySimpleType")
    protected String connector;
    @XmlAttribute(name = "Indicator")
    @XmlSchemaType(name = "anySimpleType")
    protected String indicator;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the addressLine property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressLine property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressLine().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AddressLine }
     */
    public List<AddressLine> getAddressLine() {
        if (addressLine == null) {
            addressLine = new ArrayList<AddressLine>();
        }
        return this.addressLine;
    }

    /**
     * Gets the value of the dependentLocalityName property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dependentLocalityName property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDependentLocalityName().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DependentLocalityType.DependentLocalityName }
     */
    public List<DependentLocalityType.DependentLocalityName> getDependentLocalityName() {
        if (dependentLocalityName == null) {
            dependentLocalityName = new ArrayList<DependentLocalityType.DependentLocalityName>();
        }
        return this.dependentLocalityName;
    }

    /**
     * Gets the value of the dependentLocalityNumber property.
     */
    public DependentLocalityType.DependentLocalityNumber getDependentLocalityNumber() {
        return dependentLocalityNumber;
    }

    /**
     * Sets the value of the dependentLocalityNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link DependentLocalityType.DependentLocalityNumber }
     */
    public void setDependentLocalityNumber(DependentLocalityType.DependentLocalityNumber value) {
        this.dependentLocalityNumber = value;
    }

    /**
     * Gets the value of the postBox property.
     */
    public PostBox getPostBox() {
        return postBox;
    }

    /**
     * Sets the value of the postBox property.
     *
     * @param value
     *     allowed object is
     *     {@link PostBox }
     */
    public void setPostBox(PostBox value) {
        this.postBox = value;
    }

    /**
     * Gets the value of the largeMailUser property.
     */
    public LargeMailUserType getLargeMailUser() {
        return largeMailUser;
    }

    /**
     * Sets the value of the largeMailUser property.
     *
     * @param value
     *     allowed object is
     *     {@link LargeMailUserType }
     */
    public void setLargeMailUser(LargeMailUserType value) {
        this.largeMailUser = value;
    }

    /**
     * Gets the value of the postOffice property.
     */
    public PostOffice getPostOffice() {
        return postOffice;
    }

    /**
     * Sets the value of the postOffice property.
     *
     * @param value
     *     allowed object is
     *     {@link PostOffice }
     */
    public void setPostOffice(PostOffice value) {
        this.postOffice = value;
    }

    /**
     * Gets the value of the postalRoute property.
     */
    public PostalRouteType getPostalRoute() {
        return postalRoute;
    }

    /**
     * Sets the value of the postalRoute property.
     *
     * @param value
     *     allowed object is
     *     {@link PostalRouteType }
     */
    public void setPostalRoute(PostalRouteType value) {
        this.postalRoute = value;
    }

    /**
     * Gets the value of the thoroughfare property.
     */
    public Thoroughfare getThoroughfare() {
        return thoroughfare;
    }

    /**
     * Sets the value of the thoroughfare property.
     *
     * @param value
     *     allowed object is
     *     {@link Thoroughfare }
     */
    public void setThoroughfare(Thoroughfare value) {
        this.thoroughfare = value;
    }

    /**
     * Gets the value of the premise property.
     */
    public Premise getPremise() {
        return premise;
    }

    /**
     * Sets the value of the premise property.
     *
     * @param value
     *     allowed object is
     *     {@link Premise }
     */
    public void setPremise(Premise value) {
        this.premise = value;
    }

    /**
     * Gets the value of the dependentLocality property.
     */
    public DependentLocalityType getDependentLocality() {
        return dependentLocality;
    }

    /**
     * Sets the value of the dependentLocality property.
     *
     * @param value
     *     allowed object is
     *     {@link DependentLocalityType }
     */
    public void setDependentLocality(DependentLocalityType value) {
        this.dependentLocality = value;
    }

    /**
     * Gets the value of the postalCode property.
     */
    public PostalCode getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     *
     * @param value
     *     allowed object is
     *     {@link PostalCode }
     */
    public void setPostalCode(PostalCode value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the any property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

    /**
     * Gets the value of the type property.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the usageType property.
     */
    public String getUsageType() {
        return usageType;
    }

    /**
     * Sets the value of the usageType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setUsageType(String value) {
        this.usageType = value;
    }

    /**
     * Gets the value of the connector property.
     */
    public String getConnector() {
        return connector;
    }

    /**
     * Sets the value of the connector property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setConnector(String value) {
        this.connector = value;
    }

    /**
     * Gets the value of the indicator property.
     */
    public String getIndicator() {
        return indicator;
    }

    /**
     * Sets the value of the indicator property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setIndicator(String value) {
        this.indicator = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     *
     * <p>
     * the map is keyed by the name of the attribute and
     * the value is the string value of the attribute.
     *
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
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
     *       &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
     *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;anyAttribute namespace='##other'/&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class DependentLocalityName {

        @XmlValue
        protected String content;
        @XmlAttribute(name = "Type")
        @XmlSchemaType(name = "anySimpleType")
        protected String type;
        @XmlAttribute(name = "Code")
        @XmlSchemaType(name = "anySimpleType")
        protected String code;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the content property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContent() {
            return content;
        }

        /**
         * Sets the value of the content property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContent(String value) {
            this.content = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * Gets the value of the code property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         * 
         * <p>
         * the map is keyed by the name of the attribute and 
         * the value is the string value of the attribute.
         * 
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         * 
         * 
         * @return
         *     always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
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
     *       &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
     *       &lt;attribute name="NameNumberOccurrence"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
     *             &lt;enumeration value="Before"/&gt;
     *             &lt;enumeration value="After"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;anyAttribute namespace='##other'/&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "content"
    })
    public static class DependentLocalityNumber {

        @XmlValue
        protected String content;
        @XmlAttribute(name = "NameNumberOccurrence")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String nameNumberOccurrence;
        @XmlAttribute(name = "Code")
        @XmlSchemaType(name = "anySimpleType")
        protected String code;
        @XmlAnyAttribute
        private Map<QName, String> otherAttributes = new HashMap<QName, String>();

        /**
         * Gets the value of the content property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getContent() {
            return content;
        }

        /**
         * Sets the value of the content property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setContent(String value) {
            this.content = value;
        }

        /**
         * Gets the value of the nameNumberOccurrence property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNameNumberOccurrence() {
            return nameNumberOccurrence;
        }

        /**
         * Sets the value of the nameNumberOccurrence property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNameNumberOccurrence(String value) {
            this.nameNumberOccurrence = value;
        }

        /**
         * Gets the value of the code property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Sets the value of the code property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

        /**
         * Gets a map that contains attributes that aren't bound to any typed property on this class.
         * 
         * <p>
         * the map is keyed by the name of the attribute and 
         * the value is the string value of the attribute.
         * 
         * the map returned by this method is live, and you can add new attribute
         * by updating the map directly. Because of this design, there's no setter.
         * 
         * 
         * @return
         *     always non-null
         */
        public Map<QName, String> getOtherAttributes() {
            return otherAttributes;
        }

    }

}
