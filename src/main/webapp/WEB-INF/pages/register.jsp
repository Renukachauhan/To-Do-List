<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>To Do List</title>
<style type="text/css">
.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}

</style>
<style type="text/css">
#header{
color:green;
}


.h{
background-color: powderblue;
    padding: 30px 40px;
    color: white;
    text-align: center;
}



/* Style the input */
input {
    border: none;
    width: 100%;
    padding: 10px;
    float: left;
    font-size: 16px;
}

/* Style the "Add" button */
.addBtn {
    padding: 10px;
    width: 35%;
    background: #d9d9d9;
    color: #555;
    float: left;
    text-align: center;
    font-size: 16px;
    cursor: pointer;
    transition: 0.3s;
}

.addBtn:hover {
    background-color: #bbb;
}
</style>
</head>
<body>
<div id="header" class="h">
<h1>Add Your Tasks</h1>


<c:url var="addAction" value="/adduser/" ></c:url>

<form:form action="${addAction}" commandName="user">
<center>
<table>
<c:if test="${!empty user.username}">
<tr>
<td>
<form:label path="id" >
				<spring:message text="ID"/>
			</form:label>
			</td>
			<td>
			<form:input path="id" readonly="true" size="5"  disabled="true" />
			<form:hidden path="id" />
		
		</td>
			</tr>
	</c:if>		
			<tr>
			<%-- <td>
			<form:label path="username" >
				<spring:message text="Add Task"/>
			</form:label>
			</td> --%> 
			<td>
			<form:input path="username"    id="input"   placeholder="Enter..."/>
			</td>
			</tr>
			
<tr>
<td colspan="5">
<c:if test="${!empty user.username }">
<input type="submit" value="<spring:message text="Edit"/>"/>
</c:if>
<c:if test="${empty user.username }">
<input type="submit" value="<spring:message text="Add"/>"/>
</c:if>
</td>
</tr>

</table>
</center>
</form:form>
</div>




<br>

<center>
<h2 style="color:green;">Your List </h2>
<c:if test="${!empty usr}">
	<table class="tg">
	<tr>
		<th width="80">SNO.</th>
		<th width="120">TASKS</th>
		
		<th width="60">Edit</th>
		<th width="60">Done</th>
	</tr>
<c:forEach items="${usr}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.username}</td>
			
			<td><a href="<c:url value='/edit/${user.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/delete/${user.id}' />" >Done</a></td><!-- pass the id with user -->
		</tr>
	</c:forEach>
	</table>
</c:if>

</center>


</body>
</html>
