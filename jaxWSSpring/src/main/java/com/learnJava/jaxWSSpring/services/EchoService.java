package com.learnJava.jaxWSSpring.services;
import org.springframework.stereotype.Service;

@Service("EchoService")
public class EchoService {
	
	public String echo(){
		return "Hello";
	}

}
