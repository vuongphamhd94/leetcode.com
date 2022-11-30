package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickSort {

	static void PrintArray(int[] a, int n, int k) {
		int rs = 1;
		for(int i = 0; i < n -1; i++)
			if(a[i + 1] - a[i] > k)
				rs++;
		System.out.println(rs);
	}
	
	static int Partition(int[] a, int l, int r) {
		int p = a[r];
		int i = l - 1;
		for(int j = l; j < r; j++) {
			if(a[j] < p) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		int temp = a[i + 1];
		a[i + 1] = a[r];
		a[r] = temp;
		return i + 1;
	}
	
	static void QuickSort(int[] a, int l, int r) {
		if(l < r) {
			int p = Partition(a, l, r);
			
			QuickSort(a, l, p - 1);
			QuickSort(a, p+1, r);
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		
		QuickSort(a, 0, n - 1);
		PrintArray(a, n, k);
	}
}
