package Models;

import java.text.NumberFormat;
import java.util.Locale;

public class Base {
	/*
	 * hàm fomatMoney nhận sao một số đinh float là giá sản phẩm đơn vi triệu đông
	 * hàm trả về đơn vị đồng
	 */
	public String fomatMoney(float n) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		return currencyVN.format(n * 1000000);
	}
}
