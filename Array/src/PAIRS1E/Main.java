package PAIRS1E;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input5.txt"));
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int i = 1; i<=tc; i++) {
			int n = sc.nextInt();
			long k = sc.nextLong();
			long[] arr = new long[n];
			
			// nhap mang
			for(int index = 0; index< n; index++) {
				arr[index] = sc.nextInt();
			}
			//dem so cap
			
			int count = 0;
			
			for(int a = 0; a< n; a++) 
				for(int b = a + 1; b < n; b++) {
					long khoangCach = arr[a] - arr[b];
					if(Math.abs(khoangCach)==k)
						count++;
				}
			
			System.out.println(count);
			
		}
	}
}
