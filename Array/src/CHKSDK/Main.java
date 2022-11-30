package CHKSDK;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void in(char[][] arr) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(String.format("%2s", arr[i][j]));
			}
			System.out.println();
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		char[][] a = new char[9][9];
		int T = sc.nextInt();
		int[] dem = new int[10];
		int index;

		for (int tc = 1; tc <= T; tc++) {
			int rs = 1;
			for (int i = 0; i < 9; i++) {
				String s = sc.next();
				for (int j = 0; j < 9; j++)
					a[i][j] = s.charAt(j);
			}
			// check hang ngang
			for (int i = 0; i < 9; i++) {
				if(rs == 0)
					break;
				for(int j = 0; j < 10; j++)
					dem[j] = 0;
				for(int j = 0; j < 9; j++) {
					
					if(a[i][j] == '.')
						continue;
					
					index = a[i][j] - '0';
					dem[index]++;
					
					if(dem[index] == 2) {
						rs = 0;
						break;
					}
				}	
			}
			if(rs == 0) {
				System.out.printf("#%d 0", tc);
				continue;
			}
			//check cot
			for (int j = 0; j < 9; j++) {
				if(rs == 0)
					break;
				for(int i = 0; i < 10; i++)
					dem[i] = 0;
				for(int i = 0; i < 9; i++) {
					
					if(a[i][j] == '.')
						continue;
					
					index = a[i][j] - '0';
					dem[index]++;
					
					if(dem[index] == 2) {
						rs = 0;
						break;
					}
				}	
			}
			if(rs == 0) {
				System.out.printf("#%d 0", tc);
				continue;
			}
			// check duong cheo trai - phai
			for(int i = 0 ; i < 10; i++)
				dem[i] = 0;
			
			for(int i = 0; i < 9; i++) {
				if(a[i][i] == '.') {
					
				}
	
			}
		}
	}
}
