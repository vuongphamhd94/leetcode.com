package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MergeSort {
	static void merge(int[] arr, int l, int m, int r) {
		int L = m - l + 1;
		int R = r - m;
		int[] arrL = new int[L];
		int[] arrR = new int[R];
		for(int i = 0; i < L; i++)
			arrL[i] = arr[l +i];
		for(int i = 0; i < R; i++)
			arrR[i] = arr[m + i + 1];
		int i = 0, j = 0, k = l;
		while(k <= r) {
			if(i == L) {
				arr[k++] = arrR[j++];
				continue;
			}
			if(j == R) {
				arr[k++] = arrL[i++];
				continue;
			}
			if(arrL[i] > arrR[j])
				arr[k++] = arrR[j++];
			else
				arr[k++] = arrL[i++];
		}
	}
	
	static void mergeSort(int[] a, int l, int r) {
		if(r > l) {
			int m = l + (r - l) / 2;
			mergeSort(a, l, m );
			mergeSort(a, m +1 , r);
			merge(a, l, m, r);
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		
		mergeSort(a, 0, n -1);
		for(int i : a)
			System.out.printf("%d ", i);
	}
}