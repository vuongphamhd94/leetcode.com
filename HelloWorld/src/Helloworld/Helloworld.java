package Helloworld;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Helloworld {
	static int[][] arr = new int[5][5];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		CheoXuong(5);
//		printArr(5, arr);
		
		XoanOc(5);
	}
	public static void CheoXuong(int n) {
		int count = 1;
		for(int k = n -1; k>=0; k--) {
			for(int i= k, j = 0; i < n; i++, j++ ) {
				arr[i][j] = count ++;
			}
		}
		for(int k = 1; k<n; k++) {
			for(int i = 0, j = k; j<n;i++, j++) {
				arr[i][j]=count++;
			}
		}
	}
	public static void CheoXuongXenKe(int n) {
		int count=1;
	}
	
	
	public static void XoanOc(int n) {
		int top = 0, left = 0, right = n-1, buttom = n-1;
		int count = 1;
		int i;
		while(count <= n*n) {
			//top: left ~ right
			for(i = left; i<=right; i++) {
				arr[top][i]=count++;
			}
			top++;
			//right: top ~ bottum
			for(i = top; i<= buttom; i++) {
				arr[i][right] = count++;
			}
			right--;
			// buttom: right~left
			for(i = right; i>= left; i--) {
				arr[buttom][i] = count++;
			}
			buttom--;
			//left: buttom ~ top
			for(i = buttom; i>= top; i--) {
				arr[i][left] = count++;
			}
			left++;
		}
		printArr(n);
	}
	
	
	public static void printArr(int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
