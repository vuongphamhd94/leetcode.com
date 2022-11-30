package Models;

public class Message {
	private String type;
	private String title;
	private String message;

	public Message(String type, String message) {
		if (type.equals("errol")) {
			this.type = "danger";
			this.title = "Có lỗi";
		} else {
			this.type = "success";
			this.title = "Thành công";
		}
		
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [type=" + type + ", title=" + title + ", message=" + message + "]";
	}

	public static void main(String[] args) {
		Message ms = new Message("errol", "Đăng ký thành công");
		System.out.println(ms.title);
		System.out.println(ms.type);
		System.out.println(ms.message);
	}

}
