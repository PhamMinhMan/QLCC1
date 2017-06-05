<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"	language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/plain; charset=UTF-8">
<title>Input Date</title>
<link rel="stylesheet" href="pages/css/style.css">
<link rel="stylesheet" href="pages/css/inputdate.css">
<sx:head />

</head>
<body>
<div class="module">
		<div class="form">
	<h1>Input Date</h1>
	<s:if test="hasActionErrors()">
      <div class="errors">
      <s:actionerror/>
      </div>
    </s:if>
    
	<s:form>
		<tr>
			<td>Company Name:</td>
			<td><s:property value="#session.companyname" /></td>
		</tr>
		<tr>
			<td>Employee Name:</td>
			<td><s:property value="#session.empname" /></td>
		</tr>

		<sx:datetimepicker name="date" label="Date"
			displayFormat="dd-MM-yyyy" value="%{'today'}"/>
		<div class="center submit">
			<td><s:submit action="back" key="back" method="doBack" align="left" cssClass="back"/></td>
			<td><s:submit action="search" key="search" method="doSearch"  align="center" cssClass="search"/></td>
			<s:submit action="register" key="register" method="doRegister" align="right" cssClass="register"/>
		</div>
	</s:form>
	</div>
	</div>
</body>
</html>
