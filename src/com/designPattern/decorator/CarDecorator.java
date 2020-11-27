/**
 * 
 */
package com.designPattern.decorator;

/**
 * @author Sanjeev
 *
 */
public class CarDecorator implements Car {

	protected Car car;
	
	public CarDecorator(Car c){
		this.car=c;
	}
	
	//Initialize with basic car feature
	@Override
	public void assemble() {
		
		this.car.assemble();
	}

}