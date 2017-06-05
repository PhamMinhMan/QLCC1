<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/plain; charset=UTF-8">
<title>Search</title>
<link rel="stylesheet" href="pages/css/bootstrap.min.css">
<link rel="stylesheet" href="pages/css/search.css">
<script type="text/javascript" src="pages/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="pages/js/search.js"></script>
</head>
<body>
	<div>
		<h2>Thông tin chuyên cần theo tháng</h2>
		<s:form method="post" theme="simple">
			<div>
				<table>
					<tr>
						<td>Company Name:</td>
						<td><s:property value="#session.companyname" /></td>
					</tr>
					<tr>
						<td>Employee Name:</td>
						<td><s:property value="#session.empname" /></td>
						<td>Date:</td>
<%-- 						<td id="date"><s:property value="searchDate" /></td> --%>
						<td id="date"><s:date name="date" format="yyyy/MM" /></td>
					</tr>
				</table>
			</div>

			<div>
				<div class="col-xs-8 col-xs-offset-2 well">
					<table class="table table-scroll table-striped">
						<thead>

							<tr>
								<th></th>
								<th>Day</th>
								<th>Working</th>
								<th>Start Class</th>
								<th>End Class</th>
								<th>Start Time</th>
								<th>End Time</th>
								<th>Note</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="worktimes" status="stt">
								<tr>
									<td><s:property value="dateOfmonth" /></td>
									<%-- 									<s:hidden name="" value="%{#rowStatus.count}"></s:hidden> --%>
									<td><s:property value="day" /></td>
									<td><s:property value="wrkClass" /></td>
									<td><s:property value="startClass" /></td>
									<td><s:property value="endClass" /></td>
									<td><s:property value="startTime" /></td>
									<td><s:property value="endTime" /></td>
									<td><s:property value="note" /></td>
									<s:set name="check" value="wrkClass" />
									<s:if test="%{#check!=''}">
										<td><s:url id="update" action="update" var="myurl1">
												<s:param name="dateMonth" value="dateOfmonth"></s:param>
											</s:url> <s:a href="%{myurl1}">Update</s:a>
										<td><s:url action="delete" var="myurl">
												<s:param name="dateMonth" value="dateOfmonth"></s:param>
											</s:url> <s:a id="delete_%{#stt.count}" cssClass="del"
												href="%{myurl}">Delete</s:a></td>
									</s:if>
									<s:else>
										<td></td>
										<td></td>
									</s:else>
								</tr>

							</s:iterator>

						</tbody>
					</table>
				</div>
			</div>
			<div>
				<s:submit action="back" value="Back" align="left" cssClass="back"/>
				<s:submit action="print" value="Print" />
				<s:submit action="previous" value="Previous Month" />
				<s:submit action="next" value="Next Month" id="next" />
			</div>
		</s:form>
	</div>
</body>
</html>