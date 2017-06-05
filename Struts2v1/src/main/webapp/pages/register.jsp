<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/plain; charset=UTF-8">

<title>Register</title>
<link rel="stylesheet" href="pages/css/register.css">
<link rel="stylesheet" href="pages/css/style.css">
<script type="text/javascript" src="pages/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="pages/js/register.js"></script>
</head>
<body>
	<div class="global">
		<h2 class="center">REGISTER</h2>
		<s:form method="post" theme="simple">
			<s:include value="working.jsp"></s:include>
			<div class="center submit">
				<s:submit action="back" value="Back" align="left" cssClass="back"/>
				<s:submit action="register1" value="Register" align="right" cssClass="update" />
			</div>
		</s:form>
	</div>
</body>
</html>