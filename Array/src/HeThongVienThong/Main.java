package HeThongVienThong;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input3.txt"));
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			char[][] arr = new char[m][n];

			for (int row = 0; row < m; row++) {
				String str = sc.next();
				for (int col = 0; col < n; col++) {
					arr[row][col] = str.charAt(col);
				}
			}
			
			System.out.println("mang nhap vao: ");
			InMang(arr, m, n);

			for (int row = 0; row < m; row++) {
				for (int col = 0; col < n; col++) {

					if (arr[row][col] == 'A')
						VungSong(arr, m, n, row, col, 1);

					if (arr[row][col] == 'B')
						VungSong(arr, m, n, row, col, 2);

					if (arr[row][col] == 'C')
						VungSong(arr, m, n, row, col, 3);
				}
			}
			
			System.out.println("mang sau khi inh phu song: ");
			InMang(arr, m, n);
			
			int count = 0;

			for (int row = 0; row < m; row++) {
				for (int col = 0; col < n; col++) {
					if (arr[row][col] == 'H') {
						count++;
					}
				}
			}

			System.out.println("#" + i + " " + count);
		}

	}

	public static void VungSong(char[][] arr, int m, int n, int row, int col, int s) {
		for (int i = 1; i <= s; i++) {
			if (row - i >= 0 && arr[row - i][col] == 'H')
				arr[row - i][col] = 'O';

			if (row + i < m && arr[row + 1][col] == 'H')
				arr[row + 1][col] = 'O';

			if (col - i >= 0 && arr[row][col - i] == 'H')
				arr[row][col - i] = 'O';

			if (col + i < n && arr[row][col + i] == 'H')
				arr[row][col + i] = 'O';
		}
	}
	public static void InMang(char[][] arr, int row, int col) {
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
