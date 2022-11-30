let init = {
	clickSubmit: function() {
		let bt = $('#submit');
		bt.click(cart.submit);

	}
}
let cart = {
	submit: function() {
		let amout = $('#amount').val();
		let id = $('#amount').data('id');
		let url = $('#amount').data('url');
		let data = {
			id: id,
			amount: amout,
		}

		$.ajax({
			type: 'POST',
			url: url,
			data: data,
			success: function(rs) {
				if (rs == 0)
					window.location = "login";

				else {
					toasts.show(rs);
					setTimeout(function() {
						window.location = "home";
					}, 2000);
				}
			}
		})
	},
}

init.clickSubmit();

