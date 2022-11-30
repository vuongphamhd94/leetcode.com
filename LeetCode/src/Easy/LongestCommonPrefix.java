package Easy;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		String rs = "";
		if (strs.length == 0)
			return rs;
		else if (strs.length == 1)
			return strs[0];

		int lmin = strs[0].length();
		for (String s : strs)
			if (s.length() < lmin)
				lmin = s.length();

		for (int i = 0; i < lmin; i++) {
			for (String s : strs)
				if (strs[0].charAt(i) != s.charAt(i))
					return rs;

			rs += strs[0].charAt(i);
		}

		return rs;
	}

	public static void main(String[] args) {
		LongestCommonPrefix l = new LongestCommonPrefix();
		String[] s = new String[] { "dog","racecar","car" };
		System.out.println("ket qua:  " + l.longestCommonPrefix(s));
	}
}
