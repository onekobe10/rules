<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'test.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <%@include file="common/head.jsp" %>
    <script src="<%=request.getContextPath()%>/js/test.js"></script>
</head>

<body>
<form action="test">
    <textarea name="textareaTest">${sss }</textarea>
</form>
</body>
<script>
    var test = "${test }";
    var test1 = eval('${test1 }');
    var test2 = null;
    var test3;
    console.log(typeof test2);
    console.log(typeof test3);
    /* if(${not empty test2 }){
		console.log(1);
	}else{
		console.log(2);
	} */
    //console.log(${test2 });
    //var test2 = ${test2 };
</script>
</html>
