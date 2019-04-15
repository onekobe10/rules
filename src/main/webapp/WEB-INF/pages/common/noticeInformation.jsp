<%@page pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <div id="noticeInformation" class="content-body">
    	公告信息
        <div class="container-fluid" style="padding:0px" id="iframe_show_s">
        	<table class="table table-bordered">
	        	<tr>
		            <td class="col-xs-2"><label class="control-label">发布人</label></td>
		            <td class="col-xs-4" colspan="5">
		            	${notice.publisher }
		            </td>
		            <td class="col-xs-2"><label class="control-label">发布人所在部门</label></td>
		            <td class="col-xs-4" colspan="5">
		            	${notice.publisher_dept }
		            </td>
	        	</tr>
	        	<tr>
		            <td class="col-xs-2"><label class="control-label">发布人联系方式</label></td>
		            <td class="col-xs-4" colspan="5">
		            	${notice.publisher_phone }
		            </td>
		            <td class="col-xs-2"><label class="control-label">公告类型</label></td>
		            <td class="col-xs-4" colspan="5">
		            	<c:forEach items="${noticeType }" var="map">
								<c:choose>
									<c:when test="${map.key==notice.notice_type }">
										${map.value }
									</c:when>
								</c:choose>
							</c:forEach>
		            </td>
	        	</tr>
	        	<tr>
		            <td class="col-xs-2"><label class="control-label">发布时间</label></td>
		            <td class="col-xs-4" colspan="5">
		            	<fmt:formatDate  value="${notice.create_time }" type="both" pattern="yyyy-MM-dd" />
		            </td>
		            <td class="col-xs-2"><label class="control-label">有效时间</label></td>
		            <td class="col-xs-4" colspan="5">
		            	<fmt:formatDate  value="${notice.limit_time }" type="both" pattern="yyyy-MM-dd" />
		            </td>
	        	</tr>
	       	 	<tr>
		            <td class="col-xs-2"><label class="control-label">发布范围</label></td>
		            <td colspan="8">
		            	${notice.publish_range }
		            </td>
	        	</tr>
     	 	</table>
        </div>
</html>