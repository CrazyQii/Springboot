package crazyqiqi.day01.demo04;

public class GetSum {
	public static void main(String[] args) {
		int sum = 0;
		int data = 1;
		while(data < 100) {
			data += 2;
			sum += data;
		}
		System.out.println("100以内奇数的和：" + sum);
	}
}
