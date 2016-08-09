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
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Mark Fisher
 * @author Marius Bogoevici
 * @author Tom McCuch
 * @author Gunnar Hillert
 */
@XmlRootElement(name="Order")
@XmlType(propOrder={"number","orderItems"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;

	private static final String SEPARATOR = ". . . . . . . . . . . .";

	@XmlElementWrapper(name = "items")
	@XmlAnyElement(lax = true)
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	/** the order number used for tracking */
	@XmlElement
	private int number;

	// Default constructor required by Jackson Java JSON-processor
	public Order() {}

	public Order(int number) {
		this.number = number;
	}

	public void addDrinkItem(DrinkType drinkType, int shots, boolean iced) {
		this.orderItems.add(new DrinkOrderItem(this.number, drinkType, shots, iced));
	}

    public void addFoodItem(String description) {
        this.orderItems.add(new FoodOrderItem(this.number, description));
    }

    public void addItem(OrderItem item) {
		item.setOrderNumber(getNumber());
		this.orderItems.add(item);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<OrderItem> getItems() {
		return this.orderItems;
	}

	public void setItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("\n" + SEPARATOR + "\n");
		buffer.append("Order #" + getNumber() + " placed\n");
		for (OrderItem item : getItems()) {
			buffer.append(item);
			buffer.append("\n");
		}
		buffer.append(SEPARATOR + "\n");
		return buffer.toString();
	}

}
