<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-dialog" role="document">
	<div class="modal-content">
		<div class="modal-header bg-primary text-white">
			<h5 class="modal-title" id="exampleModalLabel">Chi tiết sản phẩm</h5>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<div class="modal-body px-4 my-5">
			<div class="detail-img text-center mb-5">
				<img src="${product.sourceImg}" alt="${product.name}">
			</div>
			<div class="detail-content text-center">
				<h3>${product.name}</h3>

				<table class="table mt-5">
					<tr>
						<th class="text-nowrap w-25 text-left">Giá sản phẩm</th>
						<td>${product.strPrice}</td>
					</tr>
					<tr>
						<th class="text-nowrap w-25 text-left">Thông tin sản phẩm</th>
						<td>${product.details}</td>
					</tr>
				</table>
			</div>
			<div class="detail-form pl-3 mt-4">
				<form class="form-inline mt-5 mt-auto row  justify-content-end" data-type="post"
					data-url="detail">
					<div class="col my-2">
						<label for="amount" style="display: inline-block;">Số lượng</label>
					</div>
					<div class="col my-2">
						<input type="number" name="amount" class="form-control" value="1" min="1"
							max="100" placeholder="Số lượng sản phẩm">
					</div>
					<div class="form-group my-2 pr-3">
						<input type="hidden" name="id" value="${product.id}">
						<button type="button" class="btn btn-danger text-nowrap quickSubmit">
							<i class="fa-regular fa-cart-arrow-down"></i>Thêm vào giỏ hàng
						</button>
					</div>
				</form>

			</div>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
		</div>
	</div>
</div>