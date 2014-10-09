package jaxb.test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

public class MashalTest {
	
	private JAXBContext jasxbContext;
	
	@Before
	public void setup() throws JAXBException {
		jasxbContext = JAXBContext.newInstance("org.springframework.integration.samples.cafe");
	}

	@Test
	public void testMarshall() {
		
	}
}
