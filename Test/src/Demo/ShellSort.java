package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShellSort {

	static void ShellSort(int[] a, int n, int k) {
		if (k > n)
			return;
		int t = n / k;
		if(t == 1) 
			for(int i = 0; i < n -1; i++)
				if(a[i] > a[i + 1]) {
					int item = a[i];
					a[i] = a[i + 1];
					a[i + 1] = item;
				}
		
		for (int i = 0; i < t; i++)
			for (int j = i; j < n; j += t) {
				int min = j;
				int c = j + t;
				while(c < n) {
					if(a[min] > a[c])
						min = c;
					c += t;
				}
				if(min != j) {
					int item = a[min];
					a[min] = a[j];
					a[j] = item;
				}
			}
		ShellSort(a, n, k * 2);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		ShellSort(a, n, 2);
		for (int i : a)
			System.out.printf("%d ", i);
	}

}
