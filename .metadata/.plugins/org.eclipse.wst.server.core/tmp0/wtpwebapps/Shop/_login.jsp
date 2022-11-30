<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="modal fade" id="login" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-xl">
		<div class="modal-content">
			<div class="modal-header bg-primary text-white">
				<h5 class="modal-title" id="exampleModalLabel">Đăng nhập</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body px-3">
				<form data-url="login" data-type="Post" id="loginForm">
					<div class="form-group">
						<label for="email"><i
							class="fa-solid fa-user"></i>Tên đăng nhập</label> <input type="email"
							class="form-control" id="email" name="email"
							placeholder="Email đăng nhập" />
					</div>
					<div class="form-group">
						<label for="pass"><i
							class="fa-solid fa-lock"></i>Mật khẩu</label> <input type="password"
							name="pass" class="form-control" placeholder="Mật khẩu" />
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary register"
					data-toggle="modal" data-target="#register">
					Đăng ký</button>
				<button type="button" class="btn btn-success quickSubmit" data-tage="login">
					Đăng nhập</button>
			</div>
		</div>
	</div>
</div>