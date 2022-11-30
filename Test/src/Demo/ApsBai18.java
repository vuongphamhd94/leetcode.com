package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai18 {
	
	static int checkHang(int[][]a,int n, int row, int col) {
		int k = 1;
		while(col + k < n && a[row][col] == a[row][col + k]) {
			k++;
		}
		if( k==5) {
			if(col == 0 || col == n -1 || a[row][col] == 0 || a[row][col + k] == 0)
				return 2;
		}
		if(k == 4) {
			if((col-1>=0 && col+ k < n) &&(a[row][col - 1] == 0 && a[row][col + k] == 0) && 
			(col - 1 == 0 || col + k == n - 1 || a[row][col -2] == 0 || a[row][col + k + 1] == 0 ))
				return 2;
			
			
		}
		return 0;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i< n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			
			for(int i = 0; i< n; i++) {
				for(int j = 0; j<n; j++)
					System.out.print(a[i][j] + " ");
				System.out.println();
			}
			int rs = 0;
			
			for(int i = 0; i< n; i++) {
				if(rs == 1)
					break;
				for(int j = 0; j < n; j++) {
					if(a[i][j] == 0)
						continue;
					if(checkHang(a, n, i, j) == 2) {
						rs = 1;
						break;
					}
				}
			}
			System.out.println(rs);
		}
	}
}
