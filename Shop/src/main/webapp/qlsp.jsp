<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="shear/_head.jsp">
	<c:param name="title" value="Quản lý đơn đặt hàng" />
	<c:param name="sumPr" value="${sumPr}" />
</c:import>
<!-- begin body -->
<section class="m-5">
	<div>Quản lý danh sách sản phẩm</div>
	<div class="d-flex justify-content-end">
		<a class="btn btn-primary p-2" data-toggle="modal"
      data-target="#addProduct" href="#" id="btnadd">Thêm mới</a>

	</div>
	<table class="table table-bordered table-striped mt-3">
		<thead>
			<tr class="table-active text-center">
				<th class="text-nowrap">STT</th>
				<th class="text-nowrap" style="width: 10%;">Ảnh sản phẩm</th>
				<th class="text-nowrap">Tên sản phẩm</th>
				<th class="text-nowrap">Giá sản phẩm</th>
				<th class="text-nowrap">Thông tin sản phẩm</th>
				<th class="text-nowrap">Loại hình</th>
				<th class="text-nowrap">Nhãn hiệu</th>
				<th class="text-nowrap" style="width: 8rem">Thao tác</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${products}" var="item">
				<tr>
					<td class="stt text-center"></td>
					<td style="min-height: 155px; display: block;"><img
						src="${item.sourceImg}" alt="${item.name}"></td>
					<td>${item.name}</td>
					<td>${item.strPrice }</td>
					<td>${item.details }</td>
					<td>${item.type}</td>
					<td>${item.brand}</td>
					<td>
					<button type="button" data-url="qlsp" data-type="get" data-id="${item.id }" data-action="edit" class="btn btn-primary p-1 editPr"><i class="fa-solid fa-pen-to-square wh16"></i></button>
					<!-- 
					<button type="button" data-url="qlsp" data-type="get" data-id="${item.id }" data-action="delete" class="btn btn-danger p-1 editPr"><i class="fa-solid fa-trash wh16"></i></button>
					 -->
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</section>
<!-- end body -->
<!-- modal -->
<div class="modal fade" id="order" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true"></div>
<div class="modal fade" id="addProduct" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<c:import url="_addProduct.jsp" />
</div>

<c:import url="shear/_footer.jsp" />
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