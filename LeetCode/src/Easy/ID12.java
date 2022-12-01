package Easy;

import java.util.HashMap;

public class ID12 {
	public static String intToRoman(int num) {
		HashMap<Integer, String> numRoman = new HashMap<>();
		numRoman.put(1, "I");
		numRoman.put(5, "V");
		numRoman.put(10, "X");
		numRoman.put(50, "L");
		numRoman.put(100, "C");
		numRoman.put(500, "D");
		numRoman.put(1000, "M");
		String rs = "";
		int n = num;
		int k1 = 1;
		int k2 = 5;
		int k3 = 10;
		while (n > 0) {
			int dv = n % 10;
			n /= 10;
			
			if(dv == 4) 
				rs = numRoman.get(k1) + numRoman.get(k2) + rs;
			
			if(dv == 5 )
				rs = numRoman.get(k2) + rs;
			
			if(dv == 9)
				rs = numRoman.get(k1) + numRoman.get(k3) + rs;
				
			if(dv >0 && dv < 4) {
				for(int i = 0; i < dv; i++)
					rs = numRoman.get(k1) + rs;
			}else 
				if(dv > 5 && dv < 9) {
					for(int i = 5; i < dv; i++)
						rs = numRoman.get(k1) + rs;
					
					rs = numRoman.get(k2) + rs;
				}
			
			k1 *= 10;
			k2 *= 10;
			k3 *= 10;
		}

		return rs;
	}
	
	public static void main(String[] args) {
		System.out.println(intToRoman(1994));
	}
}
