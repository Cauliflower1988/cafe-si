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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Mark Fisher
 * @author Marius Bogoevici
 * @author Tom McCuch
 * @author Gunnar Hillert
 */
@XmlRootElement(name="Item")
@XmlType(propOrder={"orderNumber", "type","shots", "iced"})
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement
	private DrinkType type;

	@XmlElement
	private int shots = 1;

	@XmlElement
	private boolean iced = false;

	/** the order this item is tied to */
	@XmlElement
	private int orderNumber;

	// Default constructor required by Jackson Java JSON-processor
	public OrderItem() {}

	public OrderItem(int orderNumber, DrinkType type, int shots, boolean iced) {
		this.orderNumber = orderNumber;
		this.type = type;
		this.shots = shots;
		this.iced = iced;
	}

	public int getOrderNumber() {
		return this.orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public boolean isIced() {
		return this.iced;
	}

	public void setIced(boolean iced) {
		this.iced = iced;
	}

	public int getShots() {
		return shots;
	}

	public void setShots(int shots) {
		this.shots = shots;
	}

	public DrinkType getDrinkType() {
		return this.type;
	}

	public void setDrinkType(DrinkType type) {
		this.type = type;
	}

	public String toString() {
		return ((this.iced) ? "iced " : "hot ") + this.shots + " shot " + this.type;
	}

}
