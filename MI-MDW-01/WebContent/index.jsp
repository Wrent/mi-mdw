<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="persistence.Trip" %>
<%@ page import="persistence.Database" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List</title>
</head>
<body>

<a href="addNew.jsp">Insert new trip</a><br>
<a href="reserve.jsp">Make reservation</a><br><br>
<h1>All trips</h1>
<ul>
  <%
   		Database db = Database.getInstance();
		Set<Integer> ids = db.getIds();        
		for (Integer i : ids) {
			out.println("<li>"+db.getObject(i).getName()+" - capacity: "+db.getObject(i).getCapacity());
		}

  %>
  </ul>
</body>
</html>