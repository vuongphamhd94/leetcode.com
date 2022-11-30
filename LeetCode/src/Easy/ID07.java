package Easy;

public class ID07 {
	public static int reverse(int x) {
		String strX = x + "";
		String rs = "";
		for (int i = strX.length() - 1; i >= 0; i--) {
			if (strX.charAt(i) == '-')
				rs = strX.charAt(i) + rs;
			else
				rs += strX.charAt(i);
		}

		try {
			return Integer.valueOf(rs);
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(reverse(3098));
	}
}
