package crazyqiqi.day02.demo02;

public class DemoPerson {
	public static void main(String[] args) {
		Person p1 = new Person(18, "吴彦祖");	//对象实例化
		
		p1.setAge(20); //改变设置age的值
		p1.setName("韩林岐");	//改变name的值
		System.out.println("我叫" + p1.getName() + ", " + "我的年龄是：" + p1.getAge());
	}
}
