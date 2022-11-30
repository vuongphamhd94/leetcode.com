package FNDSTR;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		for(int n = 1; n <= 10; n++) {
			int tc = sc.nextInt();
			String s1 = sc.next();
			String s2 = sc.next();
			int count = 0;
			while(s2.contains(s1)) {
				count++;
				s2 = s2.substring(s2.indexOf(s1) + 1);
			}
			System.out.println("#" + tc + " " + count);
		}
	}
}
