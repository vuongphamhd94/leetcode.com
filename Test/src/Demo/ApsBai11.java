package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai11 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] a = new int[10];
			int sum = 0;
			for(int i = 0; i < n; i++) {
				int index = sc.nextInt();
				sum += index;
				a[index]++;
			}
			
			int sum2 = m - sum;
			int count = 0;
			for(int i = 1; i <= sum2 / 2; i++)
				for(int j = sum2 / 2 +1; j <= 9; j++) 
					if(a[i] == 0 && a[j] == 0 && i + j == sum2)
						count++;
			System.out.println("#" + tc + " " + count *2);
		}
	}

}
