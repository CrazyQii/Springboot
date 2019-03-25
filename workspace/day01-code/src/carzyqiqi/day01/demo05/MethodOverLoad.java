package carzyqiqi.day01.demo05;

/* 
 * 方法重载：
 * 在一个类中定义多个同名的方法，但方法的参数互不相同
 * 方法重载的注意事项
 * 1.形参的个数不同
 * 2.形参的数据类型不同
 * 3.形参的位置不同                                                                                                                                                                                                                                                                                                                                       
*/
public class MethodOverLoad {
	public static void main(String[] args) {
		System.out.println(sum(4, 5));
		System.out.println(sum(78, 56.0));
		System.out.println(sum(4, 2, 6));
		
	}
	public static int sum(int a, int b) {
		return a + b;
	}
	public static int sum(int a, int b, int c) {
		return a + b + c;
	}                                                             
	public static double sum(int a, double b) {
		return a + b;
	}
}
