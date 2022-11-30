package QUE1E;

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
			int[] a = new int[n];// mang cac chieu cao
			int[] stt = new int[n];
			int[] out = new int[n];// mang sua sap xep theo dung yeu cau
			int item, max = 0, p = 0;
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			for (int i = 0; i < n; i++)
				stt[i] = sc.nextInt();
			for (int i = 0; i < n; i++)
				for (int j = i + 1; j < n; j++)
					if (a[i] > a[j]) {
						item = a[i];
						a[i] = a[j];
						a[j] = item;
						item = stt[i];
						stt[i] = stt[j];
						stt[j] = item;
					}
			for (int i = 0; i < n; i++) {
				item = 0;
				for(int j = 0; j < n; j++) {
					if(out[j] == 0)
						item++;
					if(item > stt[i]) {
						out[j] = a[i];
						break;
					}
				}
			}
			for (int i = 0; i < n; i++)
				System.out.print(out[i] + " ");
			System.out.println();
		}
	}
}
