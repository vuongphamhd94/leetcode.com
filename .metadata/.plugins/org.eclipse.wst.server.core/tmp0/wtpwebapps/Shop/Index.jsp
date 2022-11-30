<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:import url="shear/_head.jsp">
	<c:param name="title" value="Trang trang chủ"></c:param>
</c:import>
<%--Begin content --%>
<section class="product-details spad" style="min-height: 85vh;">
	<div class="px-5">
		<div class="row">
			<div class="col-sm-12 mt-5 d-flex flex-row-reverse">
				<form class="col-sm-6 row" action="home" method="post">
					<input class="form-control col-sm-8" type="search"
						placeholder="Tên sản phẩm" aria-label="Search" name="keySeach"
						value="${keySeach }">
					<button class="btn btn-primary ml-2 text-nowrap col-sm-3"
						type="submit">
						<i class="fa-solid fa-magnifying-glass"></i>Tìm kiếm
					</button>
				</form>
			</div>
			<c:if test="${products.size() == 0}">
				<p class="text-danger text-center mt-5 col-sm-12">
					<c:out value="Không tìm thấy sản phẩm phù hợp"></c:out>
				</p>
			</c:if>

			<c:forEach items="${products}" var="pd">
				<div class="col-sm-3 p-4 text-center p-4 submitDetailPrd"
					data-type="get" data-url="detail" data-id="${pd.id}">
					<div class="border rounded shadow-lg" style="height: 100%">
						<a href="#" class="product nav-link d-flex flex-column justify-content-between" style="height: 100%">
							<div>
								<img src="${pd.sourceImg}" alt="${pd.name}" class="p-2"  style="max-height: 100%"/>
							</div>
							<div class="font-weight-bold">
								<h6 class="font-weight-bold">${pd.brand}</h6>
								<h6 class="font-weight-bold">${pd.name}</h6>
								<div class="font-italic text-info">${pd.strPrice}</div>
							</div>
						</a>
					</div>
				</div>

				<%--render darabase end--%>
			</c:forEach>
		</div>
	</div>

	<%--Phan trang --%>
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">

			<c:forEach begin="1" end="${maxPage}" var="i">

				<c:choose>
					<c:when test="${page == i}">
						<li class="page-item active"><a class="page-link" href="#">${i}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="home?page=${i}&keySeach=${keySeach}">${i}</a></li>

					</c:otherwise>
				</c:choose>
			</c:forEach>
		</ul>
	</nav>
</section>

<div class="modal fade" id="detailProduct" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true"></div>
<div class="modal fade" id="order" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true"></div>

<%--End content --%>
<c:import url="shear/_footer.jsp" />

<%--Thông báo ms --%>
<div class="position-fixed bottom-0 right-0 p-3"
	style="z-index: 1051; right: 0; bottom: 0; width: 350px" id="toast">
	<c:if test="${ms != null}">
		<div class="toast" role="alert" aria-live="assertive"
			aria-atomic="true" data-delay="2000">
			<c:import url="_message.jsp">
				<c:param name="ms" value="${ms}" />
			</c:import>
		</div>
	</c:if>
</div>