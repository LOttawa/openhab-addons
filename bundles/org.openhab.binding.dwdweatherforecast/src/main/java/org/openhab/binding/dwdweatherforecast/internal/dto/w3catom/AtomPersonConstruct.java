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

package org.openhab.binding.dwdweatherforecast.internal.dto.w3catom;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for atomPersonConstruct complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="atomPersonConstruct"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded" minOccurs="0"&gt;
 *         &lt;element ref="{http://www.w3.org/2005/Atom}name"/&gt;
 *         &lt;element ref="{http://www.w3.org/2005/Atom}uri"/&gt;
 *         &lt;element ref="{http://www.w3.org/2005/Atom}email"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 * @author Lars Ottawa - Initial contribution
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "atomPersonConstruct", propOrder = {
    "nameOrUriOrEmail"
})
public class AtomPersonConstruct {

    @XmlElementRefs({
        @XmlElementRef(name = "name", namespace = "http://www.w3.org/2005/Atom", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "uri", namespace = "http://www.w3.org/2005/Atom", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "email", namespace = "http://www.w3.org/2005/Atom", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<String>> nameOrUriOrEmail;

    /**
     * Gets the value of the nameOrUriOrEmail property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nameOrUriOrEmail property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNameOrUriOrEmail().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    public List<JAXBElement<String>> getNameOrUriOrEmail() {
        if (nameOrUriOrEmail == null) {
            nameOrUriOrEmail = new ArrayList<JAXBElement<String>>();
        }
        return this.nameOrUriOrEmail;
    }

}
