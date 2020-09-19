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

package org.openhab.binding.dwdweatherforecast.internal.dto.opengiskml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.openhab.binding.dwdweatherforecast.internal.dto.oasisxal.AddressDetails;
import org.openhab.binding.dwdweatherforecast.internal.dto.w3catom.AtomPersonConstruct;
import org.openhab.binding.dwdweatherforecast.internal.dto.w3catom.Link;


/**
 * <p>Java class for AbstractFeatureType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AbstractFeatureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/kml/2.2}AbstractObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}name" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}visibility" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}open" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.w3.org/2005/Atom}author" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.w3.org/2005/Atom}link" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}address" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:ciq:xsdschema:xAL:2.0}AddressDetails" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}phoneNumber" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.opengis.net/kml/2.2}Snippet" minOccurs="0"/&gt;
 *           &lt;element ref="{http://www.opengis.net/kml/2.2}snippet" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}description" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractViewGroup" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractTimePrimitiveGroup" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}styleUrl" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractStyleSelectorGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}Region" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element ref="{http://www.opengis.net/kml/2.2}Metadata" minOccurs="0"/&gt;
 *           &lt;element ref="{http://www.opengis.net/kml/2.2}ExtendedData" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractFeatureSimpleExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/kml/2.2}AbstractFeatureObjectExtensionGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractFeatureType", propOrder = {
    "name",
    "visibility",
    "open",
    "author",
    "atomLink",
    "address",
    "addressDetails",
    "phoneNumber",
    "snippetDeprecated",
    "snippet",
    "description",
    "abstractViewGroup",
    "abstractTimePrimitiveGroup",
    "styleUrl",
    "abstractStyleSelectorGroup",
    "region",
    "metadata",
    "extendedData",
    "abstractFeatureSimpleExtensionGroup",
    "abstractFeatureObjectExtensionGroup"
})
@XmlSeeAlso({
    AbstractContainerType.class,
    PlacemarkType.class,
    NetworkLinkType.class,
    AbstractOverlayType.class
})
public abstract class AbstractFeatureType
    extends AbstractObjectType
{

    @XmlElementRef(name = "name", namespace = "http://www.opengis.net/kml/2.2", type = Kmlname.class, required = false)
    protected Kmlname name;
    @XmlElement(defaultValue = "1")
    protected Boolean visibility;
    @XmlElement(defaultValue = "0")
    protected Boolean open;
    @XmlElement(namespace = "http://www.w3.org/2005/Atom")
    protected AtomPersonConstruct author;
    @XmlElement(name = "link", namespace = "http://www.w3.org/2005/Atom")
    protected Link atomLink;
    protected String address;
    @XmlElement(name = "AddressDetails", namespace = "urn:oasis:names:tc:ciq:xsdschema:xAL:2.0")
    protected AddressDetails addressDetails;
    protected String phoneNumber;
    @XmlElement(name = "Snippet")
    protected SnippetType snippetDeprecated;
    @XmlElementRef(name = "snippet", namespace = "http://www.opengis.net/kml/2.2", type = Snippetliteral.class, required = false)
    protected Snippetliteral snippet;
    protected String description;
    @XmlElementRef(name = "AbstractViewGroup", namespace = "http://www.opengis.net/kml/2.2", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends AbstractViewType> abstractViewGroup;
    @XmlElementRef(name = "AbstractTimePrimitiveGroup", namespace = "http://www.opengis.net/kml/2.2", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends AbstractTimePrimitiveType> abstractTimePrimitiveGroup;
    @XmlSchemaType(name = "anyURI")
    protected String styleUrl;
    @XmlElementRef(name = "AbstractStyleSelectorGroup", namespace = "http://www.opengis.net/kml/2.2", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends AbstractStyleSelectorType>> abstractStyleSelectorGroup;
    @XmlElement(name = "Region")
    protected RegionType region;
    @XmlElement(name = "Metadata")
    protected MetadataType metadata;
    @XmlElement(name = "ExtendedData")
    protected ExtendedDataType extendedData;
    @XmlElement(name = "AbstractFeatureSimpleExtensionGroup")
    protected List<Object> abstractFeatureSimpleExtensionGroup;
    @XmlElement(name = "AbstractFeatureObjectExtensionGroup")
    protected List<AbstractObjectType> abstractFeatureObjectExtensionGroup;

    /**
     * Gets the value of the name property.
     */
    public Kmlname getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link Kmlname }
     */
    public void setName(Kmlname value) {
        this.name = value;
    }

    /**
     * Gets the value of the visibility property.
     */
    public Boolean isVisibility() {
        return visibility;
    }

    /**
     * Sets the value of the visibility property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     */
    public void setVisibility(Boolean value) {
        this.visibility = value;
    }

    /**
     * Gets the value of the open property.
     */
    public Boolean isOpen() {
        return open;
    }

    /**
     * Sets the value of the open property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     */
    public void setOpen(Boolean value) {
        this.open = value;
    }

    /**
     * Gets the value of the author property.
     */
    public AtomPersonConstruct getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     *
     * @param value
     *     allowed object is
     *     {@link AtomPersonConstruct }
     */
    public void setAuthor(AtomPersonConstruct value) {
        this.author = value;
    }

    /**
     * Gets the value of the atomLink property.
     */
    public Link getAtomLink() {
        return atomLink;
    }

    /**
     * Sets the value of the atomLink property.
     *
     * @param value
     *     allowed object is
     *     {@link Link }
     */
    public void setAtomLink(Link value) {
        this.atomLink = value;
    }

    /**
     * Gets the value of the address property.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the addressDetails property.
     */
    public AddressDetails getAddressDetails() {
        return addressDetails;
    }

    /**
     * Sets the value of the addressDetails property.
     *
     * @param value
     *     allowed object is
     *     {@link AddressDetails }
     */
    public void setAddressDetails(AddressDetails value) {
        this.addressDetails = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the snippetDeprecated property.
     */
    public SnippetType getSnippetDeprecated() {
        return snippetDeprecated;
    }

    /**
     * Sets the value of the snippetDeprecated property.
     *
     * @param value
     *     allowed object is
     *     {@link SnippetType }
     */
    public void setSnippetDeprecated(SnippetType value) {
        this.snippetDeprecated = value;
    }

    /**
     * Gets the value of the snippet property.
     */
    public Snippetliteral getSnippet() {
        return snippet;
    }

    /**
     * Sets the value of the snippet property.
     *
     * @param value
     *     allowed object is
     *     {@link Snippetliteral }
     */
    public void setSnippet(Snippetliteral value) {
        this.snippet = value;
    }

    /**
     * Gets the value of the description property.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the abstractViewGroup property.
     */
    public JAXBElement<? extends AbstractViewType> getAbstractViewGroup() {
        return abstractViewGroup;
    }

    /**
     * Sets the value of the abstractViewGroup property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CameraType }{@code >}
     *     {@link JAXBElement }{@code <}{@link LookAtType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractViewType }{@code >}
     */
    public void setAbstractViewGroup(JAXBElement<? extends AbstractViewType> value) {
        this.abstractViewGroup = value;
    }

    /**
     * Gets the value of the abstractTimePrimitiveGroup property.
     */
    public JAXBElement<? extends AbstractTimePrimitiveType> getAbstractTimePrimitiveGroup() {
        return abstractTimePrimitiveGroup;
    }

    /**
     * Sets the value of the abstractTimePrimitiveGroup property.
     *
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TimeStampType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TimeSpanType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AbstractTimePrimitiveType }{@code >}
     */
    public void setAbstractTimePrimitiveGroup(JAXBElement<? extends AbstractTimePrimitiveType> value) {
        this.abstractTimePrimitiveGroup = value;
    }

    /**
     * Gets the value of the styleUrl property.
     */
    public String getStyleUrl() {
        return styleUrl;
    }

    /**
     * Sets the value of the styleUrl property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setStyleUrl(String value) {
        this.styleUrl = value;
    }

    /**
     * Gets the value of the abstractStyleSelectorGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractStyleSelectorGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractStyleSelectorGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link StyleType }{@code >}
     * {@link JAXBElement }{@code <}{@link StyleMapType }{@code >}
     * {@link JAXBElement }{@code <}{@link AbstractStyleSelectorType }{@code >}
     */
    public List<JAXBElement<? extends AbstractStyleSelectorType>> getAbstractStyleSelectorGroup() {
        if (abstractStyleSelectorGroup == null) {
            abstractStyleSelectorGroup = new ArrayList<JAXBElement<? extends AbstractStyleSelectorType>>();
        }
        return this.abstractStyleSelectorGroup;
    }

    /**
     * Gets the value of the region property.
     */
    public RegionType getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     *
     * @param value
     *     allowed object is
     *     {@link RegionType }
     */
    public void setRegion(RegionType value) {
        this.region = value;
    }

    /**
     * Gets the value of the metadata property.
     */
    public MetadataType getMetadata() {
        return metadata;
    }

    /**
     * Sets the value of the metadata property.
     *
     * @param value
     *     allowed object is
     *     {@link MetadataType }
     */
    public void setMetadata(MetadataType value) {
        this.metadata = value;
    }

    /**
     * Gets the value of the extendedData property.
     */
    public ExtendedDataType getExtendedData() {
        return extendedData;
    }

    /**
     * Sets the value of the extendedData property.
     *
     * @param value
     *     allowed object is
     *     {@link ExtendedDataType }
     */
    public void setExtendedData(ExtendedDataType value) {
        this.extendedData = value;
    }

    /**
     * Gets the value of the abstractFeatureSimpleExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractFeatureSimpleExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractFeatureSimpleExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     */
    public List<Object> getAbstractFeatureSimpleExtensionGroup() {
        if (abstractFeatureSimpleExtensionGroup == null) {
            abstractFeatureSimpleExtensionGroup = new ArrayList<Object>();
        }
        return this.abstractFeatureSimpleExtensionGroup;
    }

    /**
     * Gets the value of the abstractFeatureObjectExtensionGroup property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the abstractFeatureObjectExtensionGroup property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAbstractFeatureObjectExtensionGroup().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AbstractObjectType }
     */
    public List<AbstractObjectType> getAbstractFeatureObjectExtensionGroup() {
        if (abstractFeatureObjectExtensionGroup == null) {
            abstractFeatureObjectExtensionGroup = new ArrayList<AbstractObjectType>();
        }
        return this.abstractFeatureObjectExtensionGroup;
    }

}
