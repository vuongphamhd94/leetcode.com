package SendEmail;

import java.util.Properties;

public class Main {
	static void sendText(String to, String sub, String msg, final String user, final String pass) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gamil.com");
		props.put("mail.smtp.port","587");
		props.put("mail.smtp.auth", "true");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
