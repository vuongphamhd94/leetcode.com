package Models;

public class OrdersDetail {
	private int orderId;
	private int productId;
	private int amount;
	private float price;

	public OrdersDetail(int orderId, int productId, int amount, float price) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.amount = amount;
		this.price = price;
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

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ordersDetail [orderId=" + orderId + ", productId=" + productId + ", amount=" + amount + ", price="
				+ price + "]";
	}

}
