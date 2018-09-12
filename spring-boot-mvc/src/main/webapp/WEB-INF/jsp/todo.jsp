<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.util.*" %>
<%@ page import="com.baeldung.springbootmvc.model.Todo" %>
<html>
<body>
	<h1>${message}</h1>
	<h2>System time is: ${systemTime}</h2>

<form:form action="/todo" method="post" modelAttribute="todo">
    <p>TO-DO message: </p>
    <p><input type="text" name="message" /></p>
    <p>TO-DO message: </p>
    <p><input type="number" min="0" step="1" name="priority" /></p>
    <p>Deadline: </p>
    <p><input type="date" name="deadline" /></p>
    <p><input type="submit" value="Submit"/></p>
</form:form>

<table>
    <thead>
        <tr>
            <th>TO-DO</th>
            <th>Priority</th>
            <th>Deadline</th>
        </tr>
    </thead>
    <tbody>

        <% for (Todo todo : (Collection<Todo>) request.getAttribute("todoList")) {%>
        <tr>
        <td><%= todo.getMessage() %></td>
        <td><%= todo.getPriority() %></td>
        <td><%= todo.getDeadline() %></td>
        </tr>
        <%} %>
    </tbody>
</table>

</body>
</html>