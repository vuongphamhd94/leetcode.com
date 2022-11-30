package Easy;

public class AddBinary {
	public String addBinary(String a, String b) {
		String rs = "";
		int soDu = 0;
		int lA = a.length();
		int lB = b.length();
		if(lA > lB)
			for(int i = 0; i < lA - lB; i++)
				b= 0 + b;
		else
			for(int i = 0; i < lB - lA; i++)
				a = 0 + a;
		
		for(int i = a.length() -1; i >= 0; i--) {
			int nA = a.charAt(i) - '0';
			int nB = b.charAt(i) - '0';
			rs = (nA + nB + soDu)%2 + rs;
			soDu = (nA + nB + soDu)/2;
		}
		if(soDu != 0)
			rs = soDu + rs;
		return rs;
	}
	
	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		
		System.out.println(ab.addBinary("1", "111"));
	}
}