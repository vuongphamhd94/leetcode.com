<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="modal-dialog modal-xl">
	<div class="modal-content">
		<div class="modal-header bg-primary text-white">
			<h5 class="modal-title" id="exampleModalLabel">Thông tin giỏ
				hàng</h5>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<div class="modal-body px-3">
			<table class="table table-bordered table-striped mt-3">
				<thead>
					<tr class="table-active text-center">
						<th>STT</th>
						<th>Tên sản phẩm</th>
						<th>Đơn giá</th>
						<th>Số lượng</th>
						<th>Thành tiền</th>
						<th>Thao tác</th>
					</tr>

				</thead>
				<tbody id="cartTB">
					<c:import url="_CartTb.jsp">
						<c:param name="cart" value="cart" />
					</c:import>
				</tbody>
			</table>
		</div>
		<div class="modal-footer">
			<c:if test="${cart != null }">
				<button type="button" class="btn btn-success check-out" data-type="get" data-url="cart">Đặt
					hàng</button>
			</c:if>
			<button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
		</div>
	</div>
</div>
