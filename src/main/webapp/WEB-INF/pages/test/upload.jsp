<%@page pageEncoding="UTF-8" import="java.util.*,com.boco.eoms.portal.rules.model.*"%>
<%@ page language="java" contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>测试</title>
    <%@include file="../common/head.jsp"%>
</head>
<body>
	<form id="formTest" action="<%=request.getContextPath()%>/rules/" enctype="multipart/form-data">
		文件上传：<input type="file" name="file" />
		姓名：<input type="text" name="username"/>
		密码：<input type="password" name="userpassword"/>
	</form>
</body>
</html>