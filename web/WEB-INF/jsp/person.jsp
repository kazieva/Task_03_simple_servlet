<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <div>
      <H2>Results:</H2>
       <table>
          <tr>
            <td>Name</td>
            <td>Surname</td>
            <td>Phone number</td>
            <td>e-mail</td>
          </tr>

          <c:forEach items="${requestScope.personList}" var="person">
            <tr>
              <td>${person.name}</td>
              <td>${person.surname}</td>
              <td>${person.phone}</td>
              <td>${person.email}</td>
            </tr>
          </c:forEach>
        </table>
    </div>
  </body>
</html>
