package topic.demo;

import java.util.Scanner;

public class CelsiusConverter {

	public static void main(String[] args) {
		System.out.println("请输入要转换的温度：");
//		输入信息
		Scanner sc = new Scanner(System.in);
		double celsius = sc.nextDouble();
//		创建方法所在类的对象
		CelsiusConverter converter = new CelsiusConverter();
//		通过对象调用方法
		double Fahrenheit = converter.getFahrenheit(celsius);
		System.out.println("转换完成的温度： "+ Fahrenheit);
	}

	
	// getFahrenheit()方法将摄氏度转换成华氏度
	public double getFahrenheit(double celsius) {
		double fahrenheit = 1.8 * celsius + 32;
		return fahrenheit;
	}
}
