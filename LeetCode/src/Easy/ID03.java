package Easy;

public class ID03 {
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1)
			return s.length();

		int max = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			int j = 0;
			for (j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					break;
			}
			for(int k = i +1; k< j && k < s.length(); k++)
				for(int l = k + 1; l <= j && l < s.length(); l++)
					if(s.charAt(k) == s.charAt(l))
						j=l;
			
			max = max > j - i ? max : j - i;
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
}
