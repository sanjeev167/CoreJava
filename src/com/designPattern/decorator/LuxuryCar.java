/**
 * 
 */
package com.designPattern.decorator;

/**
 * @author Sanjeev
 *
 */
public class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car c) {
		super(c);
	}
	
	@Override
	public void assemble(){
		super.assemble();
		System.out.print(" Now , Adding features of LuxuryCar.");
	}
}
