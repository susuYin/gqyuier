<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tu" uri="/WEB-INF/tlds/content-override.tld"%>
<%@ include file="/inc/constants.inc" %>

<%-- 头部 --%>
<tu:content contentId="head">
	<title>首页</title>
   	<script type="text/javascript">
   		$(document).ready(function(){
   			//
   		});
   		
	</script>
</tu:content>

<%-- 内容 --%>
<tu:content contentId="content">
	<div class="layui-tab">
		<fieldset class="layui-elem-field">							  
			<div class="layui-field-box">
				这里是首页
			</div>
		</fieldset>
		
	</div>
</tu:content>

<%@ include file="/common/tu-template.jsp" %>