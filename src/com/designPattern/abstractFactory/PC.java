/**
 * 
 */
package com.designPattern.abstractFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanjeev
 *
 */
public class PC extends Computer{
	
	private String ram;
	private String hdd;
	private String cpu;
	
	List<ComputerItem> computerItems;
	
	public PC(String ram,String hdd, String cpu) {
		this.ram=ram;
		this.hdd=hdd ;
		this.cpu=cpu ;
		//Prepare a list of computer items having this configuration
		this.computerItems=getComputerItemsFromRepository( ram, hdd,  cpu);
		
	}
	
	
	private List<ComputerItem> getComputerItemsFromRepository(String ram2, String hdd2, String cpu2) {
		// TODO Auto-generated method stub
		List<ComputerItem> computerItemsLocal=new ArrayList<ComputerItem>();
		computerItemsLocal.add(new ComputerItem("PC", "Lenevo", "32000", "2 GB", "1 TB", "1.4 GHZ"));
		computerItemsLocal.add(new ComputerItem("PC", "Asus", "30000", "2 GB", "1 TB", "1.4 GHZ"));
		computerItemsLocal.add(new ComputerItem("PC", "HP", "35000", "2 GB", "1 TB", "1.4 GHZ"));
		computerItemsLocal.add(new ComputerItem("PC", "Apple", "72000", "4 GB", "1 TB", "2.4 GHZ"));
		this.computerItems=computerItemsLocal;
		return computerItems;
	}


	@Override
	public String getRAM() {
		// TODO Auto-generated method stub
		return this.ram;
	}

	@Override
	public String getHDD() {
		// TODO Auto-generated method stub
		return this.hdd;
	}

	@Override
	public String getCPU() {
		// TODO Auto-generated method stub
		return this.cpu;
	}

	@Override
	public List<ComputerItem> getComputerItemsFromRepository() {
		// TODO Auto-generated method stub
		return computerItems;
	}


	
	

}
