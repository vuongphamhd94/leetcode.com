package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[][] = new int[n + 1][n+ 1];
		for(int i = 0; i< m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			a[x][y] = a[y][x] = 1;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++)
				System.out.print(a[i][j] + " ");
			
			System.out.println();
		}
	}
}
