package jaxb.test;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.integration.samples.cafe.DrinkType;
import org.springframework.integration.samples.cafe.Order;

public class MashalTest {
	
	private JAXBContext jasxbContext;
	
	@Before
	public void setup() throws JAXBException {
		jasxbContext = JAXBContext.newInstance("org.springframework.integration.samples.cafe");
	}

	@Test
	public void testMarshall() throws JAXBException {
		
		Order order = new Order(1);
		order.addItem(DrinkType.LATTE, 2, false);
		order.addItem(DrinkType.MOCHA, 3, true);

		Marshaller marshaller = jasxbContext.createMarshaller();
		StringWriter writer = new StringWriter();
		
		marshaller.marshal(order, writer);
		
		System.out.println(writer.toString());
	}
}
