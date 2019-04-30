package testDemo;

public class Demo04 {
	public static void main(String[] args) {
		System.out.println(f(1));
		System.out.println(f(1, 2));
		System.out.println(f(1, 2, 3));
	}

	public static int f(int x) {
		return x * x;
	}
	public static int f(int x, int y) {
		return x * x + y * y;
	}
	public static int f(int x, int y, int z) {
		return x * x + y * y + z * z;
	}
}