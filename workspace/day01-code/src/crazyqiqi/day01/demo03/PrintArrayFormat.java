package crazyqiqi.day01.demo03;

/*
 * 按指定格式输出数组：[10, 20, 30, 40, 50]
 */

public class PrintArrayFormat {
	public static void main(String[] args) {
		int[] array = { 10, 20, 30, 40, 50, 100 };
		arrayFormat(array);
	}
	/*
	 * 构造方法：
	 * 方法名：arrayFormat
	 * 返回值：无
	 * 参数：array
	 */
	public static void arrayFormat(int[] array) {
		int i;
		System.out.print("[");
		for (i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.print(array[array.length - 1] + "]");
	}
}
