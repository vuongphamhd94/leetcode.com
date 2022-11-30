let qlsp = {
	add: function() {
		let form = $('form');
		let url = form.data('url');
		let img = $('#img').val().trim();
		let name = $('#name').val().trim();
		let detail = $('#detail').val().trim();
		let price = $('#price').val().trim();
		let type = $('#type').val().trim();
		let brand = $('#brand').val().trim();
		let data = {
			img: img,
			name: name,
			detail: detail,
			price: price,
			type: type,
			brand: brand
		}
		//kiem tra gia tri
		if (!(name && img && detail && price && type && brand)) {
			return;
		}
		// goi ajax
		$.ajax({
			type: 'POST',
			url: url,
			data: data,
			success: function(rs) {
				if (rs) {
					$('#img').val('');
					$('#name').val('');
					$('#detail').val('');
					$('#price').val('');
					$('#type').val('');
					$('#brand').val('');
					window.location = 'qlsp';
				}

			}
		})
	}
}

let init = {
	clickSubmit: function() {
		let btn = $('#btn-submit');
		btn.click(qlsp.add);
	},
	enterSubmit: function() {
		let form = $('form');
		form.keypress(function(event) {
			var keycode = (event.keyCode ? event.keyCode : event.which);
			if (keycode == '13') {
				qlsp.add();
			}
		});
	}
}

init.clickSubmit();
init.enterSubmit();