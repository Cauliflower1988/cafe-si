Café Sample Application - Pure SI Implementation
================================================

This branch adds a router to handle Food Items in the XML Order

See the parent-level **README.md** for more details, but the flow of the implementation should follow this diagram:


	                                                                                          Barista
	                                                                     hotDrinks       ____________________
	                                                                    |==========| -->|                    |
	                     orders                   drinks               /                | prepareHotDrink()  |
	Place Order ->Cafe->|======|->OrderSplitter->|======|->DrinkRouter                  |                    |
	                                                                   \ coldDrinks     | prepareColdDrink() |
	                                                                    |==========| -->|                    |
	                                                                                    |____________________|
	
	                                                Legend: |====| - channels


## Instructions for running the CafeDemo sample

The example comes with two identical configurations. One is ANNOTATION-based another is XML-based

To run this sample simply execute the CafeDemoApp class in the **org.springframework.integration.samples.cafe.xml** package.

See the configuration files in the **META-INF/spring/integration** path.

Created a new item type that can be ordered - food.