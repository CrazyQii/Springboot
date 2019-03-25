package crazyqiqi.day02.demo02;

/*
 *  构造方法：
 *  public 类名(数据类型 形式参数) {
 *  	没有return
 *  	没有返回值，没有修饰符
 *  }
 * 
 */
public class Person {
	
	//成员变量
	private int age;
	private String name;
	
	public Person(int age, String name) {	//构造有参方法----初始化对象
		this.age = age;
		this.name = name;
	}
	
	public void setAge(int age) {	//设置方法，用于设置age
		if (age < 0 || age > 200) {
			System.out.println("数据有误！");
		} else {
			this.age = age;
		}
	}
	
	public int getAge() {	 //读取方法，一般用于读取age
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {	//读取方法，一般用于读取name
		return name;
	}
	
}
