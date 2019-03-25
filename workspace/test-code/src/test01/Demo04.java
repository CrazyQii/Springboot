package test01;

//导包
import java.util.Scanner;

public class Demo04 {
	public static void main(String[] args) {
		int a, b;
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入两个整形数字：");
		a = sc.nextInt();
		b = sc.nextInt();
		if (a > b) {
			System.out.println("较大的数字为：" + a);
		} else {
			System.out.println("较大的数字为：" + b);
		}
		System.out.println("条件运算符得到较大的数字为：" + (a > b ? a : b));
	}
}
