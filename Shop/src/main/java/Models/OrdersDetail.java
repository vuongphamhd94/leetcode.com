package Models;

import Dao.ProductDao;

public class OrdersDetail extends Base {
	private int orderId;
	private int productId;
	private int amount;
	private float price;
	private float total = 0;
	private String productName;

	public String getProductName() {
		ProductDao pr = new ProductDao();
		return pr.GetById(productId).getName();
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public OrdersDetail(int orderId, int productId, int amount, float price) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.amount = amount;
		this.price = price;
		this.total = this.price * this.amount;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public float getPrice() {
		return price;
	}
	public String PriceToString() {
		return fomatMoney(this.price);
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getTotal() {
		return fomatMoney(this.total);
	}

	@Override
	public String toString() {
		return "ordersDetail [orderId=" + orderId + ", productId=" + productId + ", amount=" + amount + ", price="
				+ price + "]";
	}

}
