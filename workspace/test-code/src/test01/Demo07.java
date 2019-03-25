package test01;

import java.util.Scanner;

public class Demo07 {
	public static void main(String[] args) {
		int a;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("输入一个数字 n：");
		
		a = sc.nextInt();
		System.out.println("n！ = " + fac(a));
	}
	
	
	public static long fac(int n) {
		if (n == 1) {
			return 1;
		}
		else {
			return n * fac(n - 1);
		}
	}
}
