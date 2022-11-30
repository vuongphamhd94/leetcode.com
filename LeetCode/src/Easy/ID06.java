package Easy;

public class ID06 {
	public static String convert(String s, int numRows) {
		if (numRows == 1)
			return s;

		int sL = s.length();
		String rs = "";
		// cac dong
		for (int i = 0; i < numRows; i++) {
			// gia tri dau tien cua dong
			int j = i;

			while (j < sL) {
				Character c = s.charAt(j);
				rs += c;

				// truong hop la dong dau tien hoac dong cuoi
				if (i == 0 || i == numRows - 1)
					j += 2 * numRows - 2;
				else {
					// truong hop la ca dong o giua
					if ((j / (numRows-1)) % 2 == 0)
						j += (numRows - i - 1) * 2;
					else
						j += i * 2;
				}

			}
		}

		return rs;
	}

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}
}
