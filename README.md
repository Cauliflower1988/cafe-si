Café Sample Application - Pure SI Implementation
================================================

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

To run this sample simply execute the CafeDemoApp classe in the **org.springframework.integration.samples.cafe.xml** package.

See the configuration files in the **META-INF/spring/integration** path.

Added a wire-tap in the orders channel to log all the orders as they pass trough the cannel.
Also added a task executor pool to multiply the hot drinks service executors.

Watch how the processing of the 100 orders is now a lot faster then in version xml-1