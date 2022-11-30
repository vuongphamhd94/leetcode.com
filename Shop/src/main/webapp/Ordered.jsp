<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="shear/_head.jsp">
	<c:param name="title" value="Danh sách đơn hàng" />
	<c:param name="sumPr" value="${sumPr }" />
</c:import>
<!-- begin body -->
<section class="m-5">
	<div class="my-3">Danh sách đơn hàng</div>
	<table class="table table-bordered table-striped">
		<%!int stt = 1;%>
		<thead>
		<tr class="table-active text-center">
			<th scope="col" class="w-5">STT</th>
			<th scope="col">Ngày tháng</th>
			<th scope="col">Địa chỉ nhân hàng</th>
			<th scope="col">Danh sách sản phẩm</th>
			<th scope="col">Mã Giảm giá</th>
			<th scope="col">Trạng thái</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${orders}" var="item" >
			<tr>
				<td class="text-center"><%= stt++ %></td>
				<td class="text-center">${item.date }</td>
				<td>${item.address }</td>
				<td  class="pl-5">
						<ol>
							<c:forEach items="${item.listOrder }" var="o">
								<li>${o.productName} x ${o.amount}(pcs)</li>
							</c:forEach>
						</ol>
					</td>
				<td class="text-center">${item.discountCode }</td>
				<td><c:choose>
						<c:when test="${item.status == 1}">
							<div class="text-warning text-center">Đang chờ xác nhận</div>
						</c:when>
						<c:when test="${item.status == 2}">
							<div class="text-primary text-center">Đang vận chuyển</div>
						</c:when>
						<c:when test="${item.status == 3}">
							<div class="text-success text-center">Đã nhận hàng</div>
						</c:when>
						<c:otherwise>
							<div class="text-danger text-center">Đơn hàng bị lỗi</div>
						</c:otherwise>
					</c:choose></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</section>

<!-- end body -->
<!-- modal -->
<div class="modal fade" id="order" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true"></div>
	
<c:import url="shear/_footer.jsp"/>
<%--Thông báo ms --%>
<div class="position-fixed bottom-0 right-0 p-3"
	style="z-index: 5; right: 0; bottom: 0; width: 350px" id="toast">
	<c:if test="${ms != null}">
		<div class="toast" role="alert" aria-live="assertive"
			aria-atomic="true" data-delay="2000">
			<c:import url="_message.jsp">
				<c:param name="ms" value="${ms}" />
			</c:import>
		</div>
	</c:if>
</div>