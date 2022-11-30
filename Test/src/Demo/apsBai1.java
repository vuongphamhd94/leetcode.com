package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class apsBai1 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int count = 0;
			int[][] a = new int[m][n];
			int[][] b = new int [m][n];
			// nhap mang
			for(int i = 0; i < m; i++)
				for(int j = 0; j<n; j++)
					a[i][j] = sc.nextInt();
			//danh dau vi tri lon nhat cua hang (++)
			for(int i = 0; i< m; i++) {
				int c = 0;
				int[] arr = new int[n];
				arr[0] = 0;
				for(int j = 1; j < n; j++) {
					if(a[i][j] > a[i][arr[0]]) {
						c = 0;
						arr[0] = j;
						continue;
					}
					if(a[i][j] == a[i][arr[0]]) {
						c++;
						arr[c] = j;
					}
				}
				for(int k = 0; k <= c; k++)
					b[i][arr[k]]++;
			}
			// danh dau vi tri lon nhat cua cot (++)
			for(int j = 0; j < n; j++) {
				int c = 0;
				int[] arr = new int[m];
				arr[0] = 0;
				for(int i = 1; i < m; i++) {
					if(a[i][j] > a[arr[0]][j]) {
						c = 0;
						arr[0] = i;
						continue;
					}
					
					if(a[i][j] == a[arr[0]][j]) {
						c++;
						arr[c] = i;
					}
				}
				for(int k = 0; k <= c; k++)
					b[arr[k]][j]++;
			}
			// dem vi tri thoa ma(==2)
			for(int i = 0; i < m; i++)
				for(int j = 0; j < n; j++)
					if(b[i][j] == 2)
						count++;
			
			System.out.println("#" + tc + " " + count);
			
		}
	}
}
