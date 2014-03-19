package com.learnJava.jaxWSSpring.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnJava.jaxWSSpring.services.EchoService;

@Service("EchoServiceEndpoint")
@WebService(serviceName="EchoService")
public class EchoServiceEndpoint {
	
	@Autowired
	private EchoService echoService;
	
	@WebMethod
	public String echo(){
		return echoService.echo();
	}

}
