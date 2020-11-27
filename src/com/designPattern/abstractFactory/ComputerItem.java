/**
 * 
 */
package com.designPattern.abstractFactory;

/**
 * @author Sanjeev
 *
 */
public class ComputerItem {
	private String type;
	private String brand;
	private String price;
	private String ram;
	private String hdd;
	private String cpu;
	
	//Wheneve toString method will be called on an object with computer refrence, this toString method will be called.
		public String toString() {		
			return "\nBrand => "+this.brand+" & Price => "+this.price;
		        		                                   
			
		}
	public ComputerItem(String type,String brand, String price, String ram, String hdd, String cpu) {
		this.type=type;
		this.brand=brand;
		this.price=price;
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;		
	}
	
	

	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHdd() {
		return hdd;
	}

	public void setHdd(String hdd) {
		this.hdd = hdd;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	
	

}
