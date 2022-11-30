<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="shear/_head.jsp">
	<c:param name="title" value="Quản lý đơn đặt hàng" />
	<c:param name="sumPr" value="${sumPr}" />
</c:import>
<!-- begin body -->
<section class="m-5">
	<div class="mb-3">Quản lý danh sách đơn đặt hàng</div>
	<table class="table table-bordered table-striped">
		<thead>
			<tr class="table-active text-center">
				<th>STT</th>
				<th>Người nhận</th>
				<th>Địa chỉ</th>
				<th>Danh sách sản phẩn</th>
				<th>Trạng thái đơn hàng</th>
				<th>Thao tác</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${orders}" var="item">
				<tr>
					<td class="stt text-center"></td>
					<td>${item.acc.fullName}</td>
					<td>${item.address}</td>
					<td  class="pl-5">
						<ol>
							<c:forEach items="${item.listOrder }" var="o">
								<li>${o.productName} x ${o.amount}(pcs)</li>
							</c:forEach>
						</ol>
					</td>
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
					<td><c:if test="${item.status == 1}">
							<a href="qldh?status=2&id=${item.id }" class="btn btn-success" title="Xác nhận đơn hàng">Xác
								nhận</a>
							<a href="qldh?status=4&id=${item.id }" class="btn btn-danger" title="Xác nhận đơn hàng">Hủy</a>
						</c:if></td>
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