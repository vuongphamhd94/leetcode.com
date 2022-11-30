<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="modal fade" id="register" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-xl">
		<div class="modal-content">
			<div class="modal-header bg-primary text-white">
				<h5 class="modal-title" id="exampleModalLabel">Đăng ký tài
					khoản</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body px-3">
				<form data-url="register" data-type="post" id="registerForm">
					<div class="form-group">
						<label for="fullName"><i
							class="fa-solid fa-user"></i>Họ và tên</label> <input type="text"
							class="form-control" id="fullName" name="fullName"
							placeholder="Họ và tên..." autofocus="autofocus" />
					</div>
					<div class="form-group">
						<label for="email"><i
							class="fa-solid fa-envelope"></i>Email đăng nhập</label> <input
							type="email" class="form-control" id="email" name="email"
							placeholder="Email đăng nhập..." />
					</div>
					<div class="form-group">
						<label for="pass"><i
							class="fa-solid fa-lock"></i>Mật khẩu</label> <input type="password"
							class="form-control" id="pass" name="pass" placeholder="Mật khẩu" />
					</div>
					<div class="form-group">
						<label for="pass2"><i
							class="fa-solid fa-lock"></i>Xác nhận lại mật khẩu</label> <input
							type="password" class="form-control" id="config-pass" name="config-pass"
							placeholder="Xác nhậm" />
					</div>
					<div class="form-group">
						<label for="address"><i
							class="fa-solid fa-house"></i>Địa chỉ</label> <input type="text"
							class="form-control" id="address" name="address"
							placeholder="Địa chỉ..." />
					</div>
					<div class="form-group">
						<label for="phone"><i
							class="fa-solid fa-phone"></i>Số điện thoại</label> <input type="number"
							class="form-control" id="phone" name="phone"
							placeholder="Số điện thoại..." />
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary login"
					data-toggle="modal" data-target="#login" title="đăng nhập">
					Đăng nhập</button>
				<button type="button" class="btn btn-success quickSubmit"
					title="Đăng ký" data-tage="register">Đăng ký</button>
			</div>
		</div>
	</div>
</div>
