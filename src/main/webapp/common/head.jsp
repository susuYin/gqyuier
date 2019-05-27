<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/inc/constants.inc" %>

<script type="text/javascript">
   	$(document).ready(function(){
   		//
   		$("#logout").click(function(){
   			window.location.href = "${CONTEXT_PATH }/login/doLogout?url=${currPath }";
   		});
  	});
</script>

<div class="head-nav">
	<p class="head-title">${empty menusystem.sysname ? "Selenium-Ui" : menusystem.sysname }</p>
	<p class="head-userinfo">
		<c:if test="${not empty USER_SESSION_ID }">
			当前用户：	${USER_SESSION_ID.username }
		 	<span class="separator">|</span>
		 	<span class="logout-icon" id="logout">退出</span>
		</c:if>
	</p>
</div>
