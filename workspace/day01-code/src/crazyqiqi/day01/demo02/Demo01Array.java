package crazyqiqi.day01.demo02;
//求数组当中最大的值
public class Demo01Array {
	public static void main(String[] args) {
		//声明创建一个数组
		int[] Array = new int[] {10, 20, 10, 15, 23, 99, 56, 45};
		//获取数组的长度
		int length = Array.length;
		//求得数组中的最大值
		int i, max = Array[0], min = Array[0];
		for (i = 1; i < length; i++) {
			if (Array[i] >= max) {
				max = Array[i];
			}
			if (Array[i] <= min) {
				min = Array[i];
			}
		}
		System.out.println("最大的值为：" + max);
		System.out.println("最小的值为：" + min);
	}
}
