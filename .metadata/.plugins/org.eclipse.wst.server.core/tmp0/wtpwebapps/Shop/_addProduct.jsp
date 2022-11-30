<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-dialog modal-xl">
	<div class="modal-content">
		<div class="modal-header bg-primary text-white">
			<h5 class="modal-title" id="exampleModalLabel">Thêm mới sản phẩm</h5>
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<div class="modal-body px-3">
			<c:choose>
				<c:when test="${product == null }">
					<form data-url="qlsp" id="formAddPr" data-url="qlsp"
						data-type="post" data-action="add">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="img">Ảnh của sản phẩm</label> <input type="text"
									class="form-control" name="img"
									placeholder="Link ảnh của sản phẩm" required>
							</div>
							<div class="form-group col-md-6">
								<label for="name">Tên sản phẩm</label> <input type="text"
									class="form-control" name="name" placeholder="Tên Sản phẩm"
									required>
							</div>
						</div>
						<div class="form-group">
							<label for="detail">Thông tin sản phẩm</label>
							<textarea class="form-control" name="detail" rows="8"
								placeholder="Thông tin sản phẩm" required style="resize: none;"></textarea>
						</div>
						<div class="form-row">
							<div class="col-md-4 mb-3">
								<label for="price">Giá sản phẩm</label><small
									id="passwordHelpInline" class="text-muted"> (Đơn vị
									triệu VND.) </small> <input type="number" class="form-control"
									name="price" placeholder="Giá sẩn phẩm" value="0" min="0"
									max="100" required>
								<div class="valid-feedback"></div>
							</div>

							<div class="col-md-4 mb-3">
								<label for="type">Loại sản phẩm</label> <input type="text"
									class="form-control" name="type" placeholder="Loại sản phẩm"
									required>
								<div class="valid-feedback"></div>
							</div>

							<div class="col-md-4 mb-3">
								<label for="brand">Nhãn hiệu sản phẩm</label> <input type="text"
									class="form-control" name="brand"
									placeholder="Nhãn hiệu sản phẩm" required>
								<div class="valid-feedback"></div>
							</div>
						</div>
					</form>
				</c:when>
				<c:otherwise>
					<form data-url="qlsp" id="formAddPr" data-url="qlsp"
						data-type="post" data-action="change">
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="img">Ảnh của sản phẩm</label> <input type="text"
									value="${product.sourceImg }" class="form-control" name="img"
									placeholder="Link ảnh của sản phẩm" required>
							</div>
							<div class="form-group col-md-6">
								<label for="name">Tên sản phẩm</label> <input type="text"
									value="${product.name }" class="form-control" name="name"
									placeholder="Tên Sản phẩm" required>
							</div>
						</div>
						<div class="form-group">
							<label for="detail">Thông tin sản phẩm</label>
							<textarea class="form-control" name="detail"
								rows="8" placeholder="Thông tin sản phẩm" required
								style="resize: none;">${product.details }</textarea>
						</div>
						<div class="form-row">
							<div class="col-md-4 mb-3">
								<label for="price">Giá sản phẩm</label><small
									id="passwordHelpInline" class="text-muted"> (Đơn vị
									triệu VND.) </small> <input type="number" class="form-control"
									name="price" placeholder="Giá sẩn phẩm"
									value="${product.price }" min="0" max="1000" required>
								<div class="valid-feedback"></div>
							</div>

							<div class="col-md-4 mb-3">
								<label for="type">Loại sản phẩm</label> <input type="text"
									value="${product.type }" class="form-control" name="type"
									placeholder="Loại sản phẩm" required>
								<div class="valid-feedback"></div>
							</div>

							<div class="col-md-4 mb-3">
								<label for="brand">Nhãn hiệu sản phẩm</label> <input type="text"
									class="form-control" name="brand" value="${product.brand }"
									placeholder="Nhãn hiệu sản phẩm" required>
								<div class="valid-feedback"></div>
							</div>
						</div>
						<input type="hidden" name="id" value="${product.id }">
					</form>
				</c:otherwise>
			</c:choose>

		</div>
		<div class="modal-footer">
			<c:choose>
				<c:when test="${isChange }">
					<button class="btn btn-primary p-2" id="addPr" type="submit">Cập
						nhập</button>
				</c:when>
				<c:otherwise>
					<button class="btn btn-primary p-2" id="addPr" type="submit">Thêm
						mới</button>
				</c:otherwise>
			</c:choose>

			<button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
		</div>
	</div>
</div>


