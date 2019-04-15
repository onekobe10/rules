<%@page pageEncoding="UTF-8" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="content-type" content="text/html;charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>规章制度列表</title>
    <%@include file="../common/head.jsp" %>
    <style type="text/css">
        body {
            background-color: #ffffff;
        }

        .table > thead > tr > th, .table > tbody > tr > th, .table > tfoot > tr > th, .table > thead > tr > td, .table > tbody > tr > td, .table > tfoot > tr > td {
            padding: 8px;
            line-height: 1.42857143;
            vertical-align: middle;
            border-bottom: 0px solid #dddddd;
            border-top: 1px solid #eeeeee;
            text-align: center;
            color: #8A8A8A;
            font-family: "Microsoft YaHei";
        }

        .table > thead > tr > th {
            color: #404D5B;
            font-weight: normal;
        }

        .pagination {
            margin: 0px;
        }

        .pagination > li > a, .pagination > li > span {
            margin-left: 10px;
        }

        .form-group button {
            color: #fff;
            background-color: #0F9FF6;
            width: 80px;
        }

        #content {
            width: 100%;
            overflow: hidden;
        }

        #inner {
            width: 1500px;
        }

        #scrollline {
            border: 1px solid #F7F7F7;
            border-radius: 55px;
            width: 100%;
            height: 12px;
            background: #fff;
            margin-top: 10px;
            position: relative;
        }

        #scrollbtn {
            border-radius: 55px;
            width: 10%;
            height: 8px;
            background: #0E9EF5;
            position: absolute;
            margin-top: 1px;
            left: 0;
            top: 0;
            cursor: move;
        }

        .setRightArrow, .setLeftArrow {
            display: block;
            width: 40px;
        }

        .setRightArrow {
            background: url(${pageContext.request.contextPath }/images/pagingRight.png) no-repeat 15px center;
        }

        .setLeftArrow {
            background: url(${pageContext.request.contextPath }/images/pagingLeft.png) no-repeat 15px center;
        }

        .glyphicon-menu-right::before {
            content: "";
        }

        .glyphicon-menu-left::before {
            content: "";
        }
    </style>
</head>
<body>
<div class="content-main" style="border:1px solid #A4A4A4;border-top:2px solid #0E9EF4;margin-top:-30px; ">
    <br>
    <div style="width: 96%;margin-left:2%;padding-bottom:27px;margin-top:-8px;border-bottom:1px solid #C7C7C7">
        <span style="font-size: 16px;float: left;">查询规章制度</span>
    </div>
    <div class="content-body">
        <div class="container-fluid" style="padding: 10px" id="iframe_show_s">
            <form id="seach_form" enctype="application/x-www-form-urlencoded" class="form-horizontal" method="POST"
                  action="${pageContext.request.contextPath}/rules/query/main">
                <input type="hidden" id="pageNum" name="pageNum" value="${page.pageNum}">
                <div class="container-fluid" style="border-bottom:1px solid #C7C7C7">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-group">
                                <label class="col-sm-2 control-label"
                                       style="font-weight:normal;font-size: 16px;text-align: left;"
                                       for="theme">主题</label>
                                <div class="col-sm-10" style="margin-left:-35px;">
                                    <input type="text" class="form-control" id="theme" name="theme"
                                           value="${rules.theme }"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-group">
                                <label class="col-sm-2 control-label"
                                       style="font-weight:normal;font-size: 16px;text-align: left;"
                                       for="search_applicationType">产品类型</label>
                                <div class="col-sm-10" style="margin-left: -35px;">
                                    <div id="divselect1" class="divselect">
                                        <input id="productType" type="hidden" name="productType"/>
                                        <div tabindex="0"
                                             style="background: url('<%=request.getContextPath()%>/images/select.png') no-repeat 98% center;">
                                            <c:forEach items="${productType }" var="map">
                                                <c:if test="${map.key eq rules.productType  and not empty rules.productType }">
                                                    ${map.value }
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                        <ul style="margin: 0;padding: 0;">
                                            <c:forEach items="${productType }" var="map">
                                                <c:if test="${map.key != rules.productType }">
                                                    <li><a value="${map.key }" href="javascript:;">${map.value }</a>
                                                    </li>
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"
                                       style="font-weight:normal;font-size: 16px;text-align: left;"
                                       for="buildDate">新建时间</label>
                                <div class='col-sm-8'>
                                    <input id="buildDate" type="text" class="form-control" name="buildDate"
                                           value="<fmt:formatDate value='${rules.buildDate }' pattern='yyyy-MM-dd'/>"
                                           onclick="WdatePicker({isShowClear:false,readOnly:true,dateFmt:'yyyy-MM-dd'})"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6">
                            <div class="form-group">
                                <label class="col-sm-3 control-label"
                                       style="font-weight:normal;font-size: 16px;text-align: left;" for="buildPerson">新建人员</label>
                                <div class='col-sm-8'>
                                    <input id="buildPerson" type="text" class="form-control" name="buildPerson"
                                           value="${rules.buildPerson }"/>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-3" align="right" style="float:left;margin-left:10%;">
                            <div class="form-group">
                                <button class="btn btn-succes" type="button" onclick="removeData()">重置</button>&nbsp;&nbsp;&nbsp;
                                <button class="btn btn-succes" type="submit">查询</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <div id="box">
                <div id="content">
                    <div id="inner">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th width="3%" valign="middle">主题</th>
                                <th width="3%" valign="middle">产品类型</th>
                                <th width="5%" valign="middle">简介</th>
                                <th width="3%" valign="middle">新建时间</th>
                                <th width="3%" valign="middle">新建人员</th>
                                <th width="8%" valign="middle">规章制度(下载)</th>
                                <th width="3%" valign="middle">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="index" items="${queryRulesList }" varStatus="status">
                                <tr>
                                    <c:choose>
                                        <c:when test="${fn:length(index.theme) > 14}">
                                            <td>${fn:substring(index.theme, 0, 14)}</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${index.theme}</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:forEach items="${productType }" var="map">
                                        <c:choose>
                                            <c:when test="${map.key==index.productType }">
                                                <td>${map.value }</td>
                                            </c:when>
                                        </c:choose>
                                    </c:forEach>
                                    <c:choose>
                                        <c:when test="${fn:length(index.introduce) > 10 }">
                                            <td>${fn:substring(index.introduce,0,10)}.....</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${index.introduce }</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td><fmt:formatDate value="${index.buildDate}" type="both"
                                                        pattern="yyyy-MM-dd"/></td>
                                    <td>${index.buildPerson}</td>
                                    <td><a style="color:blue;"
                                           href="${pageContext.request.contextPath}/rules/file/download?rulesId=${index.id }">${index.rules }</a>
                                    </td>
                                    <td><a style="color:blue;" href="javascript:void(0);"
                                           onclick="roleTypeJudge(this,'${index.id }')" id="update">修改</a>/<a
                                            style="color:blue;" href="javascript:void(0);"
                                            onclick="roleTypeJudge(this,'${index.id }')" id="delete">删除</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div id="scrollline">
                    <div id="scrollbtn">
                    </div>
                </div>
            </div>
            <div style="width:100%;height:50px;;padding:0px 10px 0px 0px;margin-top:24px;">
                <div style="width:8%;height:35px;border-radius:5px;border:1px solid #DDDDDD;float:left;text-align:center;padding-top:8px;">
                    <span>共  ${page.lastPage} 页</span>
                </div>

                <nav class="text-right">
                    <ul class="pagination">
                        <c:choose>
                            <c:when test="${page.isFirstPage}">
                                <li><a class="disabled setLeftArrow"><span class="glyphicon glyphicon-menu-left"
                                                                           aria-hidden="true"></span></a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a class="setLeftArrow" name="page_item" pageNum="${page.prePage}"
                                       style="cursor:pointer"><span class="glyphicon glyphicon-menu-left"
                                                                    aria-hidden="true"></span></a></li>
                            </c:otherwise>
                        </c:choose>
                        <c:forEach var="index" items="${index_nums}" varStatus="status">
                            <c:choose>
                                <c:when test="${page.pageNum eq index}">
                                    <li><a class="disabled" style="background-color:#0EA0F4;color: #FFFFFF">${index}</a>
                                    </li>
                                </c:when>
                                <c:otherwise>
                                    <li><a name="page_item" pageNum="${index}"
                                           style="cursor:pointer;color: #676767">${index}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${page.isLastPage}">
                                <li><a class="disabled setRightArrow"><span class="glyphicon glyphicon-menu-right"
                                                                            aria-hidden="true"></span></a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a class="setRightArrow" name="page_item" pageNum="${page.nextPage}"
                                       style="cursor:pointer"><span class="glyphicon glyphicon-menu-right"
                                                                    aria-hidden="true"></span></a></li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    window.onload = function () {
        divselect();
    };
    //分页
    $('a[name=page_item]').click(function () {
        var pageNum = $(this).attr('pageNum');
        $('#pageNum').val(pageNum);
        $('#seach_form').submit();
    });

    //重置
    function removeData() {
        $("#theme").val("");
        $("#divselect1 div").text("请选择");
        $("#divselect1 div").css("color", "#e1e1e1");
        $("#divselect1 #productType").val("");
        $("#buildDate").val("");
        $("#buildPerson").val("");
    }

    //自定义下拉选
    function divselect() {
        $("#divselect1 div").click(function () {
            $("#divselect1 ul").slideToggle("fast");
            $("#divselect1 div").css("border", "1px solid #0E9EF4");
            $("#divselect1 ul").css("border", "1px solid #0E9EF4");
        })

        $("#divselect1 ul li a").click(function () {
            $("#divselect1 div").focus();
            var bb = $(this).text();
            var aa = $(this).attr("value");
            $("#divselect1 div").text(bb);
            $("#divselect1 div").css("color", "#555");
            $("#divselect1 #productType").val(aa);
            $("#divselect1 ul").css("display", "none");
            $("#divselect1 div").css("border", "0px solid #0E9EF4");
            $("#divselect1 div").css("border", "1px solid #0E9EF4");

        })
        $("#divselect1 div").blur(function () {
            $("#divselect1 div").css("border", "1px solid #ccc");
            $("#divselect1 ul").css("border", "1px solid #ccc");
        })
    }

    //自定义滚动条
    var oBox = document.getElementById("box");
    var oBar = document.getElementById("scrollbtn");
    var oscrollline = document.getElementById("scrollline");
    var disX = 0;
    var maxL = 786;
    var iScale = 0;
    var oInner = document.getElementById("inner");
    var oContent = document.getElementById("content");
    oBar.onmousedown = function (event) {
        var event = event || window.event;
        disX = event.clientX - oBar.offsetLeft;
        document.onmousemove = function (event) {
            var event = event || window.event;
            var iL = event.clientX - disX;
            iL <= 0 && (iL = 0);
            iL >= maxL && (iL = maxL);
            oBar.style.left = iL + "px";
            oInner.style.marginLeft = -(oInner.offsetWidth - oContent.offsetWidth) * iScale + "px";
            iScale = iL / maxL;
            return false
        };
        document.onmouseup = function () {
            document.onmousemove = null;
            document.onmouseup = null
        };
        return false
    };
    oBox.onmouseover = function (event) {
        event = event || window.event;

        function mouseWheel(event) {
            var delta = event.wheelDelta ? event.wheelDelta : -event.detail * 40
            var iTarget = delta > 0 ? -30 : 30;
            togetherMove(oBar.offsetLeft + iTarget)
            stopEventBubble(event);
        }

        addHandler(this, "mousewheel", mouseWheel);
        addHandler(this, "DOMMouseScroll", mouseWheel);
    };
    oscrollline.onclick = function (event) {
        var iTarget = (event || window.event).clientX - oBox.offsetLeft - this.offsetLeft - oBar.offsetWidth / 2;
        togetherMove(iTarget)
    };

    function togetherMove(iTarget) {
        if (iTarget <= 0) {
            iTarget = 0
        } else if (iTarget >= maxL) {
            iTarget = maxL
        }
        iScale = iTarget / maxL;
        oInner.style.marginLeft = -(oInner.offsetWidth - oContent.offsetWidth) * iScale + "px";
        oBar.style.left = iTarget + "px";
    }

    function addHandler(element, type, handler) {
        return element.addEventListener ? element.addEventListener(type, handler, false) : element.attachEvent("on" + type, handler)
    };

    function stopEventBubble(event) {
        var e = event || window.event;
        if (e && e.stopPropagation) {
            e.stopPropagation();
        } else {
            e.cancelBubble = true;
        }
    };

    //判断用户权限
    function roleTypeJudge(index, indexId) {
        $.ajax({
            url: "<%=request.getContextPath()%>/rules/regulation/roleTypeJudge",
            type: "POST",
            dataType: "json",
            async: false,
            success: function (data) {
                if (data.flag == "true") {
                    var id = $(index).attr("id");
                    if (id == "update") {
                        $(index).attr("href", "${pageContext.request.contextPath}/rules/query/details?rulesId=" + indexId);
                    } else if (id = "delete") {
                        $(index).attr("href", "${pageContext.request.contextPath}/rules/regulation/delete?rulesId=" + indexId);
                    }
                } else if (data.flag == "false") {
                    alert(data.msg);
                }
            },
            error: function () {
                alert("error");
            }
        });
    }
</script>
</html>