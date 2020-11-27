/**
 * 
 */
package com.designPattern.adapter;

/**
 * @author Sanjeev
 *
 */


//Using inheritance for adapter pattern
public class SocketClassAdapterImpl extends Socket implements SocketAdapter{

	@Override
	public Volt get120Volt() {
		return getVolt();//Here we require 120 volt through this adapter
	}

	@Override
	public Volt get12Volt() {
		Volt v= getVolt();
		return convertVolt(v,10);//Here we require 12 volt through this adapter. It needs conversion as getVolt returns 120 volt.
		                         //But this conversion receives 120 volt and the target volt is 12 volt and 10 is a factor used to get the required volt
	}

	@Override
	public Volt get3Volt() {
		Volt v= getVolt();
		return convertVolt(v,40);//Here we require 3 volt through this adapter. It needs conversion as getVolt returns 120 volt.
        //But this conversion receives 120 volt and the target volt is 3 volt and 40 is a factor used to get the required volt
	}
	
	private Volt convertVolt(Volt v, int targetVolt) {
		//This conversion logic is yours. You can define any logic that meets your needs.
		return new Volt(v.getVolts()/targetVolt);
	}

}
