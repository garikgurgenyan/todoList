<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Список дел</title>

    <style>
        tr:first-child {
            font-weight: bold;
            background-color: #C6C9C4;
        }

        A {
            text-decoration: none;
        }
    </style>

</head>


<body>
<h2>Список дел</h2>
<br>
<a href="<c:url value='/list' />">|  Все дела  |</a>
<a href="<c:url value='/activeList' />">|  Выполненные  |</a>
<a href="<c:url value='/inactiveList' />">|  Только невыполненные  |</a>
<br>
<table>
    <tr>
        <td>Описание</td>
        <td>Крайний срок</td>
        <td>Статус</td>
        <td>Изменить</td>
        <td>Удалить</td>
    </tr>
    <c:forEach items="${todoList}" var="todo">
            <tr>
            <td>${todo.note}</td>
            <td>${todo.deadLine}</td>
                <td><c:choose>
                    <c:when test="${todo.status == true}">
                        Выполнено
                    </c:when>
                    <c:when test="${todo.status == false}">
                        Не выполнено
                    </c:when>
                </c:choose>
                </td>
            <td><a href="<c:url value='/edit-${todo.id}-todo' />">Изменить</a></td>
            <td><a href="<c:url value='/delete-${todo.id}-todo' />">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="<c:url value='/new' />">Добавить новую заметку</a>
</body>
</html>