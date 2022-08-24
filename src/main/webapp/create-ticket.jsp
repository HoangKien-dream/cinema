<%@ page import="java.util.List" %>
<%@ page import="com.example.demojsp.model.Category" %><%--
  Created by IntelliJ IDEA.
  User: hoangtrungkien
  Date: 24/08/2022
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CreateTicket</title>
</head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<body>
<form action="CreateTicket" method="post">
    <%
        List<Category> categories = (List<Category>) request.getAttribute("categories");
    %>
    <div class="row container-fluid">
        <select class="form-select" aria-label="Default select example">
           <%
               for (Category category:categories) {
            %>
            <option value="<%= category.getId()%>">
                <%= category.getName()%>
            </option>
            <%
               }
           %>
        </select>
    </div>
</form>
</body>
</html>
