<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="modal-dialog modal-xl">
	<div class="modal-content">
		<div class="modal-header bg-primary text-white">
			<h5 class="modal-title" id="exampleModalLabel">Thông tin đơn
				hàng</h5>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<div class="modal-body px-3">
			<form data-url="cart" data-type="post" id="form-order">
				<div class="form-group row">
					<label for="total" class="col-sm-4 col-form-label">Tổng số
						tiền</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="fullName" id="total"
							placeholder="Tổng đơn hàng" value="${total}" readonly="readonly">
					</div>
				</div>
				<div class="form-group row">
					<label for="inputPassword" class="col-sm-4 col-form-label">Tên
						người nhận</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="fullName"
							id="input-email" placeholder="Họ và tên" value="${acc.fullName }"
							readonly="readonly">
					</div>
				</div>
				<div class="form-group row">
					<label for="input-address" class="col-sm-4 col-form-label">Địa
						chỉ nhận hàng</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="address"
							id="input-address" placeholder="Địa chỉ" value="${acc.address }">
					</div>
				</div>
				<div class="form-group row">
					<label for="input-code" class="col-sm-4 col-form-label">Mã
						giảm giá(nếu có)</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="discountCode"
							id="input-code" placeholder="Mã giảm giá">
					</div>
				</div>
				<input type="hidden" name="orderId" value="${orderId }">

			</form>
		</div>
		<div class="modal-footer">
			<button type="submit" class="btn btn-success check-out-order">Xác
				nhận đặt hàng</button>
			<button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
		</div>
	</div>
</div>
