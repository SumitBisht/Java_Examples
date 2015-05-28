package com.sumitbisht.actions;

import java.text.SimpleDateFormat;
import java.util.Date;
 
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
 
public class MainAction {
  
	private String serverTime;
	private static int totalVisits;
	
	@Action(value="/showTime", results={@Result(name="success", location="showTime.tiles", type="tiles")})
	public String showServerTime ()
	{
		serverTime = SimpleDateFormat.getDateTimeInstance().format(new Date(System.currentTimeMillis()));
		System.out.println("serverTime = " + serverTime);
		return "success";
	}
	
	@Action(value="/showVisits", results={@Result(name="success", location="showVisits.tiles", type="tiles")})
	public String showTotalVisits ()
	{
		System.out.println("totalVisits = " + ++totalVisits);
		return "success";
	}
 
	public String getServerTime() {
		return serverTime;
	}
	
	public void setServerTime(String serverTime) {
		this.serverTime = serverTime;
	}
	
	public int getTotalVisits() {
		return totalVisits;
	}
	
	public void setTotalVisits(int totalVisits) {
		MainAction.totalVisits = totalVisits;
	}
 
}