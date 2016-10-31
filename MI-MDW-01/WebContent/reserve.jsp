<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="persistence.Trip" %>
<%@ page import="persistence.Database" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Make reservation</title>
</head>
<body>
<form action="./reservingServlet">
  Please enter your name: <br>
  <input type="text" name="name" size="20px">
  <br>
  Please choose a trip: <br>
  <select name="id">
  <%
   		Database db = Database.getInstance();
		Set<Integer> ids = db.getIds();        
		for (Integer i : ids) {
			out.println("<option value=\""+i+"\">"+db.getObject(i).getName()+"</option>");
		}

  %>
  </select>
  <br>
  <input type="submit" value="submit">
</form>

</body>
</html>