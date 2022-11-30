package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ApsBai17 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] a = new int[n][m];
			int [][] b = new int[2][n*m];
			int count = 0;
			for(int i = 0; i< n; i++)
				for(int j = 0; j < m; j++) {
					a[i][j] = sc.nextInt();
					if(a[i][j] != 0) {
						b[0][count] = i;
						b[1][count] = j;
						count++;
					}
				}
			
			
			for(int i = 0; i < count; i++) {
				boolean check = false;
				int x = b[0][i];
				int y = b[1][i];
				switch (a[x][y]) {
				case 1:
					if(x != 0 && !check) 
						check = a[x-1][y] == 2 || a[x-1][y] == 3 ||a[x-1][y] == 5 ||a[x-1][y] == 7;
					
					if(y != 0 && !check)
						check = a[x][y - 1] == 3 ||a[x][y - 1] == 4 || a[x][y - 1] == 6 || a[x][y - 1] == 7;
					break;
				case 2:
					if(y != 0 && !check)
						check = a[x][y -1] == 3 || a[x][y -1] == 4 || a[x][y -1] == 6 || a[x][y -1] == 7;
					
					if(x != n -1 && !check)
						check = a[x+1][y] == 1 || a[x+1][y] == 4 || a[x+1][y] == 5||  a[x+1][y] == 7;
					
					break;
					
				case 3:
					if(x != n -1 && !check)
						check = a[x+1][y] == 1 || a[x+1][y] == 4|| a[x+1][y] == 5||a[x+1][y] == 7;
					
					if(y != n -1 && !check)
						check = a[x][y + 1] == 1||a[x][y + 1] == 2||a[x][y + 1] == 6||a[x][y + 1] == 7;
					break;
					
				case 4:
					if(x != 0 && !check)
						check = a[x - 1][y] == 2||a[x - 1][y] ==3||a[x - 1][y] ==5||a[x - 1][y] ==7;
					
					if(y != n -1 && !check)
						check = a[x][y + 1] == 1||a[x][y + 1] == 2 || a[x][y + 1]==6||a[x][y + 1] == 7;
					break;
					
				case 5:
					if(x != n -1 && !check)
						check = a[x+1][y] == 1||a[x+1][y] == 4||a[x+1][y] == 5||a[x+1][y] == 7;
					
					if(x != 0 && !check)
						check = a[x - 1][y] == 2|| a[x - 1][y] == 3|| a[x - 1][y] == 5|| a[x - 1][y] == 7;
					break;
					
				case 6:
					if(y != n -1 && !check)
						check = a[x][y + 1] == 1|| a[x][y + 1] == 2|| a[x][y + 1] == 6|| a[x][y + 1] == 7;
					
					if(y != 0 && !check)
						check = a[x][y - 1] == 3||a[x][y - 1] == 4||a[x][y - 1] == 6||a[x][y - 1] == 7;
					break;
					
				case 7:
					if(x != n -1 && !check)
						check = a[x+1][y] == 1||a[x+1][y] == 4||a[x+1][y] == 5||a[x+1][y] == 7;
					
					if(x != 0 && !check)
						check = a[x - 1][y] == 2||a[x - 1][y] == 3||a[x - 1][y] == 5||a[x - 1][y] == 7;
					
					if(y != n -1 && !check)
						check = a[x][y + 1] == 1||a[x][y + 1] == 2||a[x][y + 1] == 6||a[x][y + 1] == 7;
					
					if(y != 0 && !check)
						check = a[x][y - 1] == 3||a[x][y - 1] == 4||a[x][y - 1] == 6||a[x][y - 1] == 7;
					break;
				default:
					continue;
				}
				
				if(!check)
					System.out.println((x + 1) + " " + (y + 1));
			}
		}
	}

}
