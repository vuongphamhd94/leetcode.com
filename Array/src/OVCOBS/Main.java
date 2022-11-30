package OVCOBS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input10.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
	
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j< N; j++)
				arr[i][j] = sc.nextInt();
		
		int count = SoBuocNhay(arr, N, row, col, arr[row][col], 0);
		System.out.println("#" + tc + " " + count);
		}
	}
	
	public static int SoBuocNhay(int[][] arr, int n, int row, int col, int height, int count) {
		
		int nextRow = row, nextCol = col, nextHeight = height;
		
		for(int i = row -1; i <= row +1; i++)
			for(int j = col -1; j <= col + 1 ; j++) 
				if(i >= 0 && i < n & j >=0 && j<n  && nextHeight < arr[i][j]) {
					if(i == row && j == col)
						continue;
					nextHeight = arr[i][j];
					nextRow = i;
					nextCol = j;
				}

		if(nextHeight == height)
			return count;
		else {
			for(int i = row -1; i <= row +1; i++)
				for(int j = col -1; j <= col + 1 ; j++) 
					if(i >= 0 && i < n & j >=0 && j<n  && nextHeight > arr[i][j] && arr[i][j] > height) {
						if(i == row && j == col)
							continue;
						nextHeight = arr[i][j];
						nextRow = i;
						nextCol = j;
					}
			return SoBuocNhay(arr, n, nextRow, nextCol, nextHeight, ++count);
		}
	}
}
