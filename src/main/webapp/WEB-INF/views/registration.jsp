<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Форма добавления</title>

<style>

	.error {
		color: #ff0000;
	}
	A {
		text-decoration: none;
	}
</style>

</head>

<body>

	<h2>Форма добавления</h2>
 
	<form:form method="POST" modelAttribute="todoList">
		<form:input type="hidden" path="id" id="id"/>
		<table>
			<tr>
				<td><label for="note">Описание: </label> </td>
				<td><form:input path="note" id="note"/></td>
				<td><form:errors path="note" cssClass="error"/></td>
		    </tr>
	    
			<tr>
				<td><label for="deadLine">Крайний срок:dd/MM/yyyy </label> </td>
				<td><form:input path="deadLine" id="deadLine"/></td>
				<td><form:errors path="deadLine" cssClass="error"/></td>
		    </tr>

			<tr>
				<td>
					Выполнено
				</td>
				<td>
					<form:checkbox path="status" /><form:label path="status"></form:label>
				</td>
			</tr>
			<tr>
				<td colspan="3">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Изменить"/>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Добавить"/>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</table>
	</form:form>
	<br/>
	<br/>
	Посмотреь <a href="<c:url value='/list' />">Все дела</a>
</body>
</html>