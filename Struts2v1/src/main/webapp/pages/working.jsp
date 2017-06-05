<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
	language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/plain; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="pages/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="pages/js/register.js"></script>
</head>
<body>
	<div class="common">
		<table>
			<tr>
				<td>Company Name</td>
				<td><s:property value="#session.companyname" /></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><s:property value="#session.empname" /></td>
				<td>Date</td>
				<td>
					<%-- 					<s:property	value="sdate" /> --%> <s:date name="date"
						format="yyyy/MM/dd" />
				</td>
			</tr>
			<tr>
				<td>Working Class</td>
				<td><s:fielderror fieldName="worktime.wrkClass"></s:fielderror>
					<s:select list="workingClassList" name="worktime.wrkClass"
						value="workingClassDefault" id="workingclass" /></td>
			</tr>
			<tr>
				<td>Start Time</td>
				<td><s:fielderror fieldName="starttime_hh"></s:fielderror> <s:select
						list="hourList" name="starttime_hh" value="starttime_hh_default"
						id="starttime_hh" /> <s:select list="minuteList"
						name="starttime_mm" value="starttime_mm_default" id="starttime_mm" /></td>
				<td>Start Class</td>
				<td><s:fielderror fieldName="worktime.startClass"></s:fielderror>
					<s:select list="startClassList" name="worktime.startClass"
						value="startClassDefault" id="startclass" /></td>
			</tr>
			<tr>
				<td>End Time</td>
				<td><s:fielderror fieldName="endtime_hh"></s:fielderror> <s:select
						list="hourList" name="endtime_hh" value="endtime_hh_default"
						id="endtime_hh" /> <s:select list="minuteList" name="endtime_mm"
						value="endtime_mm_default" id="endtime_mm" /></td>
				<td>End Class</td>
				<td><s:fielderror fieldName="worktime.endClass"></s:fielderror>
					<s:select list="endClassList" name="worktime.endClass"
						value="endClassDefault" id="endclass" /></td>
			</tr>
			<tr>
				<td>Note</td>
				<td colspan="3"><s:textarea name="worktime.note" cols="65"
						rows="8" onKeyDown="limitText(this,200);"
						onKeyUp="limitText(this,200);" value="%{noteDefault}" /></td>
			</tr>
		</table>
	</div>
</body>
</html>