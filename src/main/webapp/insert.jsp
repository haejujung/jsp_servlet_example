<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 삽입</title>
<link rel ="stylesheet" type="text/css" href="css/styles.css">


</head>
<body>
	<h2>데이터 삽입</h2>
	<form action="insert" method="post">
		<label for ="name">이름 : </label>
		<input type="text" id="name" name="name">
		
		<label for ="email">이메일 : </label>
		<input type="email" id="email" name="email" value="a@nate.com">
		<br>
		<button type="submit">저장</button>
		</form>
</body>
</html>