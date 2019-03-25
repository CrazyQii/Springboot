package crazyqiqi.day02.demo01;

/*
 * 类是一种引用数据类型
 * 1.导包
 * 如果需要使用的目标类和当前类(含有main函数)处于同一个包下面的就不需要导包
 * 2.创建
 * 3.使用
 */

public class MyPhone01 {
	public static void main(String[] args) {
		//创建对象实例化
		//类名称  对象名  = new 类名称()
		Phone p1 = new Phone();
		
		//给p1的属性赋值
		p1.brand = "Apple";
		p1.price = 8899;
		p1.color = "black";
		p1.size = "large";
		
		//给p1的方法传递参数
		p1.call("hlq");
		p1.watchVideo();
		p1.listenMusic("大城小爱");
		
	}
}
