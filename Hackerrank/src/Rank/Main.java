package Rank;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
	public static void main(String[] argh) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[]a = new int [n];
			for(int i = 0; i < n; i++ )
				a[i] = sc.nextInt();
			int max = a[0];
			for(int i = 1; i < n; i++)
				if(max < a[i])
					max = a[i];
			int[] b  = new int[max + 1];
			int i;
			for(i = 0; i < n; i++) 
				if(b[a[i]] == 1)
					break;
				else
					b[a[i]] = 1;
			int rs = i == n ? -1 : a[i];
			System.out.println("#" + tc + " " + rs);
		}
	}
}