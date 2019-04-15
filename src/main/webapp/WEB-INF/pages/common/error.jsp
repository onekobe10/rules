<%@page session="false" contentType="text/html" pageEncoding="UTF-8"  %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/view/css/style.css" media="all" />     
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<body>
<div class="fail_page"  style="border:0px solid red;margin-top:100px;">

<p id="timeinter" align="center" ><font style="color: red" >${msg}</font><br/>3秒后跳转到列表页面</p>
<br/>
<ul >
	<li> 
	<br/>
		<a href="<%=request.getContextPath() %>/${path}">返回列表页面>></a>
	</li>
</ul>
</div>	
<script>
	
	 var i = 0;
	var time = 3; //时间,秒
	function dis() {
		i++;
		document.getElementById("timeinter").innerHTML = "<span style='align:center'>" + "<font style=\"color: red\" >${msg}</font></br>"+(time - i) + "秒后跳转到列表页面</span>";
	}
	
	timer = setInterval('dis()', 1000);
	timer = setTimeout(function() {window.location.href="<%=request.getContextPath() %>/${path}";}, time * 1000); 
</script>
</body>
