let toasts = {
	removerToast: function() {
		$('.toast.hide').remove();
	},
	show: function(data) {
		let atb = {
			class: "toast",
			role: "alert",
			"aria-live": "assertive",
			"aria-atomic": "true",
			"data-delay": 2000,
		};
		if (!data) {
			return;
		}

		let ms = $('<div></div>', atb);
		ms.html(data).appendTo('div#toast');
		ms.toast('show');
		setTimeout(toasts.removerToast, 2500);
	},
};
let validateForm = function(form) {
	form.validate({
		rules: {
			fullName: 'required',
			pass: 'required',
			'config-pass': {
				required: true,
				equalTo: '#pass'
			},
			email: {
				required: true,
				email: true,
			},
			phone: {
				required: true,
				number: true,
			},
			img: {
				required: true,
				url: true,
			},
			address: 'required',
			amout: {
				required: true,
				number: true,
				range: [1, 100],
			},
			price: {
				required: true,
				number: true,
				range: [1, 100],
			},
			name: 'required',
			detail: 'required',
			type: 'required',
			brand: 'required',
		},
		messages: {
			fullName: 'Họ và tên không được để trống!',
			pass: 'Mật khẩu không được để trống!',
			'config-pass': {
				required: 'Xác nhận mật khẩu không được để trống!',
				equalTo: 'Mật khẩu xác nhận không đúng!'
			},
			email: {
				required: 'Email đăng nhập không được để trống!',
				email: 'Email không đúng định dạng!'
			},
			phone: {
				required: 'Số điện thoại không được để trống!',
				number: 'Không đúng định dạng số!'
			},
			img: {
				required: 'Link ảnh không được để trống!',
				url: 'Link ảnh không đúng định dạng!'
			},
			address: 'Địa chỉ không được để trống!',
			amout: {
				required: 'Số lượng không được để trống!',
				number: 'Số lượng không đúng định dạn số!',
				range: 'Số lượng trong khoảng 1 ~ 100 sản phẩm!'
			},
			price: {
				required: 'Gía sản phẩm không được để trống!',
				number: 'Giá sản phẩm không đúng định dạn số!',
				range: 'Giá sản phẩm trong khoảng 1 ~ 100 triệu VND!'
			},
			name: 'Tên sản phẩm không được để trống!',
			detail: 'Chi tiết sản phẩm không được để trống!',
			type: 'Kiểu sản phẩn không được để trống!',
			brand: 'Hãng sản phẩm không được để trống!',
		}
	});

	return form.valid();
};
let quickSubmit = {
	account: function(tage) {
		let form
		if (tage == 'login') {
			form = $('#loginForm');
		} else if (tage == 'register') {
			form = $('#registerForm');
		} else {
			form = $(form)[0];
		}

		if (!form)
			return;

		let formData = new FormData(form[0]);
		if (!validateForm($(form)))
			return;

		let url = $(form).data('url');
		let type = $(form).data('type');
		let data = {
			email: formData.get('email'),
			pass: formData.get('pass'),
			address: formData.get('address'),
			fullName: formData.get('fullName'),
			phone: formData.get('phone'),

		}
		// trường hợp là login
		if (url == 'login') {
			$.ajax({
				type: type,
				url: url,
				data: data,
				success: function(rs) {
					if (rs.indexOf('bg-danger') >= 0) {
						toasts.show(rs);
					} else {

						$("#login").modal("hide");
						setTimeout(() => {
							$('#head').html(rs);
						}, 500);

						$(document).ready(() => {
							cart.get();
						})

					}
				}
			})
			return;
		}

		// trường hợp là register
		if (url == 'register') {
			$.ajax({
				type: type,
				url: url,
				data: data,
				success: function(rs) {
					if (rs.indexOf('bg-danger') >= 0) {
						$("#register #email").addClass('error');
					} else {
						$('#fullName').val('');
						$('#register #email').val('');
						$('#pass').val('');
						$('#config-pass').val('');
						$('#address').val('');
						$('#phone').val('');
						$('#fullName').trigger('focus');
						$('#loginForm').validate().destroy();
						$("#register").modal("hide");
						$("#login").modal("show");
					}
					toasts.show(rs);
				}
			})
		}

	},
}
let submitForm = {
	quickSubmitForm: function() {
		$(".quickSubmit").click((e) => {
			let $this = e.target;
			let tage = $($this).data('tage');
			if (tage)
				quickSubmit.account(tage);

			let form = $('#detailProduct form')[0];
			let formData = new FormData(form);
			if (!validateForm($(form)))
				return;

			let url = $(form).data('url');
			let type = $(form).data('type');
			let data = {
				id: formData.get('id'),
				amount: formData.get('amount'),
			}

			$.ajax({
				type: type,
				url: url,
				data: data,
				success: function(rs) {
					if (!rs) {
						$('#login').modal('show');
						return;
					}
					let countProduc = $('#countProduct');
					countProduc.html(Number(countProduc.html()) + Number(data.amount));
					$('#detailProduct').modal('hide');
					toasts.show(rs);
				}
			})

		});
	},
	quickDetailPrd: function() {
		$(".submitDetailPrd").click((e) => {
			let $this = e.target;
			let product = $($this).closest('.submitDetailPrd')[0];
			let url = $(product).data('url');
			let type = $(product).data('type');
			let data = {
				id: $(product).data('id'),
			}
			$.ajax({
				type: type,
				url: url,
				data: data,
				success: function(rs) {
					if (!rs)
						window.location = 'home';

					$('#detailProduct').html(rs);
					$('#detailProduct').modal('show');
					submitForm.quickSubmitForm();
				}
			})
		})
	},
	quickSubmitOrder: () => {
		$(document).off('click', '.check-out-order').on('click', '.check-out-order', cart.order)
	}
}
let login = {
	show: function() {
		$('#login-register').click(() => {
			$('#loginForm').validate().destroy();

			$('#loginForm').keypress(function(event) {
				var keycode = (event.keyCode ? event.keyCode : event.which);
				if (keycode == '13') {
					quickSubmit.account('login');
				}
			});
		});
		// hiển thị form đăng ký tai khoản
		$(".register").click(() => {
			$('#registerForm').validate().destroy();
			$("#login").modal("hide");

			$('#registerForm').keypress(function(event) {
				var keycode = (event.keyCode ? event.keyCode : event.which);
				if (keycode == '13') {
					quickSubmit.account('register');
				}
			});

		});
		// hiển thị form đăng nhập
		$(".login").click(() => {
			$('#loginForm').validate().destroy();
			$("#register").modal("hide");

		});

		$("#register").on("shown.bs.modal", function() {
			$("#fullName").trigger("focus");
		});

		$("#login").on("shown.bs.modal", function() {
			$("#email").trigger("focus");
		});
	},
}

let cart = {
	get: function() {
		$(document).off('click', '.smCart').on('click', '.smCart', () => {
			submitCart.submitCart();
			$(document).off('click', '.check-out').on('click', '.check-out', submitCart.getCheckOut);
			submitCart.delete();
		});
	},
	order: function() {
		let form = $('#form-order');
		if (!validateForm(form))
			return;

		let formData = new FormData(form[0]);
		let url = form.data('url');
		let type = form.data('type');
		let data = {
			orderId: formData.get('orderId'),
			fullName: formData.get('fullName'),
			address: formData.get('address'),
			discountCode: formData.get('discountCode')
		}

		$.ajax({
			type: type,
			url: url,
			data: data,
			success: (rs) => {
				$('#total').val(0);
				$('#countProduct').html(0);
				$('#order').modal('hide');
				toasts.show(rs);
			}
		})
	}
}

let submitCart = {
	submitCart: () => {
		let cart = $('.smCart');
		let type = cart.data('type');
		let url = cart.data('url');
		if (!(type || url))
			return;
		$.ajax({
			type: type,
			url: url,
			success: function(rs) {
				$('#order').html(rs);
				$('#order').modal('show');
				let stts = $('#order').find('.stt');
				for (let i = 0; i < stts.length; i++) {
					$(stts[i]).html(i + 1);
				}
			}
		})
	},
	getCheckOut: () => {
		let checkOut = $('.check-out');
		let type = checkOut.data('type');
		let url = checkOut.data('url');
		if (!(type || url))
			return;

		$.ajax({
			type: type,
			url: url,
			data: {
				action: 'checkOut'
			},
			success: function(rs) {
				$('#order').modal('hide');
				setTimeout(() => {
					$('#order').html(rs);
					$('#order').modal('show');
				}, 500);

				submitForm.quickSubmitOrder();
			}
		})
	},
	submitCheckOut: () => {
		let form = $('#form-oder');
		if (!validateForm(form))
			return;

		let formData = new FormData(form);
	},
	//xoa
	delete: function() {
		$(document).off('click', '.delete').on('click', '.delete', function(elm) {
			let $this = elm.target;
			let btn = $($this).closest('.delete')[0];

			let url = $(btn).data('url');
			let type = $(btn).data('type');
			let tager = $(btn).data('tager');
			let amount = $(btn).data('amount');
			let id = $(btn).data('id');
			let data = {
				id: id,
				tager: tager
			}
			$.ajax({
				type: type,
				url: url,
				data: data,
				success: function(rs) {
					if (!rs)
						window.location = 'home';

					if (rs.indexOf('success') >= 0) {
						$.ajax({
							type: 'get',
							url: 'delete',
							data: { tager: tager },
							success: function(e) {
								if (!e)
									window.location = 'home';

								if (tager = 'order') {
									$('#cartTB').html(e);
									$('#countProduct').html(Number($('#countProduct').html()) - Number(amount));
									toasts.show(rs);
								}

							}

						})
					}
				}
			})
		})
	}
}

let qlsp = {
	quickSubmit: () => {
		$(document).off('click', '#addPr').on('click', '#addPr', () => {
			form = $('#formAddPr');
			let url = form.data('url');
			let type = form.data('type');
			let action = form.data('action');
			let formData = new FormData(form[0]);
			if (!validateForm($(form)))
				return;
			let data = {
				img: formData.get('img'),
				name: formData.get('name'),
				detail: formData.get('detail'),
				price: formData.get('price'),
				type: formData.get('type'),
				brand: formData.get('brand'),
				action: action,
				id: formData.get('id'),
			}

			$.ajax({
				url: url,
				type: type,
				data: data,
				success: (rs) => {
					$('input').val('');
					$('textarea').val('');
					window.location = 'qlsp';
				}
			})
		})
	},
	getById: () => {
		$(document).off('click', '.editPr').on('click', '.editPr', (elm) => {
			let btn = $(elm.target).closest('.editPr')[0];
			let url = $(btn).data('url');
			let type = $(btn).data('type');
			let action = $(btn).data('action');
			let id = $(btn).data('id');
			let data = {
				id: id,
				action: action
			}
			$.ajax({
				url: url,
				type: type,
				data: data,
				success: (rs) => {
					if (!rs)
						window.location = 'qlsp';

					$('#addProduct').html(rs);
					$('#addProduct').modal('show');
				}
			})
		})
	}
}

function stt() {
	let stt = $('.stt');
	for (let i = 1; i <= stt.length; i++) {
		$(stt[i - 1]).html(i);
	}
}
function resetFrom() {
} $(document).off('mousedown', '#btnadd').on('mousedown', '#btnadd', () => {
	$('input').val('');
	$('textarea').val('');
});


$(document).ready(function() {
	$('.toast').toast('show');
	setTimeout(toasts.removerToast, 2500);
	login.show();
	submitForm.quickSubmitForm();
	submitForm.quickDetailPrd();
	cart.get();
	stt();
	resetFrom();
	qlsp.quickSubmit();
	qlsp.getById();
})



