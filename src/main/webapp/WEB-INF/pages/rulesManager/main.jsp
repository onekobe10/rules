<%@page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>规章制度管理</title>
    <%@include file="../common/head.jsp"%>

<style type="text/css">
body {
    margin: 0;
    padding: 0;
	word-wrap: break-word;
}
.menu-first>li>a { 
 font-weight: normal; 
 border-bottom: 0px solid #999999;
}
.menu-second>li>a { 
	font-weight:normal; 
	border-bottom: 0px solid #efefef;  
	padding-left: 40px; 
	padding-top: 5px; 
	font-size: 16px;
	height: 41px;
}
.menu-first {
    margin: 10px 15px 0 15px;
    padding-bottom: 0;
}
#userMeun li{
	border-bottom:1px solid #9E9E9E;
	height:43px;
	line-height:30px;
}
</style>
</head>
<body height="750px">
        <div class="container"  style="border:0px solid red;height:100%;">
            <div class="row">
                <div class="col-md-3" style="padding:0px;">
                    <div class="content-main" style="border:1px solid #CCCCCC;border-top:2px solid #0E9EF4;margin-top:20px;padding-top:10px; width: 90%;">
                        <ul class="nav nav-list menu-first" style="width:100% ;margin:0;">
                            <li>
                                <span style="font-size: 18px;padding-left: 20px;border-bottom:1px solid #9E9E9E;display:block;height:30px;">规章制度管理</span>
                                <ul class="nav nav-list menu-second in collapse" id="userMeun" style="height: auto;">
                                	<li>
                                    	<a href="javascript:void(0);"  name="menu_click_able_1" relhref="<%=request.getContextPath()%>/rules/regulation/addPage" onclick="addPage()" id="addPage" title="新建规章制度">新建规章制度
                                    		<span class="glyphicon glyphicon-menu-right pull-right" style="margin-top: 6px;color: #a5a5a5"  aria-hidden="true"></span>
                                    	</a>
                                    </li>
                                	<li>
                                    	<a href="javascript:void(0);"  name="menu_click_able" relhref="<%=request.getContextPath()%>/rules/file/export" title="导出规章制度">导出规章制度
                                    		<span class="glyphicon glyphicon-menu-right pull-right" style="margin-top: 6px;color: #a5a5a5"  aria-hidden="true"></span>
                                    	</a>
                                    </li>
                                    <li>
                                    	<a href="javascript:void(0);"  name="menu_click_able" relhref="<%=request.getContextPath()%>/rules/query/main" title="规章制度列表">规章制度列表
                                    		<span class="glyphicon glyphicon-menu-right pull-right" style="margin-top: 6px;color: #a5a5a5"  aria-hidden="true"></span>
                                    	</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-md-9" valign="top" valign="top" style="padding:0px;">
                    <iframe id="iframeTypeManager" width="100%" height="700"  align="center" frameborder="0" scrolling="no"  src="<%=request.getContextPath()%>/rules/query/main"  onLoad="iFrameHeight()"></iframe>
                </div>
            </div>
        </div>
</body>
<script>
    $('a[name=menu_click_able]').click(function(){
        var relhref=$(this).attr('relhref');
        $('#iframeTypeManager').attr('src',relhref);
    });
     //frame自适应
	function iFrameHeight() {   
		var ifm= document.getElementById("iframeTypeManager");   
		var subWeb = document.frames ? document.frames["iframeTypeManager"].document : ifm.contentDocument;   
		if(ifm != null && subWeb != null) {
		   var iframeHeight = subWeb.body.scrollHeight;
		   if(iframeHeight<400){
		   		iframeHeight = 400;
		   }
		   ifm.height = subWeb.body.scrollHeight<700?700:subWeb.body.scrollHeight+20;
		   window.top.$('#iframeTypeManager').attr('height',iframeHeight);
		}   
	}
	function addPage(){
		var relhref = $("#addPage").attr("relhref");
  		$('#iframeTypeManager').attr('src',relhref);	
		<%-- $.ajax({
	          url: "<%=request.getContextPath()%>/rules/regulation/roleTypeJudge",
	          type: "POST",
	          dataType: "json",
	          async: false,
	          success: function(data) {
	          	if(data.flag == "true"){
	          		var relhref = $("#addPage").attr("relhref");
	          		$('#iframeTypeManager').attr('src',relhref);
	           	}else if(data.flag == "false"){
	        	  alert(data.msg);
	          	}
	          },
	          error: function() {
	            alert("error");
	          }
      	}); --%>
	}
</script>
</html>