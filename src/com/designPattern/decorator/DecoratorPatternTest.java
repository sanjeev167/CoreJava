/**
 * 
 */
package com.designPattern.decorator;

/**
 * @author Sanjeev
 *
 */
public class DecoratorPatternTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//First we create an object of sports car by initializing it with basic car. 
		Car sportsCar = new SportsCar(new BasicCar());
		//Then we call assemble method to decorate it with special feature
		sportsCar.assemble();
		System.out.println("\n*****");
		
		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();//Decorate it with luxury car feature
		
	}

}
