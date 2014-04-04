package com.sumitbisht;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;

import com.sumitbisht.data.BackendAuthenticator;

public class LoginAction extends org.apache.struts.action.Action {

	private Logger logger = Logger.getLogger(LoginAction.class);
	private BackendAuthenticator authService = new BackendAuthenticator();

	/**
	 * This is the action called from the Struts framework.
	 * 
	 * @param mapping
	 *            The ActionMapping used to select this instance.
	 * @param form
	 *            The optional ActionForm bean for this request.
	 * @param request
	 *            The HTTP Request we are processing.
	 * @param response
	 *            The HTTP Response we are processing.
	 * @throws java.lang.Exception
	 * @return
	 * 
	 *         Objective : Use actionforms and use validation framework to
	 *         validate these forms Business logic , validation part & custom
	 *         tag library stored within XML format configuration
	 * 
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm loginForm = (DynaActionForm) form;
		String userName = loginForm.get("userName").toString();
		String password = loginForm.get("password").toString();

		/*
		 * I've expanded the business rules in place expand the scope of this
		 * code
		 */
		if (userName.equals("")) 
		{
			logger.fatal("Returning failure as username is empty");
			return mapping.findForward("failure");
		} 
		else if (password.equals("")) 
		{
			logger.fatal("Unable to match the username/password combo");
			return mapping.findForward("failure");
		} 
		else if (authService.authenticate(userName, password)) 
		{
			logger.info("Username/Password combination confirmed.");
			return mapping.findForward("success");
		} 
		else 
		{
			logger.warn("Username/Password Not matched.");
			return mapping.findForward("failure");
		}

	}
}
