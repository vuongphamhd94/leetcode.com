<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập - Shopping</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link href="app/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="app/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body class="bg-gradient-primary">

	<div class="container">

		<!-- Outer Row -->
		<div class="row justify-content-center">

			<div class="col-xl-10 col-lg-12 col-md-9">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="row">
							<div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
							<div class="col-lg-6">
								<div class="p-5">
									<div class="text-center">
										<h1 class="h4 text-gray-900 mb-4">Đăng nhập</h1>
									</div>
									<form action="LoginController" method="post">
										<div class="form-group">
											<input type="email" class="form-control form-control-user"
												name="user" placeholder="Tài khoản">
										</div>
										<div class="form-group">
											<input type="password" class="form-control form-control-user"
												name="pass" placeholder="Mật khẩu">
										</div>
										<div class="form-group">
											<div class="custom-control custom-checkbox small">
												<input type="checkbox" name="remember" class="custom-control-input"
													id="customCheck"> <label
													class="custom-control-label" for="customCheck">Nhớ
													tài khoản đăng nhập</label>
											</div>
										</div>
										<button type="submit" class="btn btn-primary btn-user btn-block">Đăng nhập</button>

									</form>
									<hr>
									<div class="row">
										<div class="text-center col-lg-6">
											<a class="small" href="forgot-password.html">Quên mật
												khẩu?</a>
										</div>
										<div class="text-center col-lg-6">
											<a class="small" href="register.html">Đăng ký tài khoản</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</div>

	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="app/vendor/jquery/jquery.min.js"></script>
	<script src="app/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="app/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="app/js/sb-admin-2.min.js"></script>

</body>
</html>