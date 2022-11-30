package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
static int addGcb(int a, int m) {
	int uMax = 1;
	for(int i = 2; i <= a; i++) {
		if(m % i == 0 && a % i == 0)
			uMax = i;
	}
	
	int rs = 1;
	
	for(int i = 1; i < m; i++) {
		int j;
		
		for(j = m; j>= uMax; j--)
			if((a + i) % j == 0 && m % j == 0)
				break;
		
		if( j == uMax)
			rs++;
	}
	
	return rs;
}
	
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		System.out.println(addGcb(37, 102));

	}
}
