<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New trip</title>
</head>
<body>
<form action="./processingServlet">
  Please enter a trip name: <br>
  <input type="text" name="trip" size="20px">
  <br>
  Please enter a trip capacity: <br>
  <input type="text" name="capacity" size="10">
  <br>
  <input type="submit" value="submit">
</form>
</body>
</html>