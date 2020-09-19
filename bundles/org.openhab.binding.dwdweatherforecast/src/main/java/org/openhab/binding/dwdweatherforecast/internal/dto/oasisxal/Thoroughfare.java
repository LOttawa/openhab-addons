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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


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
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumber"/&gt;
 *           &lt;element name="ThoroughfareNumberRange"&gt;
 *             &lt;complexType&gt;
 *               &lt;complexContent&gt;
 *                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                   &lt;sequence&gt;
 *                     &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                     &lt;element name="ThoroughfareNumberFrom"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumber" maxOccurs="unbounded"/&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                             &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
 *                             &lt;anyAttribute namespace='##other'/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                     &lt;element name="ThoroughfareNumberTo"&gt;
 *                       &lt;complexType&gt;
 *                         &lt;complexContent&gt;
 *                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                             &lt;sequence&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumber" maxOccurs="unbounded"/&gt;
 *                               &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                             &lt;/sequence&gt;
 *                             &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
 *                             &lt;anyAttribute namespace='##other'/&gt;
 *                           &lt;/restriction&gt;
 *                         &lt;/complexContent&gt;
 *                       &lt;/complexType&gt;
 *                     &lt;/element&gt;
 *                   &lt;/sequence&gt;
 *                   &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
 *                   &lt;attribute name="RangeType"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *                         &lt;enumeration value="Odd"/&gt;
 *                         &lt;enumeration value="Even"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/attribute&gt;
 *                   &lt;attribute name="Indicator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                   &lt;attribute name="Separator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                   &lt;attribute name="IndicatorOccurrence"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *                         &lt;enumeration value="Before"/&gt;
 *                         &lt;enumeration value="After"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/attribute&gt;
 *                   &lt;attribute name="NumberRangeOccurrence"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *                         &lt;enumeration value="BeforeName"/&gt;
 *                         &lt;enumeration value="AfterName"/&gt;
 *                         &lt;enumeration value="BeforeType"/&gt;
 *                         &lt;enumeration value="AfterType"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/attribute&gt;
 *                   &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                   &lt;anyAttribute namespace='##other'/&gt;
 *                 &lt;/restriction&gt;
 *               &lt;/complexContent&gt;
 *             &lt;/complexType&gt;
 *           &lt;/element&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ThoroughfarePreDirection" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfarePreDirectionType" minOccurs="0"/&gt;
 *         &lt;element name="ThoroughfareLeadingType" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareLeadingTypeType" minOccurs="0"/&gt;
 *         &lt;element name="ThoroughfareName" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNameType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="ThoroughfareTrailingType" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareTrailingTypeType" minOccurs="0"/&gt;
 *         &lt;element name="ThoroughfarePostDirection" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfarePostDirectionType" minOccurs="0"/&gt;
 *         &lt;element name="DependentThoroughfare" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="ThoroughfarePreDirection" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfarePreDirectionType" minOccurs="0"/&gt;
 *                   &lt;element name="ThoroughfareLeadingType" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareLeadingTypeType" minOccurs="0"/&gt;
 *                   &lt;element name="ThoroughfareName" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNameType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                   &lt;element name="ThoroughfareTrailingType" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareTrailingTypeType" minOccurs="0"/&gt;
 *                   &lt;element name="ThoroughfarePostDirection" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfarePostDirectionType" minOccurs="0"/&gt;
 *                   &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *                 &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *                 &lt;anyAttribute namespace='##other'/&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element name="DependentLocality" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}DependentLocalityType"/&gt;
 *           &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}Premise"/&gt;
 *           &lt;element name="Firm" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}FirmType"/&gt;
 *           &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}PostalCode"/&gt;
 *         &lt;/choice&gt;
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="Type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="DependentThoroughfares"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
 *             &lt;enumeration value="Yes"/&gt;
 *             &lt;enumeration value="No"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="DependentThoroughfaresIndicator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="DependentThoroughfaresConnector" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;attribute name="DependentThoroughfaresType" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
 *       &lt;anyAttribute namespace='##other'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "addressLine",
    "thoroughfareNumberOrThoroughfareNumberRange",
    "thoroughfareNumberPrefix",
    "thoroughfareNumberSuffix",
    "thoroughfarePreDirection",
    "thoroughfareLeadingType",
    "thoroughfareName",
    "thoroughfareTrailingType",
    "thoroughfarePostDirection",
    "dependentThoroughfare",
    "dependentLocality",
    "premise",
    "firm",
    "postalCode",
    "any"
})
@XmlRootElement(name = "Thoroughfare")
public class Thoroughfare {

    @XmlElement(name = "AddressLine")
    protected List<AddressLine> addressLine;
    @XmlElements({
        @XmlElement(name = "ThoroughfareNumber", type = ThoroughfareNumber.class),
        @XmlElement(name = "ThoroughfareNumberRange", type = Thoroughfare.ThoroughfareNumberRange.class)
    })
    protected List<Object> thoroughfareNumberOrThoroughfareNumberRange;
    @XmlElement(name = "ThoroughfareNumberPrefix")
    protected List<ThoroughfareNumberPrefix> thoroughfareNumberPrefix;
    @XmlElement(name = "ThoroughfareNumberSuffix")
    protected List<ThoroughfareNumberSuffix> thoroughfareNumberSuffix;
    @XmlElement(name = "ThoroughfarePreDirection")
    protected ThoroughfarePreDirectionType thoroughfarePreDirection;
    @XmlElement(name = "ThoroughfareLeadingType")
    protected ThoroughfareLeadingTypeType thoroughfareLeadingType;
    @XmlElement(name = "ThoroughfareName")
    protected List<ThoroughfareNameType> thoroughfareName;
    @XmlElement(name = "ThoroughfareTrailingType")
    protected ThoroughfareTrailingTypeType thoroughfareTrailingType;
    @XmlElement(name = "ThoroughfarePostDirection")
    protected ThoroughfarePostDirectionType thoroughfarePostDirection;
    @XmlElement(name = "DependentThoroughfare")
    protected Thoroughfare.DependentThoroughfare dependentThoroughfare;
    @XmlElement(name = "DependentLocality")
    protected DependentLocalityType dependentLocality;
    @XmlElement(name = "Premise")
    protected Premise premise;
    @XmlElement(name = "Firm")
    protected FirmType firm;
    @XmlElement(name = "PostalCode")
    protected PostalCode postalCode;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "Type")
    @XmlSchemaType(name = "anySimpleType")
    protected String type;
    @XmlAttribute(name = "DependentThoroughfares")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String dependentThoroughfares;
    @XmlAttribute(name = "DependentThoroughfaresIndicator")
    @XmlSchemaType(name = "anySimpleType")
    protected String dependentThoroughfaresIndicator;
    @XmlAttribute(name = "DependentThoroughfaresConnector")
    @XmlSchemaType(name = "anySimpleType")
    protected String dependentThoroughfaresConnector;
    @XmlAttribute(name = "DependentThoroughfaresType")
    @XmlSchemaType(name = "anySimpleType")
    protected String dependentThoroughfaresType;
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
     * Gets the value of the thoroughfareNumberOrThoroughfareNumberRange property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thoroughfareNumberOrThoroughfareNumberRange property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThoroughfareNumberOrThoroughfareNumberRange().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThoroughfareNumber }
     * {@link Thoroughfare.ThoroughfareNumberRange }
     */
    public List<Object> getThoroughfareNumberOrThoroughfareNumberRange() {
        if (thoroughfareNumberOrThoroughfareNumberRange == null) {
            thoroughfareNumberOrThoroughfareNumberRange = new ArrayList<Object>();
        }
        return this.thoroughfareNumberOrThoroughfareNumberRange;
    }

    /**
     * Gets the value of the thoroughfareNumberPrefix property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thoroughfareNumberPrefix property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThoroughfareNumberPrefix().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThoroughfareNumberPrefix }
     */
    public List<ThoroughfareNumberPrefix> getThoroughfareNumberPrefix() {
        if (thoroughfareNumberPrefix == null) {
            thoroughfareNumberPrefix = new ArrayList<ThoroughfareNumberPrefix>();
        }
        return this.thoroughfareNumberPrefix;
    }

    /**
     * Gets the value of the thoroughfareNumberSuffix property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thoroughfareNumberSuffix property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThoroughfareNumberSuffix().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThoroughfareNumberSuffix }
     */
    public List<ThoroughfareNumberSuffix> getThoroughfareNumberSuffix() {
        if (thoroughfareNumberSuffix == null) {
            thoroughfareNumberSuffix = new ArrayList<ThoroughfareNumberSuffix>();
        }
        return this.thoroughfareNumberSuffix;
    }

    /**
     * Gets the value of the thoroughfarePreDirection property.
     */
    public ThoroughfarePreDirectionType getThoroughfarePreDirection() {
        return thoroughfarePreDirection;
    }

    /**
     * Sets the value of the thoroughfarePreDirection property.
     *
     * @param value
     *     allowed object is
     *     {@link ThoroughfarePreDirectionType }
     */
    public void setThoroughfarePreDirection(ThoroughfarePreDirectionType value) {
        this.thoroughfarePreDirection = value;
    }

    /**
     * Gets the value of the thoroughfareLeadingType property.
     */
    public ThoroughfareLeadingTypeType getThoroughfareLeadingType() {
        return thoroughfareLeadingType;
    }

    /**
     * Sets the value of the thoroughfareLeadingType property.
     *
     * @param value
     *     allowed object is
     *     {@link ThoroughfareLeadingTypeType }
     */
    public void setThoroughfareLeadingType(ThoroughfareLeadingTypeType value) {
        this.thoroughfareLeadingType = value;
    }

    /**
     * Gets the value of the thoroughfareName property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thoroughfareName property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getThoroughfareName().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ThoroughfareNameType }
     */
    public List<ThoroughfareNameType> getThoroughfareName() {
        if (thoroughfareName == null) {
            thoroughfareName = new ArrayList<ThoroughfareNameType>();
        }
        return this.thoroughfareName;
    }

    /**
     * Gets the value of the thoroughfareTrailingType property.
     */
    public ThoroughfareTrailingTypeType getThoroughfareTrailingType() {
        return thoroughfareTrailingType;
    }

    /**
     * Sets the value of the thoroughfareTrailingType property.
     *
     * @param value
     *     allowed object is
     *     {@link ThoroughfareTrailingTypeType }
     */
    public void setThoroughfareTrailingType(ThoroughfareTrailingTypeType value) {
        this.thoroughfareTrailingType = value;
    }

    /**
     * Gets the value of the thoroughfarePostDirection property.
     */
    public ThoroughfarePostDirectionType getThoroughfarePostDirection() {
        return thoroughfarePostDirection;
    }

    /**
     * Sets the value of the thoroughfarePostDirection property.
     *
     * @param value
     *     allowed object is
     *     {@link ThoroughfarePostDirectionType }
     */
    public void setThoroughfarePostDirection(ThoroughfarePostDirectionType value) {
        this.thoroughfarePostDirection = value;
    }

    /**
     * Gets the value of the dependentThoroughfare property.
     */
    public Thoroughfare.DependentThoroughfare getDependentThoroughfare() {
        return dependentThoroughfare;
    }

    /**
     * Sets the value of the dependentThoroughfare property.
     *
     * @param value
     *     allowed object is
     *     {@link Thoroughfare.DependentThoroughfare }
     */
    public void setDependentThoroughfare(Thoroughfare.DependentThoroughfare value) {
        this.dependentThoroughfare = value;
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
     * Gets the value of the firm property.
     */
    public FirmType getFirm() {
        return firm;
    }

    /**
     * Sets the value of the firm property.
     *
     * @param value
     *     allowed object is
     *     {@link FirmType }
     */
    public void setFirm(FirmType value) {
        this.firm = value;
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
     * Gets the value of the dependentThoroughfares property.
     */
    public String getDependentThoroughfares() {
        return dependentThoroughfares;
    }

    /**
     * Sets the value of the dependentThoroughfares property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setDependentThoroughfares(String value) {
        this.dependentThoroughfares = value;
    }

    /**
     * Gets the value of the dependentThoroughfaresIndicator property.
     */
    public String getDependentThoroughfaresIndicator() {
        return dependentThoroughfaresIndicator;
    }

    /**
     * Sets the value of the dependentThoroughfaresIndicator property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setDependentThoroughfaresIndicator(String value) {
        this.dependentThoroughfaresIndicator = value;
    }

    /**
     * Gets the value of the dependentThoroughfaresConnector property.
     */
    public String getDependentThoroughfaresConnector() {
        return dependentThoroughfaresConnector;
    }

    /**
     * Sets the value of the dependentThoroughfaresConnector property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setDependentThoroughfaresConnector(String value) {
        this.dependentThoroughfaresConnector = value;
    }

    /**
     * Gets the value of the dependentThoroughfaresType property.
     */
    public String getDependentThoroughfaresType() {
        return dependentThoroughfaresType;
    }

    /**
     * Sets the value of the dependentThoroughfaresType property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setDependentThoroughfaresType(String value) {
        this.dependentThoroughfaresType = value;
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
     *       &lt;sequence&gt;
     *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="ThoroughfarePreDirection" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfarePreDirectionType" minOccurs="0"/&gt;
     *         &lt;element name="ThoroughfareLeadingType" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareLeadingTypeType" minOccurs="0"/&gt;
     *         &lt;element name="ThoroughfareName" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNameType" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="ThoroughfareTrailingType" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareTrailingTypeType" minOccurs="0"/&gt;
     *         &lt;element name="ThoroughfarePostDirection" type="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfarePostDirectionType" minOccurs="0"/&gt;
     *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
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
        "addressLine",
        "thoroughfarePreDirection",
        "thoroughfareLeadingType",
        "thoroughfareName",
        "thoroughfareTrailingType",
        "thoroughfarePostDirection",
        "any"
    })
    public static class DependentThoroughfare {

        @XmlElement(name = "AddressLine")
        protected List<AddressLine> addressLine;
        @XmlElement(name = "ThoroughfarePreDirection")
        protected ThoroughfarePreDirectionType thoroughfarePreDirection;
        @XmlElement(name = "ThoroughfareLeadingType")
        protected ThoroughfareLeadingTypeType thoroughfareLeadingType;
        @XmlElement(name = "ThoroughfareName")
        protected List<ThoroughfareNameType> thoroughfareName;
        @XmlElement(name = "ThoroughfareTrailingType")
        protected ThoroughfareTrailingTypeType thoroughfareTrailingType;
        @XmlElement(name = "ThoroughfarePostDirection")
        protected ThoroughfarePostDirectionType thoroughfarePostDirection;
        @XmlAnyElement(lax = true)
        protected List<Object> any;
        @XmlAttribute(name = "Type")
        @XmlSchemaType(name = "anySimpleType")
        protected String type;
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
         * 
         * 
         */
        public List<AddressLine> getAddressLine() {
            if (addressLine == null) {
                addressLine = new ArrayList<AddressLine>();
            }
            return this.addressLine;
        }

        /**
         * Gets the value of the thoroughfarePreDirection property.
         * 
         * @return
         *     possible object is
         *     {@link ThoroughfarePreDirectionType }
         *     
         */
        public ThoroughfarePreDirectionType getThoroughfarePreDirection() {
            return thoroughfarePreDirection;
        }

        /**
         * Sets the value of the thoroughfarePreDirection property.
         * 
         * @param value
         *     allowed object is
         *     {@link ThoroughfarePreDirectionType }
         *     
         */
        public void setThoroughfarePreDirection(ThoroughfarePreDirectionType value) {
            this.thoroughfarePreDirection = value;
        }

        /**
         * Gets the value of the thoroughfareLeadingType property.
         * 
         * @return
         *     possible object is
         *     {@link ThoroughfareLeadingTypeType }
         *     
         */
        public ThoroughfareLeadingTypeType getThoroughfareLeadingType() {
            return thoroughfareLeadingType;
        }

        /**
         * Sets the value of the thoroughfareLeadingType property.
         * 
         * @param value
         *     allowed object is
         *     {@link ThoroughfareLeadingTypeType }
         *     
         */
        public void setThoroughfareLeadingType(ThoroughfareLeadingTypeType value) {
            this.thoroughfareLeadingType = value;
        }

        /**
         * Gets the value of the thoroughfareName property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the thoroughfareName property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getThoroughfareName().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ThoroughfareNameType }
         * 
         * 
         */
        public List<ThoroughfareNameType> getThoroughfareName() {
            if (thoroughfareName == null) {
                thoroughfareName = new ArrayList<ThoroughfareNameType>();
            }
            return this.thoroughfareName;
        }

        /**
         * Gets the value of the thoroughfareTrailingType property.
         * 
         * @return
         *     possible object is
         *     {@link ThoroughfareTrailingTypeType }
         *     
         */
        public ThoroughfareTrailingTypeType getThoroughfareTrailingType() {
            return thoroughfareTrailingType;
        }

        /**
         * Sets the value of the thoroughfareTrailingType property.
         * 
         * @param value
         *     allowed object is
         *     {@link ThoroughfareTrailingTypeType }
         *     
         */
        public void setThoroughfareTrailingType(ThoroughfareTrailingTypeType value) {
            this.thoroughfareTrailingType = value;
        }

        /**
         * Gets the value of the thoroughfarePostDirection property.
         * 
         * @return
         *     possible object is
         *     {@link ThoroughfarePostDirectionType }
         *     
         */
        public ThoroughfarePostDirectionType getThoroughfarePostDirection() {
            return thoroughfarePostDirection;
        }

        /**
         * Sets the value of the thoroughfarePostDirection property.
         * 
         * @param value
         *     allowed object is
         *     {@link ThoroughfarePostDirectionType }
         *     
         */
        public void setThoroughfarePostDirection(ThoroughfarePostDirectionType value) {
            this.thoroughfarePostDirection = value;
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
         * 
         * 
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
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
     *       &lt;sequence&gt;
     *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
     *         &lt;element name="ThoroughfareNumberFrom"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumber" maxOccurs="unbounded"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
     *                 &lt;anyAttribute namespace='##other'/&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="ThoroughfareNumberTo"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumber" maxOccurs="unbounded"/&gt;
     *                   &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
     *                 &lt;anyAttribute namespace='##other'/&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *       &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
     *       &lt;attribute name="RangeType"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
     *             &lt;enumeration value="Odd"/&gt;
     *             &lt;enumeration value="Even"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="Indicator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;attribute name="Separator" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&gt;
     *       &lt;attribute name="IndicatorOccurrence"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
     *             &lt;enumeration value="Before"/&gt;
     *             &lt;enumeration value="After"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
     *       &lt;attribute name="NumberRangeOccurrence"&gt;
     *         &lt;simpleType&gt;
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN"&gt;
     *             &lt;enumeration value="BeforeName"/&gt;
     *             &lt;enumeration value="AfterName"/&gt;
     *             &lt;enumeration value="BeforeType"/&gt;
     *             &lt;enumeration value="AfterType"/&gt;
     *           &lt;/restriction&gt;
     *         &lt;/simpleType&gt;
     *       &lt;/attribute&gt;
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
        "addressLine",
        "thoroughfareNumberFrom",
        "thoroughfareNumberTo"
    })
    public static class ThoroughfareNumberRange {

        @XmlElement(name = "AddressLine")
        protected List<AddressLine> addressLine;
        @XmlElement(name = "ThoroughfareNumberFrom", required = true)
        protected Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom thoroughfareNumberFrom;
        @XmlElement(name = "ThoroughfareNumberTo", required = true)
        protected Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo thoroughfareNumberTo;
        @XmlAttribute(name = "RangeType")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String rangeType;
        @XmlAttribute(name = "Indicator")
        @XmlSchemaType(name = "anySimpleType")
        protected String indicator;
        @XmlAttribute(name = "Separator")
        @XmlSchemaType(name = "anySimpleType")
        protected String separator;
        @XmlAttribute(name = "IndicatorOccurrence")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String indicatorOccurrence;
        @XmlAttribute(name = "NumberRangeOccurrence")
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        protected String numberRangeOccurrence;
        @XmlAttribute(name = "Type")
        @XmlSchemaType(name = "anySimpleType")
        protected String type;
        @XmlAttribute(name = "Code")
        @XmlSchemaType(name = "anySimpleType")
        protected String code;
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
         * 
         * 
         */
        public List<AddressLine> getAddressLine() {
            if (addressLine == null) {
                addressLine = new ArrayList<AddressLine>();
            }
            return this.addressLine;
        }

        /**
         * Gets the value of the thoroughfareNumberFrom property.
         * 
         * @return
         *     possible object is
         *     {@link Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom }
         *     
         */
        public Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom getThoroughfareNumberFrom() {
            return thoroughfareNumberFrom;
        }

        /**
         * Sets the value of the thoroughfareNumberFrom property.
         * 
         * @param value
         *     allowed object is
         *     {@link Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom }
         *     
         */
        public void setThoroughfareNumberFrom(Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberFrom value) {
            this.thoroughfareNumberFrom = value;
        }

        /**
         * Gets the value of the thoroughfareNumberTo property.
         * 
         * @return
         *     possible object is
         *     {@link Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo }
         *     
         */
        public Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo getThoroughfareNumberTo() {
            return thoroughfareNumberTo;
        }

        /**
         * Sets the value of the thoroughfareNumberTo property.
         * 
         * @param value
         *     allowed object is
         *     {@link Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo }
         *     
         */
        public void setThoroughfareNumberTo(Thoroughfare.ThoroughfareNumberRange.ThoroughfareNumberTo value) {
            this.thoroughfareNumberTo = value;
        }

        /**
         * Gets the value of the rangeType property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getRangeType() {
            return rangeType;
        }

        /**
         * Sets the value of the rangeType property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setRangeType(String value) {
            this.rangeType = value;
        }

        /**
         * Gets the value of the indicator property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
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
         *     
         */
        public void setIndicator(String value) {
            this.indicator = value;
        }

        /**
         * Gets the value of the separator property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSeparator() {
            return separator;
        }

        /**
         * Sets the value of the separator property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSeparator(String value) {
            this.separator = value;
        }

        /**
         * Gets the value of the indicatorOccurrence property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIndicatorOccurrence() {
            return indicatorOccurrence;
        }

        /**
         * Sets the value of the indicatorOccurrence property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIndicatorOccurrence(String value) {
            this.indicatorOccurrence = value;
        }

        /**
         * Gets the value of the numberRangeOccurrence property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNumberRangeOccurrence() {
            return numberRangeOccurrence;
        }

        /**
         * Sets the value of the numberRangeOccurrence property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNumberRangeOccurrence(String value) {
            this.numberRangeOccurrence = value;
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
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumber" maxOccurs="unbounded"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
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
        public static class ThoroughfareNumberFrom {

            @XmlElementRefs({
                @XmlElementRef(name = "AddressLine", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = AddressLine.class),
                @XmlElementRef(name = "ThoroughfareNumberPrefix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumberPrefix.class),
                @XmlElementRef(name = "ThoroughfareNumber", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumber.class),
                @XmlElementRef(name = "ThoroughfareNumberSuffix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumberSuffix.class)
            })
            @XmlMixed
            protected List<Object> content;
            @XmlAttribute(name = "Code")
            @XmlSchemaType(name = "anySimpleType")
            protected String code;
            @XmlAnyAttribute
            private Map<QName, String> otherAttributes = new HashMap<QName, String>();

            /**
             * Gets the value of the content property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the content property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContent().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AddressLine }
             * {@link ThoroughfareNumberPrefix }
             * {@link ThoroughfareNumber }
             * {@link ThoroughfareNumberSuffix }
             * {@link String }
             * 
             * 
             */
            public List<Object> getContent() {
                if (content == null) {
                    content = new ArrayList<Object>();
                }
                return this.content;
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
         *       &lt;sequence&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressLine" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberPrefix" maxOccurs="unbounded" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumber" maxOccurs="unbounded"/&gt;
         *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}ThoroughfareNumberSuffix" maxOccurs="unbounded" minOccurs="0"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attGroup ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}grPostal"/&gt;
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
        public static class ThoroughfareNumberTo {

            @XmlElementRefs({
                @XmlElementRef(name = "AddressLine", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = AddressLine.class),
                @XmlElementRef(name = "ThoroughfareNumberPrefix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumberPrefix.class),
                @XmlElementRef(name = "ThoroughfareNumber", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumber.class),
                @XmlElementRef(name = "ThoroughfareNumberSuffix", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0", type = ThoroughfareNumberSuffix.class)
            })
            @XmlMixed
            protected List<Object> content;
            @XmlAttribute(name = "Code")
            @XmlSchemaType(name = "anySimpleType")
            protected String code;
            @XmlAnyAttribute
            private Map<QName, String> otherAttributes = new HashMap<QName, String>();

            /**
             * Gets the value of the content property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the content property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getContent().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link AddressLine }
             * {@link ThoroughfareNumberPrefix }
             * {@link ThoroughfareNumber }
             * {@link ThoroughfareNumberSuffix }
             * {@link String }
             * 
             * 
             */
            public List<Object> getContent() {
                if (content == null) {
                    content = new ArrayList<Object>();
                }
                return this.content;
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

}
