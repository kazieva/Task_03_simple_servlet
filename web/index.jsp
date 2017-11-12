<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <div>
      <form action="/Controller" method="get">
        <br>
        Name
        <input name="name" type="text" size="30" placeholder="Name">
        <br>
        Surname
        <input name="surname" size="30" type="text" required  placeholder="Surname">
        <br>
        <input type="submit" value="press me">
      </form>
    </div>
  </body>
</html>