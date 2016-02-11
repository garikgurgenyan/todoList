<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style>
		A {
			text-decoration: none;
		}
	</style>
<title>Заметка успешно добавлена.</title>
</head>
<body>
Уведомление : ${success}
	<br/>
	<br/>
	Посмотреь  <a href="<c:url value='/list' />">Все дела</a>
	
</body>

</html>