package Models;

public class Account {
	private String userEmail;
	private String password;
	private int role;
	private String fullName;
	private String address;
	private String phone;

	public Account(String user_mail, String password, int role, String fullName, String address, String phone) {
		super();
		this.userEmail = user_mail;
		this.password = password;
		this.role = role;
		this.fullName = fullName;
		this.address = address;
		this.phone = phone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String user_mail) {
		this.userEmail = user_mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Account [user_mail=" + userEmail + ", password=" + password + ", role=" + role + ", fullName="
				+ fullName + ", address=" + address + ", phone=" + phone + "]";
	}
	
}
