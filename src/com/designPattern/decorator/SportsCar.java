/**
 * 
 */
package com.designPattern.decorator;

/**
 * @author Sanjeev
 *
 */
public class SportsCar extends CarDecorator {

	public SportsCar(Car c) {
		super(c);//Initialize with basic car
	}

	//Decorate it with special feature
	@Override
	public void assemble(){
		super.assemble();//This calls the assemble() defined in decorator
		System.out.print(" Now , Adding features of Sports Car.");
	}
}