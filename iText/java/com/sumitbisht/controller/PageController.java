package com.sumitbisht.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.sumitbisht.model.UserData;
import com.sumitbisht.producer.PDFReport;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class PageController {
 
	@RequestMapping(value="/req", method = RequestMethod.GET)
	public String displayDataEntryForm(ModelMap model) {
		System.out.println("Data entry form hit");
		model.addAttribute("message", "Spring 3 MVC based form");
		return "form";
 
	}
	
	@RequestMapping(value="/req", method = RequestMethod.POST)
	public String processFormValues(@ModelAttribute("modelAttr")UserData userData, ModelMap model){
		System.out.println("Data: "+userData.getName()+","+userData.getAddress());
		String docName = "Kim-"+Math.random()*1999+".pdf";
		Map<String, String> names = new HashMap<String, String>();
		names.put(userData.getName(), userData.getAddress());
		PDFReport.buildPdfDocument(docName, names);
		model.addAttribute("message", "Data processed successfully");
		
		return "form";
	}
 
}