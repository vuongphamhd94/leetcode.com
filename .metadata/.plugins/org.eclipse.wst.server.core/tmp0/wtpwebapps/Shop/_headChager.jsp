<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<a class="navbar-brand mr-5" href="home"><img class="shop-logo"
			src="app/img/logo.png" alt="Logo"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="nav nav-pills mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link active" href="home">
						<i class="fa-solid fa-house"></i>Trang chủ
				</a></li>
				<c:if test="${sessionScope.acc != null}">
					<c:if test="${sessionScope.acc.role == 1 }">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"><i
								class="fa-regular fa-list-check"></i> Quản lý </a>
							<div class="dropdown-menu"
								aria-labelledby="navbarDropdownMenuLink">
								<a class="dropdown-item" href="qlsp">Quản lý sản phẩm</a> <a
									class="dropdown-item" href="qldh">Quản lý đơn hàng</a>
							</div></li>
					</c:if>
					
					<li class="nav-item "><a class="nav-link" href="orders"><i
							class="fa-regular fa-cart-shopping"></i>Đơn hàng</a></li>

					<li class="nav-item "><a class="nav-link smCart" href="#" data-type="get" data-url="cart"><i
							class="fa-regular fa-cart-shopping"></i>Giỏ hàng <span
							class="badge badge-danger badge-counter" id="countProduct">${sumPr}</span> </a></li>
				</c:if>

			</ul>
			<c:choose>
				<c:when test="${sessionScope.acc == null}">
					<a class="nav-link text-primary" href="#" data-toggle="modal"
						data-target="#login" id="login-register">Đăng nhập/Đăng ký</a>
					<!-- form đăng nhập -->
					<c:import url="/_login.jsp">
						<c:param name="acc" value="${acc }" />
					</c:import>
					<!-- Form đăng ký -->
					<c:import url="/_register.jsp" />
				</c:when>
				<c:otherwise>
					<div class=" dropdown navbar-nav">
						<a class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenuLink" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"> <span
							class="mr-2 d-none d-lg-inline small text-primary">${sessionScope.acc.fullName}</span>
							<img src="app/img/undraw_profile_1.svg"
							class="img-profile rounded-circle">
						</a>
						<div class="dropdown-menu  dropdown-menu-right"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="#"><i class="fa-solid fa-user"></i>Thông
								tin</a> <a class="dropdown-item" href="login?action=logout"><i
								class="fa-solid fa-right-from-bracket"></i>Đăng xuất </a>
						</div>
					</div>
				</c:otherwise>
			</c:choose>


		</div>
		<div class="dropdown-divider"></div>