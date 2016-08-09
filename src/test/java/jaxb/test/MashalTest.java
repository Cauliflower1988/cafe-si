package jaxb.test;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.integration.samples.cafe.Delivery;
import org.springframework.integration.samples.cafe.Drink;
import org.springframework.integration.samples.cafe.DrinkOrderItem;
import org.springframework.integration.samples.cafe.DrinkType;
import org.springframework.integration.samples.cafe.FoodOrderItem;
import org.springframework.integration.samples.cafe.Order;
import org.springframework.integration.samples.cafe.OrderItem;
import org.springframework.integration.samples.cafe.Sandwich;

public class MashalTest {
	
	private JAXBContext jasxbContext;

    private static final String ORDER_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" " +
            "standalone=\"yes\"?><Order><number>1</number><items><Drink><orderNumber>1</orderNumber><type>LATTE</type" +
            "><shots>2</shots><iced>false</iced></Drink><Drink><orderNumber>1</orderNumber><type>MOCHA</type><shots>3" +
            "</shots><iced>true</iced></Drink><Food><orderNumber>1</orderNumber><description>Tuna " +
            "Sadnwich</description></Food></items></Order>\n";

	@Before
	public void setup() throws JAXBException {
//		jasxbContext = JAXBContext.newInstance("org.springframework.integration.samples.cafe");
		jasxbContext = JAXBContext.newInstance(Order.class, DrinkOrderItem.class, FoodOrderItem.class,
				Delivery.class, Drink.class, Sandwich.class);
	}

	@Test
	public void testMarshall() throws JAXBException {
		
		Order order = new Order(1);
		order.addDrinkItem(DrinkType.LATTE, 2, false);
		order.addDrinkItem(DrinkType.MOCHA, 3, true);
		order.addFoodItem("Tuna Sadnwich");

		Marshaller marshaller = jasxbContext.createMarshaller();
		StringWriter writer = new StringWriter();
		
		marshaller.marshal(order, writer);
		
		System.out.println(writer.toString());
	}

    @Test
    public void testUnmarshall() throws JAXBException {

        Unmarshaller marshaller = jasxbContext.createUnmarshaller();

        StringReader reader = new StringReader(ORDER_XML);

        final Object order = marshaller.unmarshal(reader);

        System.out.println(order);
    }

}
