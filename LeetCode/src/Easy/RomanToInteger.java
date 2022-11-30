package Easy;

import java.util.HashMap;

public class RomanToInteger {
	public int romanToInt(String s) {
		if(s.length() == 0)
			return 0;
		int n = 0;
		HashMap<Character, Integer> roman = new HashMap<Character, Integer>();
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);
		
		int i = s.length() -1;
		while (i>=0) {
			int j = i - 1;
			
			n += roman.get(s.charAt(i));
			while(j >=0&& roman.get(s.charAt(i)) > roman.get(s.charAt(j))) {
				n -= roman.get(s.charAt(j));
				j--;
			}
			
			i= j;
		}
		
		
		return n;
	}
	
	public static void main(String[] args) {
		
	RomanToInteger r = new RomanToInteger();
	System.out.println(r.romanToInt("MCMXCIV"));
	}
}
