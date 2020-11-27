/**
 * 
 */
package com.designPattern.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanjeev
 *
 */
public class Server extends Computer{
	
	private String ram;
	private String hdd;
	private String cpu;
	
	List<ComputerItem> computerItems;
	
	
	public Server(String ram,String hdd, String cpu) {
		this.ram=ram;
		this.hdd=hdd ;
		this.cpu=cpu ;			
		computerItems=getComputerItemsFromRepository( ram, hdd,  cpu);
	}
	

	private List<ComputerItem> getComputerItemsFromRepository(String ram2, String hdd2, String cpu2) {
		// TODO Auto-generated method stub
		List<ComputerItem> computerItemsLocal=new ArrayList<ComputerItem>();
		computerItemsLocal.add(new ComputerItem("Server", "Lenevo", "42000", "5 GB", "6 TB", "3.4 GHZ"));
		computerItemsLocal.add(new ComputerItem("Server", "Asus", "34000", "6 GB", "8 TB", "3.4 GHZ"));
		computerItemsLocal.add(new ComputerItem("Server", "HP", "45000", "6 GB", "10 TB", "3.4 GHZ"));
		computerItemsLocal.add(new ComputerItem("Server", "Apple", "72000", "16 GB", "15 TB", "4.4 GHZ"));
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
