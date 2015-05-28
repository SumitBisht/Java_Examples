<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
 
<head>
<title>Error</title>
</head>
 
<body>
	<h2>Sorry, <s:property value="username" />!</h2>
	<p>You are unable to log in, please <a href="/LoginModuleExample">login</a> again.</p>
</body>
</html>