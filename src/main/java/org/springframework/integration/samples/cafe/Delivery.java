/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.samples.cafe;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Marius Bogoevici
 * @author Tom McCuch
 * @author Gunnar Hillert
 */
@XmlRootElement(name="Delivery")
@XmlType(propOrder={"orderNumber","deliveredItems"})
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Delivery implements Serializable{

	private static final long serialVersionUID = 1L;

	private static final String SEPARATOR = "YYYYYYYYYYYYYYYYYYYYYYYYYYY";

	private List<OrderItem> deliveredItems;

	private int orderNumber;

	// Default constructor required by Jackson Java JSON-processor
	public Delivery() {}

	public Delivery(List<OrderItem> deliveredItems) {
		assert(deliveredItems.size() > 0);
		this.deliveredItems = deliveredItems;
		this.orderNumber = deliveredItems.get(0).getOrderNumber();
	}


	@XmlElement(name = "orderNumber")
	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	@XmlElementWrapper(name = "items")
	@XmlElements({
			@XmlElement(name = "Drink", type = Drink.class),
			@XmlElement(name = "Food", type = Sandwich.class)
	})
	public List<OrderItem> getDeliveredItems() {
		return deliveredItems;
	}

	public void setDeliveredItems(List<OrderItem> deliveredItems) {
		this.deliveredItems = deliveredItems;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("\n" + SEPARATOR + "\n");
		buffer.append("Order #" + getOrderNumber() + " has been delivered\n");
		for (OrderItem item : getDeliveredItems()) {
			buffer.append(item);
			buffer.append("\n");
		}
		buffer.append(SEPARATOR + "\n");
		return buffer.toString();
	}

}
