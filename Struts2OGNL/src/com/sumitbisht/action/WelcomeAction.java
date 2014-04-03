package com.sumitbisht.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
 
public class WelcomeAction extends ActionSupport implements ModelDriven<MyJavaBean>{
 
    public String execute(){
        return SUCCESS;
    }
     
    private MyJavaBean bean = new MyJavaBean();
     
    @Override
    public MyJavaBean getModel() {
        return bean;
    }
 
}