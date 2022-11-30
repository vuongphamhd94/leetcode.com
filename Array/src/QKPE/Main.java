package QKPE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
	public static void InMang(int[][] arr, int row, int col) {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static boolean KiemTraViTri(int[][] arr, int m, int n, int row, int col) {

		if (row < 0 || col < 0 || row == m || col == n) {
			return false;
		}

		if (arr[row][col] != 0 && arr[row][col] != 1) {
			return false;
		}

		return true;
	}
	
	public static void Q(int[][] arr, int m, int n, int row, int col) {
		
		// kiem tra duong doc ngang
		int i = row, j = col;
		while(KiemTraViTri(arr, m, n, --i, j)) {
			arr[i][j] = 1;
		}
		
		 i = row;
		 j = col;
		while(KiemTraViTri(arr, m, n, ++i, j)) {
			arr[i][j] = 1;
		}
		
		 i = row;
		 j = col;
		while(KiemTraViTri(arr, m, n, i, --j)) {
			arr[i][j] = 1;
		}
		
		i = row;
		 j = col;
		while(KiemTraViTri(arr, m, n, i, ++j)) {
			arr[i][j] = 1;
		}
		
		// kiem tra cac duong cheo
		i = row;
		 j = col;
		while(KiemTraViTri(arr, m, n, --i, ++j)) {
			arr[i][j] = 1;
		}
		
		i = row;
		j = col;
		while(KiemTraViTri(arr, m, n, ++i, --j)) {
			arr[i][j] = 1;
		}
		
		i = row;
		j = col;
		while(KiemTraViTri(arr, m, n, ++i, ++j)) {
			arr[i][j] = 1;
		}
		
		i = row;
		j = col;
		while(KiemTraViTri(arr, m, n, --i, --j)) {
			arr[i][j] = 1;
		}
		
	}
	
	public static void K(int[][] arr, int m, int n, int row, int col) {
		
		if(KiemTraViTri(arr, m, n, row + 1, col + 2))
			arr[row + 1][col + 2] = 1;
		
		if(KiemTraViTri(arr, m, n, row + 1, col - 2))
			arr[row + 1][col - 2] = 1;
		
		if(KiemTraViTri(arr, m, n, row - 1, col + 2))
			arr[row - 1][col + 2] = 1;
		
		if(KiemTraViTri(arr, m, n, row - 1, col - 2))
			arr[row - 1][col - 2] = 1;
		
		if(KiemTraViTri(arr, m, n, row + 2, col + 1))
			arr[row + 2][col + 1] = 1;
		
		if(KiemTraViTri(arr, m, n, row + 2, col - 1))
			arr[row + 2][col - 1] = 1;
		
		if(KiemTraViTri(arr, m, n, row - 2, col + 1))
			arr[row - 2][col + 1] = 1;
		
		if(KiemTraViTri(arr, m, n, row - 2, col - 1))
			arr[row - 2][col - 1] = 1;
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input4.txt"));
		Scanner sc = new Scanner(System.in);
		int m = 0; int n =0;
		
		int k, i, row, col, tc=1;
		
		//Quy uoc: Q ~ 2, k ~ 3, ~ p = 4
		while(true) {
			m = sc.nextInt();
			n = sc.nextInt();
			
			if(m==0 && n== 0)
				break;
			int[][] arr = new int [m][n];
		// danh dau ta ca cac vi tri deu an toan
			for(row = 0; row < m; row++)
				for(col = 0; col < n; col++) 
					arr[row][col] = 0;
			
			//danh dau vi tri Q
			k = sc.nextInt();
			for(i = 0; i < k; i++) {
				row = sc.nextInt() - 1;
				col = sc.nextInt() - 1;
				arr[row][col] = 2;
			}

			//danh dau vi tri K
			k = sc.nextInt();
			for(i = 0; i < k; i++) {
				row = sc.nextInt() - 1;
				col = sc.nextInt() - 1;
				arr[row][col] = 3;
			}
			
			//danh dau vi tri p
			k = sc.nextInt();
			for(i = 0; i < k; i++) {
				row = sc.nextInt() - 1;
				col = sc.nextInt() - 1;
				arr[row][col] = 4;
			}
			
			// danh dau cac vi tri khong an toan
			
			for(row = 0; row < m; row++) 
				for(col = 0; col < n; col++) {
					if(arr[row][col] == 2)
						Q(arr, m, n, row, col);
					if(arr[row][col] == 3)
						K(arr, m, n, row, col);
				}
			
			int count = 0;
			
			for(row = 0; row < m; row++) 
				for(col = 0; col < n; col++) {
					if(arr[row][col] == 0)
						count++;
				}
			System.out.println("Board " + tc + " has " +count + " safe squares.");
			tc++;
		}
	}
}
