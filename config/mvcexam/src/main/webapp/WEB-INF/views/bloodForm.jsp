<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="blood">
이름 : <input type="text" name="name"><br>
혈액형 : <select name="bloodType">
    <option value="A"> A형 </option>
    <option value="B"> B형 </option>
    <option value="O"> O형 </option>
    <option value="AB"> AB형 </option>
</select>
<input type="submit" value="확인">  
</form>  
</body>
</html>