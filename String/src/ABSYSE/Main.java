package ABSYSE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String aStr, bStr, cStr, keyStr = "machula";
			int a, b , c;
			a = b = c = 0;
			aStr = sc.next();
			sc.next();
			bStr = sc.next();
			sc.next();
			cStr = sc.next();
			if(aStr.contains(keyStr)) {
				b = Integer.valueOf(bStr);
				c = Integer.valueOf(cStr);
				a = c - b;
			}
			if(bStr.contains(keyStr)) {
				a = Integer.valueOf(aStr);
				c = Integer.valueOf(cStr);
				b = c - a;
			}
			if(cStr.contains(keyStr)) {
				b = Integer.valueOf(bStr);
				a = Integer.valueOf(aStr);
				c = a + b;
			}
			System.out.println(a + " + " + b + " = " + c);
		}
	}
}
