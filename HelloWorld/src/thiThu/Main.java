package thiThu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int v = sc.nextInt();
			long sum = v;
			long m;
			boolean c = true;
			int[] a = new int[n];
			int[] b = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			for (int i = 0; i < n - 1; i++) {
				b[i] = a[i] < a[i + 1] ? 1 : 0;
			}
			int i = 0;
			while(i< n - 1) {
				int vtm = 0;
				int vtb = 0;
				boolean d = false;
				if (c)
					for (int k = i; k < n - 1; k++) {
						if (b[k] == 1) {
							vtm = k;
							c = false;
							d = true;
							break;
						}
					}
				if (!c)
					for (int k = vtm + 1; k < n - 1; k++) {
						if (b[k] == 0) {
							vtb = k;
							c = true;
							break;
						}
					}
				if (!c && b[n - 2] == 1) {
					vtb = n - 1;
					c = true;
				}
				if(!c || !d)
					break;
				else {
					m = sum / a[vtm];
					sum = sum % a[vtm];
					sum += m * a[vtb];
				}
				
				i = vtb + 1;
			}

			System.out.println("#" + tc + " " + (sum - v));
		}

	}
	

}
