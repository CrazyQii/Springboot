package lqHanday04.demo01;

class People {
	private String name;
	private int age;
	
	//默认构造方法
	public People() {
		name = "HanLq";
		age = 18;
		System.out.println("调用父类的构造方法");
	}
	//带参构造方法
	public People(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	public void sayNowAge() {
		System.out.println(name + " 现在已经 " + age + " 岁了！");
	}
}

class Young extends People {
	public Young() {
		System.out.println("调用子类的构造方法");
	}
	int nowAge = 0;
	public void sayYoungAge(int years) {
		nowAge = getAge() - years;
		System.out.println(years + " 年前 " + getName() + " " + nowAge + " 岁 ");
	}
	
	public void sayNowAge() {
		//直接使用父亲的方法
		super.sayNowAge();
		System.out.println("今年 " + getName() + " " + getAge() + " 岁 ");
	}
}

public class LqHandemo01 {

	public static void main(String[] args) {
		People p1 = new People("qiqi", 20);
		Young y1 = new Young();
		Young y2 = new Young();
		
		p1.setAge(30);
		p1.sayNowAge();
		
		y1.setAge(25);
		y1.sayYoungAge(10);
		
		//引用了super语法
		y2.setAge(10);
		y2.sayNowAge();
		
	}

}
