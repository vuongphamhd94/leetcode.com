<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:forEach items="${cart}" var="o">
	<tr>
		<td class="stt text-center"></td>
		<td>${o.productName }</td>
		<td class="text-right">${o.PriceToString()}</td>
		<td class="text-center">${o.amount}</td>
		<td class="text-right">${o.total}</td>
		<td class="text-center">
			<button type="button" class="btn btn-danger delete"  title="Xóa" data-id="${o.productId}" data-url="delete" data-type="post" data-tager="order" data-amount="${o.amount}">
				<i class="fa-solid fa-trash mr-0 p-1"></i>
			</button>
		</td>
	</tr>
</c:forEach>
<tr class="text-center text-danger">
	<td colspan="3">Tổng hóa đơn</td>
	<td colspan="3">${total}</td>
</tr>