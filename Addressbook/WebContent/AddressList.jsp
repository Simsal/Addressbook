<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="addresslist" class="classes.AddressList"></jsp:useBean>
		<c:if test="${param.s != null}">
			<jsp:setProperty name ="addresslist" property="searchQuery" param="s"/>
		</c:if>

	<jsp:getProperty property="list" name="addresslist"/>
	<table>
		<c:forEach items="${addresslist.list}" var="address">
			<tr>
				<td>
					<a href="AddressDetail.jsp?task=delete&id=${address.getId()}"><input type="Button" value="delete"/></a>
				</td>
				<td>
					<a href="AddressDetail.jsp?task=detail&id=${address.getId()}"><input type="Button" value="details"/></a>
				</td>
				<td>
					<c:out value="${address.getName()}"></c:out>
				</td>
				<td>
					<c:out value="${address.getChristianName()}"></c:out>
				</td>
				<td>
					<c:out value="${address.getEmail()}"></c:out>
				</td>
			</tr>
		</c:forEach>
	</table>

	<a href="servlet?task=new"><input type="Button" value="new"/></a>
</body>
</html>