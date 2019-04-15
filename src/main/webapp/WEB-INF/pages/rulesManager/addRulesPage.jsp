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
    <title>新建规章制度</title>
    <%@include file="../common/head.jsp"%>
    <script src="<%=request.getContextPath()%>/ueditor/ueditor.config.js"></script>
    <script src="<%=request.getContextPath()%>/ueditor/ueditor.all.min.js"></script>
    <script src="<%=request.getContextPath()%>/ueditor/lang/zh-cn/zh-cn.js"></script>
    <link href="<%=request.getContextPath()%>/css/notice.css" rel="stylesheet" media="screen">
    <link rel="stylesheet"
		href="${pageContext.request.contextPath }/js/zTreeStyle/zTreeStyle.css">
	<script
		src="${pageContext.request.contextPath }/js/zTreeStyle/jquery.ztree.all-3.5.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/js/zTreeStyle/jquery.ztree.excheck-3.5.js"></script>
	<style type="text/css">
		 .a-upload {
		    padding: 4px 10px;
		    height: 30px;
		    line-height: 20px;
		    position: relative;
		    cursor: pointer;
		    color: #888;
		    background: #fafafa;
		    border: 1px solid #ddd;
		    overflow: hidden;
		    display: inline-block;
		    *display: inline;
		    *zoom: 1
		}
	
		.a-upload  input {
		    position: absolute;
		    font-size: 100px;
		    right: 0;
		    top: 0;	
		    opacity: 0;
		    filter: alpha(opacity=0);
		    cursor: pointer
		}
		.a-upload:hover {
		    color: #444;
		    background: #eee;
		    border-color: #ccc;
		    text-decoration: none
		}
		.showFileName{
			color: blue;
			font-size: 15px;
		}
	</style>	
</head>
<body>
	<div  class="content-main">
	    <div class="title">
	    	<span>新建规章制度</span>
	    </div>
	    <div class="content-body">
	        <form action="<%=request.getContextPath()%>/rules/regulation/save" method="post" id="rulesInf" enctype="multipart/form-data">
			    <div class="row">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <label for="theme1" class="col-sm-2 control-label labelName">主题</label>
                            <div class="col-sm-9">
                                <input class="form-control"  onBlur="if(this.value=='') this.placeholder='此处必填';"  type="text"  
                                	id="theme1" name="theme" />
                            </div>
                            <div class="col-sm-1">
                                <img src="<%=request.getContextPath() %>/images/xing.png"  class="redStar"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <label for="product_type" class="col-sm-2 control-label labelName">产品类型</label>
                            <div class="col-sm-9">
								<select  class="form-control" id="product_type"  name="productType"  style="background: url('<%=request.getContextPath()%>/images/select.png') 
									no-repeat scroll  99% center transparent;">
									<option value="">请选择</option>
									<c:forEach items="${productType }" var="map">
                                			<option value="${map.key }">${map.value }</option>
									</c:forEach>
                                </select>
						 	</div>
                            <div class="col-sm-1">
                                <img src="<%=request.getContextPath() %>/images/xing.png"  class="redStar"/>
                            </div>
                        </div>
                    </div>
                 </div> 
                 <div class="row" style="margin-left:-9px;">
                    <div class="col-xs-6">
                        <div class="form-group">
                            <label  class="col-sm-4 control-label labelName">新建时间</label>
                            <div class='col-sm-7'>
								<input  type="text" class="form-control" id="buildDate1" name="buildDate"  value="" readonly="readonly"/>
							</div>
                        </div>
                    </div>
                    <div class="col-xs-6">
 	                    <div class="form-group" style="margin-left:-10px;">
                      	   	<label  class="col-sm-3 control-label labelName">新建人员</label>
                            <div class='col-sm-7'>
								<input  type="text" class="form-control" id="buildPerson1" name="buildPerson"  value="${userId }" readonly />
							</div>
                         </div>
                    </div>
                </div>  
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <label for="rules1" class="col-sm-2 control-label labelName">规章制度</label>
                            <div class="col-sm-9">
	                            <a href="javascript:;" class="a-upload">
	   								<input type="file" name="file">添加上传文件
								</a><span class="showFileName"></span>
							</div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <label for="remarks" class="col-sm-2 control-label labelName">简介</label>
                            <div class='col-sm-9' >
                            	<textarea  id="introduce" class="form-control" name="introduce" style="height:120px;" ></textarea>
							</div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="form-group">
                            <label for="remarks" class="col-sm-2 control-label labelName">备注</label>
                            <div class='col-sm-9' >
                            	<textarea  id="remarks1" class="form-control" name="remarks" style="height:120px;" ></textarea>
							</div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-8">
                    </div>
                    <div class="col-xs-4">
                    	<div class="form-group">
                    		<div class="col-sm-4">
                    			<button class="btn btn-succes" type="button" onclick="history.back()">返回</button>
                    		</div>
							<div class="col-sm-8">
							<!-- <input type="submit" value="提交"> -->
                    			<button class="col-sm-6 btn btn-succes" type="button" onclick="return validat();">提交</button>
                    		</div>
                     	</div>
                    </div>
                </div>
			</form>
	    </div>
	</div>
</body>
<script>
	//初始化加载
	$(function () {
		showTime();
	});
	//将文件名显示到文件标签之后
	$(".a-upload").on("change","input[type='file']",function(){
  		var filePath=$(this).val();
        var arr=filePath.split('\\');
        var fileName=arr[arr.length-1];
        $(".showFileName").html("&nbsp;&nbsp;&nbsp;"+fileName);
        
	})
	//显示发布时间基准时间
    function showTime(){
    	today = new Date();
    	year = today.getFullYear();
    	month = (today.getMonth()+1)+"";
		date = today.getDate()+"";
		$("#buildDate1").val(year + "-" + month + "-" + date);
	}
	function validat(){//验证表单提交
		var rulesInf = document.getElementById("rulesInf");
		var theme1 = document.getElementById("theme1");
		var product_type = document.getElementById("product_type");
		var reg=/^[a-zA-Z0-9_\u4e00-\u9fa5]+$/;
		if(theme1.value==''){
			alert("请填写规章制度主题!");
			theme1.focus();
			return false;
		}else if (!reg.exec(theme1.value)){
		    alert("请输入只含有汉字、数字、字母、下划线的值！");
		    theme1.focus();
			return false;
		}else if(theme1.value.length>50){
			alert("最多支持50个汉字!");
			theme1.focus();
			return false;
		}else if(product_type.value==''){
			alert("请选择产品类型!");
			return false;
		}
	    rulesInf.submit();
	}	
</script>
</html>