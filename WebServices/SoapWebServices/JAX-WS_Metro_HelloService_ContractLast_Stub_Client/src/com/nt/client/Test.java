//Test.java
package com.nt.client;

import com.nt.service.HelloServiceImpl;
import com.nt.service.HelloServiceImplService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloServiceImpl helloServiceImpl = null;
		HelloServiceImplService helloServiceImplService = null;
		helloServiceImplService = new HelloServiceImplService();
		helloServiceImpl = helloServiceImplService.getHelloServiceImplPort();
		String message = helloServiceImpl.sayHelloService("RAJ");
		System.out.println(message);
	}// method

}// class
