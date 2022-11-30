package Models;

import java.sql.Date;
import java.util.List;

import Dao.LoginDao;
import Dao.OrderDao;

public class Orders extends Base {
	private String userEmail;
	private int id;
	private int status;
	private Date date;
	private String discountCode;
	private String address;
	private float total = 0;
	private Account acc;
	private List<OrdersDetail> listOrder;

	public Orders(String userEmail, int id, int status, Date date, String discountCode, String address) {
		super();
		this.userEmail = userEmail;
		this.id = id;
		this.status = status;
		this.discountCode = discountCode;
		this.address = address;
		this.date = date;
//		long millis = System.currentTimeMillis();
//		this.date = new Date(millis);
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTotal() {
		return fomatMoney(this.total);
	}
	public Account getAcc() {
		LoginDao lg = new LoginDao();
		return lg.GetByUserName(userEmail);
	}
	
	public List<OrdersDetail> getListOrder(){
		OrderDao od = new OrderDao();
		return od.GetAllOrderDetails(id);
	}

	@Override
	public String toString() {
		return "Orders [userEmail=" + userEmail + ", id=" + id + ", status=" + status + ", date=" + date
				+ ", discountCode=" + discountCode + ", address=" + address + ", total=" + total + "]";
	}

	

}
