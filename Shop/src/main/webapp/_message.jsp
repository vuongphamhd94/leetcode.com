<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${ms != null }">
	<div
		class="toast-header bg-${ms.type} text-white  d-flex justify-content-between">
		<h5 class="mr-3">${ms.title}</h5>
		<button type="button" class="ml-2 mb-1 close" data-dismiss="toast"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	<div class="toast-body alert-${ms.type}">${ms.message}</div>
</c:if>