<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="pages/css/style.css">
<link rel="stylesheet" href="pages/css/login.css">
</head>
<body>
	<div class="module">
		<div class="form">
			<h1 >Login to your account</h1>
			<s:form action="login" method="post">
				<s:textfield name="employee.empCode" label="Employee Code"/>
				<s:password name="employee.empPassword" label="Password"/>
				<s:submit method="execute" key="login" align="center" cssClass="login"/>
			</s:form>
		</div>
	</div>
</body>
</html>