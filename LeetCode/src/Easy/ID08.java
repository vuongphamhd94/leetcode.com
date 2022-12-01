package Easy;

public class ID08 {
	public static int myAtoi(String s) {
		s = s.trim();
		String strNum = "";
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '-' || c == '+') {
				if(strNum.length() == 0)
					strNum = c + strNum;
				else
					break;
			}else {
				if(c - '0' >= 0 && c - '0' <= 9) 
					strNum += c;
				else
					break;
			}
		}

		try {
			return Integer.valueOf(strNum);
		} catch (Exception e) {
			if(strNum.length() == 0 || 
					(strNum.length() == 1 && ('-' == s.charAt(0) || '+' == s.charAt(0))))
				return 0;
			
			return (int) ('-' == strNum.charAt(0) ? - 2147483648 : - 2147483647);
			
		}

	}

	public static void main(String[] args) {
		System.out.println(myAtoi("+-12"));
	}
}
