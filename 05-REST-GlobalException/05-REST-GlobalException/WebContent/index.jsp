<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
	</head>
	
	<body>
		<f:view>
		Spring REST Demo
		<hr>
		
		<!-- <a href="myrest/hello">REST Hello World!</a> -->
		<a href="${pageContext.request.contextPath}/myrest/hello">REST Hello World!</a>
		<br></br>
		<a href="${pageContext.request.contextPath}/api/students">List of Students in JSON</a>
		<br></br>
		<a href="${pageContext.request.contextPath}/api/students/0">Specific Student by Id</a>
		
		</f:view>
	</body>
	
</html>