<%@page session="false" contentType="text/html" pageEncoding="UTF-8" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/successCss/style.css" media="all"/>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<body>
<div class="success_page" style="border:0px solid red;margin-top:500px;">
    <p id="timeinter">3秒后跳转到前一页</p>
    <ul>
        <li>
            <a href="<%=request.getContextPath() %>/${returnpath}">返回>></a>
        </li>
    </ul>
</div>
<script>

    var i = 0;
    var time = 3; //时间,秒
    function dis() {
        i++;
        document.getElementById("timeinter").innerHTML = "<span style='align:center'>" + (time - i) + "秒后跳转到之前页面</span>";
    }

    timer = setInterval('dis()', 1000);
    timer = setTimeout(function () {
        window.location.href = "<%=request.getContextPath() %>/${returnpath}";
    }, time * 1000);
</script>
</body>
