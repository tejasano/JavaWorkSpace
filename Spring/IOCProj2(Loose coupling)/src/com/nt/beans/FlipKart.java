package com.nt.beans;

import java.util.Arrays;
import java.util.Random;

public class FlipKart {
	private Courier  courier;

	public void setCourier(Courier courier) {
		this.courier = courier;
	}
	
	public String shopping(String items[]){
		  Random random=null;
		  int orderId=0;
		  String report=null;
		  //generate orderId
		  random=new Random();
		  orderId=random.nextInt(100000);
		  // deliver the items
		  report=courier.deliver(orderId);
		  return report+".... the items are "+Arrays.toString(items);
		
	}

}
