package crazyqiqi.day02.demo01;

/*定义一个类，用来模拟手机事物
 * 
 * 手机事物由两部分组成
 * 属性：品牌、价格、颜色、大小
 * 行为：打电话、看视频、听音乐
 * 
 * 对应到类中
 * 成员变量：
 * 		String brand
 * 		double price
 * 		String color
 * 		String size
 * 成员方法：
 * 		public void call(String who) {}
 * 		public void watchVideo() {}
 * 		public void listenMusic(String which) {}
 */

public class Phone {
	
	//成员变量
	String brand;
	double price;
	String color;
	String size;
	
	//成员方法
	public void call(String who) {
		System.out.println("我在给" + who + "打电话！");
	}
	public void watchVideo() {
		System.out.println("我可以看电视剧！");
	}
	public void listenMusic(String music) {
		System.out.println("我可以听" + music + "音乐");
	}
}
